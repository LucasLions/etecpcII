package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Aluno;


public class AlunoDAO {

	public AlunoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void update(Object o) throws Exception{
		Connection conn = new ConectionFactory().getMysqlConnection();
		String sql ="UPDATE tblAluno SET nome = '"+((Aluno)o).getNome()+"',telAluno ='"+((Aluno)o).getTelAluno()+"', endAluno = '"+((Aluno)o).getEndAluno()+"', cpf = '"+((Aluno)o).getCpf()+"', rg = '"+((Aluno)o).getRg()+"' WHERE idAluno = 1";
		System.out.println(sql);
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
	}
}
