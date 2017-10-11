package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Professor;
import persistencia.ConectionFactory;
import persistencia.ProfessorDAO;

public class AtualizaProfessorView extends JFrame{
	JLabel titulo = new JLabel("Atualizar Cadastro - Professor");
	JLabel lblID = new JLabel("ID: ");
	
	JLabel lblNome = new JLabel("Nome: ");
	JTextField txtNome = new JTextField("");
	JLabel lblTel = new JLabel("Telefone: ");
	JTextField txtTel = new JTextField("");
	JLabel lblEnd = new JLabel("Endereço: ");
	JTextField txtEnd = new JTextField("");
	JLabel lblCPF = new JLabel("CPF: ");
	JTextField txtCpf = new JTextField("");
	JLabel lblRG = new JLabel("RG: ");
	JTextField txtRg = new JTextField("");
	
	JLabel lblIDDis = new JLabel("Responsavel pela Disciplina: ");
	
	JButton btnAtualizar = new JButton("Atualizar");
	JButton btnVoltar = new JButton("Voltar");
	
	public AtualizaProfessorView() {
		editView();
		editarComponentes();
	}
	
	public void editView() {
		add(this.titulo);
		setLayout(null);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}
	
	public void editarComponentes() {		
		lblNome.setBounds(10, 5, 100, 25);
		add(lblNome);
		txtNome.setBounds(80, 5, 300, 25);
		add(txtNome);
		
		lblTel.setBounds(10, 40, 100, 25);
		add(lblTel);
		txtTel.setBounds(80, 40, 300, 25);
		add(txtTel);
		
		lblEnd.setBounds(10, 75, 100, 25);
		add(lblEnd);
		txtEnd.setBounds(80, 75, 300, 25);
		add(txtEnd);
		
		lblCPF.setBounds(10, 110, 100, 25);
		add(lblCPF);
		txtCpf.setBounds(80, 110, 300, 25);
		add(txtCpf);
		
		lblRG.setBounds(10, 145, 100, 25);
		add(lblRG);
		txtRg.setBounds(80, 145, 300, 25);
		add(txtRg);
		
		btnAtualizar.setBounds(5, 200, 100, 25);
		add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Professor prof = new Professor(txtNome.getText(), Integer.parseInt(txtTel.getText()), txtEnd.getText(), Integer.parseInt(txtCpf.getText()), txtRg.getText());
					ProfessorDAO dao = new ProfessorDAO();
					dao.update(prof);
					JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso");
					new AtualizaProfessorView();
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar o cadastro\n ERRO: "+e1);
				}
			}
		});
		
		btnVoltar.setBounds(150, 200, 100, 25);
		add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProfessorView().setVisible(true);
				dispose();
			}
		});
		
	}
	
}
