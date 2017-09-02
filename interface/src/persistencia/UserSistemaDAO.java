package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.UserSistema;
import model.Pessoa;
import persistencia.Conexao;

public class UserSistemaDAO {

Connection Conn;
	
	public UserSistemaDAO(Connection conn){
		this.Conn = conn;		
	}
	
	public void inserir(UserSistema a) throws Exception{
		Conexao daolog = new Conexao();
		String sql = "INSERT INTO alunos(nome) values('"+a.getLogin()+"')";
		System.out.println(sql);		
		PreparedStatement stm = Conn.prepareStatement(sql);
		stm.executeUpdate();
	}
}
