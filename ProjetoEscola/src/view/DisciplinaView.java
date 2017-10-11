package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

import javax.swing.*;

import model.Disciplina;
import persistencia.ConectionFactory;
import persistencia.DisciplinaDAO;

public class DisciplinaView extends JFrame {
	private JLabel titulo = new JLabel();
	private JLabel lblId = new JLabel("ID: ");
	private JTextField txtId = new JTextField("");
	private JLabel lblNome = new JLabel("Nome: ");
	private JTextField txtNome = new JTextField("");
	private JLabel lblDesc = new JLabel("Descrição: ");
	private JTextArea txtDesc = new JTextArea("");
	private JLabel lblDay = new JLabel("Dias de Aula:");
	private JTextField txtDay = new JTextField("");
	private JLabel lblTime = new JLabel("Horario: ");
	private JTextField txtTime = new JTextField("");
	private JButton btnCad = new JButton("Cadastrar");
	private JButton btnLimpar = new JButton("Limpar");

	public DisciplinaView() {
		editarTela();
		editarComponentes();
		this.btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Erro de validação de campos vazios
				
				if(txtNome.getText() == "" && txtDesc.getText() == "" && txtDay.getText() == "" && txtTime.getText() == "") {
					JOptionPane.showMessageDialog(null, "A campos vazios,Porfavor preencha-os");
				}else {

					try {
						Connection conn = new ConectionFactory().conexao();
						DisciplinaDAO disDao = new DisciplinaDAO(conn);
						Disciplina disInsert = new Disciplina(txtNome.getText(),txtDesc.getText() , txtDay.getText(), txtTime.getText());
						disDao.insert(disInsert);
						JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso");
					} catch (Exception e1) {					
						JOptionPane.showMessageDialog(null, "Falha ao Cadastrar");
					}finally {
						new ConectionFactory().desconecta();
					}
				}
			}
		});

		this.btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtDesc.setText("");
				txtDay.setText("");
				txtTime.setText("");
			}
		});
	}
	
	
	public void editarComponentes() {
		lblId.setBounds(10,5,50,25);
		add(lblId);
		txtId.setBounds(110,5,50,25);
		add(txtId);
		txtId.setEnabled(false);

		lblNome.setBounds(10,35,50,25);
		add(lblNome);
		txtNome.setBounds(110,30,250,25);
		add(txtNome);

		lblDesc.setBounds(10,65,100,25);
		add(lblDesc);
		txtDesc.setBounds(110,60,250,100);
		add(txtDesc);

		lblDay.setBounds(10,170,100,25);
		add(lblDay);
		txtDay.setBounds(110,165,250,25);
		add(txtDay);

		lblTime.setBounds(10,205,100,25);
		add(lblTime);
		txtTime.setBounds(110,200,250,25);
		add(txtTime);

		btnCad.setBounds(50,240,150,25);
		add(btnCad);
		btnLimpar.setBounds(250,240,100,25);
		add(btnLimpar);
	}
	public void editarTela() {
		add(this.titulo);
		setLayout(null);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
