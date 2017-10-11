package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import persistencia.ConectionFactory;
import persistencia.UsuarioDAO;

public class Login extends JFrame{
	ConectionFactory conecta = new ConectionFactory();
	
	private JLabel titulo = new JLabel("Tela de Login");
	private ImageIcon image = new ImageIcon(getClass().getResource("light.jpg"));
	private JLabel lblImage = new JLabel(image);	
	private JLabel lblLogin = new JLabel("Login ");
	private JTextField txtLogin = new JTextField("");
	private JLabel lblSenha = new JLabel("Senha ");
	private JPasswordField txtSenha = new JPasswordField();
	private JButton btnEntrar = new JButton("Entrar");
	
	public Login() {
		conecta.conexao();
		this.add(this.titulo);
		this.setSize(500,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		lblImage.setBounds(20, 20, 240, 200);
		add(lblImage);
		
		lblLogin.setBounds(350,20,50,25);
		add(lblLogin);
		txtLogin.setBounds(275,45,200,25);
		add(txtLogin);
		
		lblSenha.setBounds(350,70,100,25);
		add(lblSenha);
		txtSenha.setBounds(275,90,200,25);
		add(txtSenha);

		btnEntrar.setBounds(325,145,100,25);
		add(btnEntrar);
		
		this.btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// Fazer a validação do login com o banco de dados e verificar o nivel de acesso
					UsuarioDAO dao = new UsuarioDAO();
					
					try {
						if(dao.checkLogin(txtLogin.getText(), String.valueOf(txtSenha.getPassword()))) {
							new AdministradorView().setVisible(true);
							new AlunoView().setVisible(true);
							new ProfessorView().setVisible(true);
							dispose();
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao validar: "+e1);
					}
				// FIM
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
}
