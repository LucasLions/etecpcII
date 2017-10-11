package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import persistencia.ConectionFactory;

public class AlunoView extends JFrame{
	private JLabel titulo = new JLabel("Professor");
	private JLabel lblID = new JLabel("ID: ");
	private JTextField txtID = new JTextField();
	private JLabel lblNome = new JLabel("Nome: ");
	private JTextField txtNome = new JTextField();
	private JLabel lblTel = new JLabel("Telefone: ");
	private JTextField txtTel = new JTextField();
	private JLabel lblEnd = new JLabel("EndereÃ§o: ");
	private JTextField txtEnd = new JTextField();
	private JLabel lblCPF = new JLabel("CPF: ");
	private JTextField txtCpf = new JTextField();
	private JLabel lblRG = new JLabel("RG: ");
	private JTextField txtRg = new JTextField();
	
	private JMenuBar menu = new JMenuBar();
	private JMenu op = new JMenu("Opções");
	private JMenuItem itemAtualizar = new JMenuItem("Atualizar Cadastro");
	private JMenuItem itemNota = new JMenuItem("Ver Nota");
	private JMenuItem itemProf = new JMenuItem("Seus Professores");
	private JMenuItem itemSair = new JMenuItem("Sair");
	
	public AlunoView() {
		this.add(this.titulo);
		this.setSize(500,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);	
		

		setJMenuBar(menu);
		menu.add(op);
		op.add(itemAtualizar);
		op.add(itemNota);
		op.add(itemProf);
		op.add(itemSair);
		
		lblID.setBounds(10, 5, 50, 25);
		add(lblID);
		txtID.setBounds(225, 5, 50, 25);
		add(txtID);
		
		lblNome.setBounds(10, 40, 100, 25);
		add(lblNome);
		txtNome.setBounds(225, 35, 250, 25);
		add(txtNome);
		
		lblTel.setBounds(10,75,100,25);
		add(lblTel);
		txtTel.setBounds(225,70,250,25);
		add(txtTel);
		
		lblEnd.setBounds(10,110,100,25);
		add(lblEnd);
		txtEnd.setBounds(225,105,250,25);
		add(txtEnd);
		
		lblCPF.setBounds(10,145,100,25);
		add(lblCPF);
		txtCpf.setBounds(225,140,250,25);
		add(txtCpf);
		
		lblRG.setBounds(10,180,100,25);
		add(lblRG);
		txtRg.setBounds(225,175,250,25);
		add(txtRg);		
		
		setOnLoad();
		txtID.setEnabled(false);
		txtNome.setEnabled(false);
		txtTel.setEnabled(false);
		txtEnd.setEnabled(false);
		txtCpf.setEnabled(false);
		txtRg.setEnabled(false);
		
		op.add(itemAtualizar);
		op.add(itemNota);
		op.add(itemProf);
		op.add(itemSair);
		
		
		itemAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AtualizaAlunoView().setVisible(true);
				dispose();
			}
		});
	}	
	
	public void setOnLoad() {
		Connection conn;
		try {
				conn = new ConectionFactory().getMysqlConnection();
				String sql = "Select * from tblAluno";
				PreparedStatement stm = conn.prepareStatement(sql);
				ResultSet rs = stm.executeQuery();
				while(rs.next()){	
					txtID.setText(String.valueOf(rs.getInt("idAluno")));
					txtNome.setText(rs.getString("nome"));
					txtTel.setText(rs.getString("telAluno"));
					txtEnd.setText(rs.getString("endAluno"));
					txtCpf.setText(rs.getString("cpf"));
					txtRg.setText(rs.getString("rg"));					
				}	
		} catch (Exception e) {
			System.out.println("Erro: "+e);
		}
	}
	
	public static void main(String[] args) {
		new AlunoView();
	}
}
