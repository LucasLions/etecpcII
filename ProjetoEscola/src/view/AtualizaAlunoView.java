package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Aluno;
import persistencia.AlunoDAO;

public class AtualizaAlunoView extends JFrame {
	private JLabel titulo = new JLabel("Atualizar cadastro - Professor");
	private JLabel lblID = new JLabel("ID: ");
	private JTextField txtId = new JTextField();
	private JLabel lblNome = new JLabel("Nome: ");
	private JTextField txtNome = new JTextField();
	private JLabel lblTel = new JLabel("Telefone: ");
	private JTextField txtTel = new JTextField();
	private JLabel lblEnd = new JLabel("Endereço: ");
	private JTextField txtEnd = new JTextField();
	private JLabel lblCpf = new JLabel("CPF: ");
	private JTextField txtCpf = new JTextField();
	private JLabel lblRg = new JLabel("Rg: ");
	private JTextField txtRg = new JTextField();
	
	private JButton btnAtualizar = new JButton("Atualizar");
	private JButton btnVoltar = new JButton("Voltar");

	public AtualizaAlunoView() {
		editTela();
		editComponentes();
	}
	
	public void editComponentes() {
		lblID.setBounds(10,10,100,25);
		add(lblID);
		txtId.setBounds(100, 10, 200, 25);
		add(txtId);
		
		lblNome.setBounds(10, 40, 100, 25);
		add(lblNome);
		txtNome.setBounds(100, 40, 200, 25);
		add(txtNome);
		
		lblTel.setBounds(10, 70, 100, 25);
		add(lblTel);
		txtTel.setBounds(100, 70, 200, 25);
		add(txtTel);
		
		lblEnd.setBounds(10, 100, 100, 25);
		add(lblEnd);
		txtEnd.setBounds(100, 100, 200, 25);
		add(txtEnd);
		
		lblCpf.setBounds(10, 130, 100, 25);
		add(lblCpf);
		txtCpf.setBounds(100,130,200,25);
		add(txtCpf);
		
		lblRg.setBounds(10, 160, 100, 25);
		add(lblRg);
		txtRg.setBounds(100, 160, 200, 25);
		add(txtRg);
		
		btnAtualizar.setBounds(10, 210, 100, 25);
		add(btnAtualizar);
		
		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Aluno aluno = new Aluno(txtNome.getText(), Integer.parseInt(txtTel.getText()), txtEnd.getText(), Integer.parseInt(txtCpf.getText()), txtRg.getText());
					AlunoDAO dao = new AlunoDAO();
					dao.update(aluno);
					
					JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
					new AtualizaAlunoView();
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro\n Erro:"+e1);
				}
				
			}
		});
		
		
		
		btnVoltar.setBounds(200, 210, 100, 25);
		add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AlunoView().setVisible(true);
				dispose();
			}
		});
		
	}
	
	public void editTela() {
		this.add(this.titulo);
		this.setSize(350,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}

}
