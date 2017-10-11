package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Usuario;

public class UsuarioDAO{
	
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}

	public void insert(Object o) throws Exception {
		Connection conn = new ConectionFactory().getMysqlConnection();
		String sql ="INSERT INTO tblUser(login,senha,nivel_acesso) values ('"+((Usuario)o).getLogin()+"','"+((Usuario)o).getSenha()+"','"+((Usuario)o).getNivel_acesso()+"')";
		System.out.println(sql);
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
	}

	public boolean checkLogin (String login,String senha) throws Exception {
		Connection conn = ConectionFactory.getMysqlConnection();
		String sql ="SELECT * FROM tblUser WHERE login = ? AND senha = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha estão invalidos");
			}
		return check;
		
	}

}
