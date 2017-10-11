package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import model.Disciplina;

public class DisciplinaDAO implements IDAO{
	Connection Conn;
	
	public DisciplinaDAO(Connection conn) {
		this.Conn = conn;
	}
	@Override
	public void insert(Object o) throws Exception {
		String sql ="INSERT INTO tblDisciplina(nomeDisciplina,descricaoDisciplina,diasdeAula,horario) values"
				+ " ('"+((Disciplina)o).getNomeDisciplina()+"','"+((Disciplina)o).getDescricaoDisciplina()+"','"+((Disciplina)o).getDiasAula()+"',"
				+ "'"+((Disciplina)o).getHorario()+"')";
		System.out.println(sql);
		PreparedStatement stm = (PreparedStatement) Conn.prepareStatement(sql);
		stm.executeUpdate();
	}
	
	
	public void select(Object o) throws Exception {
		String sql = null;
		PreparedStatement stm = (PreparedStatement) Conn.prepareStatement("Select * from tblDisciplina");
		ResultSet rs = stm.executeQuery();
		while(rs.next()){
			String campos = rs.getString("nomeDisciplina");
			System.out.println(campos);
		}		
	}
	
	

}
