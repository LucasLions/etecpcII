package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interface2.App;
import model.UserSistema;
import persistencia.Conexao;
import persistencia.UserSistemaDAO;

public class LoginPanel extends JFrame{

	private App app;
	private JLabel tituloPanel = new JLabel ("Interface Java"); 
	private JLabel lblLogin = new JLabel ("Login"); 
	private JTextField txtLogin  =  new JTextField("");
	private JLabel lblSenha = new JLabel ("Senha"); 
	private JPasswordField passFieldSenha = new JPasswordField("");
	private JButton btnEntrar = new JButton ("Entrar");
	
	public LoginPanel(App app){
		this.app = app;
		this.add(this.tituloPanel);		
		this.setSize(400,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		
		//Posicionando o Login
		lblLogin.setBounds(50, 0, 50, 50);
		add(lblLogin);		
		txtLogin.setBounds(90, 10, 250, 25);
		add(txtLogin);
		//Posicionandi a Senha
		lblSenha.setBounds(50, 30, 50, 50);
		add(lblSenha);		
		passFieldSenha.setBounds(90, 50, 250, 25);
		add(passFieldSenha);
		
		//Posicionando o Botão
		btnEntrar.setBounds(150, 100, 100, 25);
		add(btnEntrar);
		this.btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {			

				String nomeDoUsuarioQueQuerLogar = LoginPanel.this.txtLogin.getText(); 
				String senhaDoUsuarioQueQuerLogar = LoginPanel.this.passFieldSenha.getText();
				System.out.println();
				App app2 = LoginPanel.this.app;
				List<UserSistema> usuariosCadastrados = LoginPanel.this.app.getUsuariosCadastrados();
				
				for (UserSistema u : LoginPanel.this.app.getUsuariosCadastrados()) {
					if(u.getLogin().equals(nomeDoUsuarioQueQuerLogar) && u.getSenha().equals(senhaDoUsuarioQueQuerLogar)) {
						LoginPanel.this.app.getUsuariosLogados().add(u);
						System.out.println("Usuario logado com sucesso");
						System.out.println(u.getNome());
						System.out.println(u.getLogin());
						break;
					}//if
				}//for
				System.out.println("Usuario ou Senha nao conferem!!!");
			}
		});		
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		new App();
	}
	
}
