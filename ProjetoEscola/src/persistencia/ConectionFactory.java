package persistencia;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConectionFactory {
	public Connection conn;	
	public Statement stm; // Responsavel pela pesquisa
	public ResultSet rs; // Responsavel por guardar pesquisa
	private String driver = "com.mysql.jdbc.Driver";
	private String pathBD = "jdbc:mysql://localhost/escola";
	private String user = "root";
	private String password = "";
	
	public static Connection getMysqlConnection() throws Exception{
		String stringDeConexao = "jdbc:mysql://localhost/escola";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(stringDeConexao,"root","");
		return conn;		
	}
	
	// INICIA UMA CONEXÃO
		public Connection conexao() {
			try {
				System.setProperty("jdbc.Drivers",driver);
				conn = DriverManager.getConnection(pathBD,user,password);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Conexao com erro"+e.getMessage());
			}
			return conn;
		}
	// FIM
	
	// FINALIZA A CONEXÃO
		public void desconecta() {
			try {
				conn.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao: \n"+e.getMessage());
			}
		}
	//FIM
}
