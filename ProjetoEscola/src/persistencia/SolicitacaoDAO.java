package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Professor;
import model.Solicitacao;

public class SolicitacaoDAO implements IDAO{

	@Override
	public void insert(Object o) throws Exception {		
			Connection conn = new ConectionFactory().getMysqlConnection();
			String sql ="INSERT INTO tblPedidos(profCod,descricao,created) values ('"+((Solicitacao)o).getProfCod()+"','"+((Solicitacao)o).getDescricao()+"','"+((Solicitacao)o).getDate()+"')";
			System.out.println(sql);
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.executeUpdate();
			
	}

	@Override
	public void select(Object o) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
