package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

import model.Usuario;
import persistencia.ConectionFactory;
import persistencia.UsuarioDAO;

public class UsuarioCadastroView extends JFrame{

	ConectionFactory conn = new ConectionFactory();
	private JLabel lblTitulo = new JLabel("Cadastro de Usuario");
	private JLabel lblID = new JLabel("ID: ");
	private JTextField txtID = new JTextField("");
	private JLabel lblLogin = new JLabel("Login: ");
	private JTextField txtLogin = new JTextField("");
	private JLabel lblSenha = new JLabel("Senha: ");
	private JTextField txtSenha = new JTextField("");
	private JLabel lblNivel = new JLabel("Nivel de Acesso: ");
	private JTextField txtNivel = new JTextField("");
	
	private JButton btnCad = new JButton("Cadastrar");
	private JButton btnVoltar = new JButton("Voltar");
	private JButton btnLimpar = new JButton("Limpar");
	public UsuarioCadastroView() {
		editarTela();
		conn.conexao();
		
		txtID.setBounds(150, 10, 50, 25);
		add(txtID);
		lblID.setBounds(10, 10, 100, 25);
		add(lblID);		
		txtID.setEnabled(false);
		
		txtLogin.setBounds(150, 50, 300, 25);
		add(txtLogin);
		lblLogin.setBounds(10, 50, 100, 25);
		add(lblLogin);
		
		txtSenha.setBounds(150, 90, 300, 25);
		add(txtSenha);
		lblSenha.setBounds(10, 90, 100, 25);
		add(lblSenha);
		
		txtNivel.setBounds(150, 130, 300, 25);
		add(txtNivel);
		lblNivel.setBounds(10, 130, 150, 25);
		add(lblNivel);
		
		btnCad.setBounds(10, 170, 150, 25);
		add(btnCad);
		
		btnCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Cadastrar Usuario
				
				try {
					Usuario user = new Usuario(txtLogin.getText(), txtSenha.getText(), Integer.parseInt(txtNivel.getText()));
					UsuarioDAO userDao = new UsuarioDAO();
					userDao.insert(user);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso");
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Falha ao Cadastrar: "+e1);
				}
				
				
			}
		});
				
		btnVoltar.setBounds(176, 170, 150, 25);
		add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministradorView adm = new AdministradorView();
				adm.setVisible(true);
				dispose();
			}
		});
		
		btnLimpar.setBounds(340, 170, 150, 25);
		add(btnLimpar);
		
		btnLimpar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtLogin.setText("");
				txtSenha.setText("");
				txtNivel.setText("");
			}
		});
		
		conn.desconecta();
	}
	
	public void editarTela() {
		add(this.lblTitulo);
		setSize(500,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
