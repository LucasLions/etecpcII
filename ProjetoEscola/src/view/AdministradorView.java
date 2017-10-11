package view;

import java.awt.Font;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdministradorView extends JFrame{
	private JLabel titulo = new JLabel();
	private JLabel lblPendente = new JLabel("Solicitações pendentes: 2");
	private Font ftSol = new Font("Arial",Font.BOLD,10);
	private JLabel lblLogado = new JLabel("Olá João Lucas");

	private JLabel lblResult = new JLabel();
	private JLabel lblResult2 = new JLabel();

	private JLabel lblSol = new JLabel("Solicitação 1: ");
	private JLabel lblSol2 = new JLabel("Solicitação 2: ");
	private JButton btnSol = new JButton("Professor Wagner quer mudar Horario");
	private JButton btnSol2 = new JButton("Professor Jeferson quer assumir Mobile");

	private JMenuBar menuBar = new JMenuBar();
	private JMenu cadMenu = new JMenu("Opções");
	private JMenu sairMenu = new JMenu("Sair");	
	private JMenuItem itemCad = new JMenuItem("Cadastrar Usuario");
	private JMenuItem itemDis = new JMenuItem("Cadastrar Disciplina");
	private JMenuItem itemSair = new JMenuItem("Sair");

	public AdministradorView() {
		add(this.titulo);
		setLayout(null);
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setJMenuBar(menuBar);
		menuBar.add(cadMenu);
		menuBar.add(sairMenu);
		
		
		cadMenu.add(itemCad);
		cadMenu.add(itemDis);
		sairMenu.add(itemSair);
		
		itemCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioCadastroView userCad = new UsuarioCadastroView();
				userCad.setVisible(true);
				dispose();
			}
		});
		
		itemDis.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				DisciplinaView dis = new DisciplinaView();
				dis.setVisible(true);
				dispose();
			}
		});
		
		itemSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		lblPendente.setBounds(10, 5, 200, 25);
		add(lblPendente);
		lblPendente.setFont(ftSol);

		lblLogado.setBounds(370, 5, 200, 25);
		add(lblLogado);

		lblSol.setBounds(50,50,200,50);
		add(lblSol);
		btnSol.setBounds(150,60,300,25);
		add(btnSol);
		btnSol.setFont(ftSol);

		lblResult.setBounds(250, 80, 300, 50);
		add(lblResult);

		lblSol2.setBounds(50,125,200,50);
		add(lblSol2);
		btnSol2.setBounds(150,135,300,25);
		add(btnSol2);
		btnSol2.setFont(ftSol);

		lblResult2.setBounds(250, 150, 300, 50);
		add(lblResult2);

		// Ação do botão 1
		this.btnSol.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Você está de acordo com a solicitação?");
				if(resposta == 0) {
					lblResult.setText("Aceito");
				}else if(resposta == 1) {
					lblResult.setText("Não Aceito");
				}else if(resposta == 2) {
					lblResult.setText("Ação Cancelada");
				}
			}
		});

		// Ação do Botão 2
		this.btnSol2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Você está de acordo com a solicitação?");
				if(resposta == 0) {
					lblResult2.setText("Aceito");
				}else if(resposta == 1) {
					lblResult2.setText("Não Aceito");
				}else if(resposta == 2) {
					lblResult2.setText("Ação Cancelada");
				}
			}
		});
	}
}
