package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import model.Solicitacao;
import persistencia.ConectionFactory;
import persistencia.SolicitacaoDAO;

public class SolicitacaoView extends JFrame{
	private JLabel titulo = new JLabel("Solicitação");
	private JLabel lblId = new JLabel("ID: ");
	private JTextField txtId = new JTextField("");
	private JLabel lblCod = new JLabel("Codigo do Professor: ");
	private JTextField txtCod = new JTextField("");
	private JLabel lblDesc = new JLabel("Descrição: ");
	private JTextArea txtDesc = new JTextArea("");
	private JLabel lblDate = new JLabel("Data: ");
	private JTextArea txtData = new JTextArea("");
	
	private JButton btnSol = new JButton("Solicitar");
	private JButton btnVoltar = new JButton("Voltar");
	private JButton btnLimpar = new JButton("Limpar");
	
	public SolicitacaoView() {
		editarTela();
		telaComponentes();
		setOnLoad();
	}
	
	public void setOnLoad() {
		Connection conn;
		try {
				conn = new ConectionFactory().getMysqlConnection();
				String sql = "Select * from tblPedidos";
				PreparedStatement stm = conn.prepareStatement(sql);
				ResultSet rs = stm.executeQuery();
				while(rs.next()){	
					txtId.setText(String.valueOf(rs.getInt("id")+1));					
				}	
		} catch (Exception e) {
			System.out.println("Erro: "+e);
		}
	}
	
	public void telaComponentes() {
		lblId.setBounds(180,5,50,25);
		add(lblId);
		txtId.setBounds(200, 5, 50, 25);
		add(txtId);	
		
		txtId.setEnabled(false);
		
		lblCod.setBounds(150,35,200,25);
		add(lblCod);
		txtCod.setBounds(10, 60, 390, 25);
		add(txtCod);
		
		lblDesc.setBounds(150,95,200,25);
		add(lblDesc);
		txtDesc.setBounds(10,120,390,100);
		add(txtDesc);
		
		lblDate.setBounds(150,220,100,25);
		add(lblDate);
		txtData.setBounds(100,250,200,25);
		add(txtData);
		
		
		btnSol.setBounds(10,350,100,25);
		add(btnSol);
		btnVoltar.setBounds(150,350,100,25);
		add(btnVoltar);
		btnLimpar.setBounds(300,350,100,25);
		add(btnLimpar);
		
		btnSol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Fazer o envio para o banco e dar uma alert ao admin
				try {

					Solicitacao sol = new Solicitacao(Integer.parseInt(txtCod.getText()), txtDesc.getText(), txtData.getText());
					SolicitacaoDAO dao = new SolicitacaoDAO();
					dao.insert(sol);					
					JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso");
					 new SolicitacaoView();
					 dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar pedido \n ERRO: "+e2);
				}
				
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfessorView voltar = new ProfessorView();
				voltar.setVisible(true);
				dispose();
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCod.setText("");
				txtDesc.setText("");
				txtData.setText("");
			}
		});
	}
	
	public void editarTela() {
		add(this.titulo);
		setLayout(null);
		setSize(410,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
}
