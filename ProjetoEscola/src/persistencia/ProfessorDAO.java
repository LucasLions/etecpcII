package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.Professor;
import model.Usuario;
import view.ProfessorView;

public class ProfessorDAO{
	
	public ProfessorDAO() {
		
	}

	public void insert(Object o) throws Exception {
		Connection conn = new ConectionFactory().getMysqlConnection();
		String sql ="INSERT INTO tblProfessor(nome,telProfessor,endProfessor,cpf,rg) values ('"+((Professor)o).getNomeProfessor()+"','"+((Professor)o).getTelefoneProf()+"','"+((Professor)o).getEnderecoProf()+"','"+((Professor)o).getCpfProf()+"','"+((Professor)o).getRgProf()+"')";
		System.out.println(sql);
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
		
	}
	
	public void update(Object o) throws Exception{
		Connection conn = new ConectionFactory().getMysqlConnection();
		String sql ="UPDATE tblProfessor SET nome = '"+((Professor)o).getNomeProfessor()+"',telProfessor ='"+((Professor)o).getTelefoneProf()+"', endProfessor = '"+((Professor)o).getEnderecoProf()+"', cpf = '"+((Professor)o).getCpfProf()+"', rg = '"+((Professor)o).getRgProf()+"' WHERE idProfessor = 1";
		System.out.println(sql);
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
	}

	public void select() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = new ConectionFactory().getMysqlConnection();
		
		String sql = "Select * from tblProfessor";
		PreparedStatement stm = conn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while(rs.next()){
			
			
		}	
	}
}
