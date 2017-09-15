package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.omg.PortableServer.IdAssignmentPolicyOperations;

import model.UserSistema;
import model.Pessoa;
import persistencia.Conexao;

public class UserSistemaDAO implements IDAO {

Connection Conn;
	
	public UserSistemaDAO(Connection conn){
		this.Conn = conn;		
	}
	
	public void inserir(Object o) throws Exception{
		Conexao daolog = new Conexao();
		String sql = "INSERT INTO alunos(nome) values('"+((UserSistema)o).getLogin()+"')";
		System.out.println(sql);		
		PreparedStatement stm = Conn.prepareStatement(sql);
		stm.executeUpdate();
	}
}
