package DAO;
import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UsuarioDAO {
	Connection conn;
	public ResultSet autencicacaoUsuario(UsuarioDTO objusuariodto) {
	conn = new ConexaoDAO() .conctaBD();
	try {
		String sql="select  nome_usuario, senha_usuario from usuario where nome_usuario= ? and senha_usuario= ? ";
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1, objusuariodto.getNome_usuario());
		pstm.setString(2, objusuariodto.getSenha_usuario());
		
		ResultSet rs = pstm.executeQuery();
		return rs;
		} catch (SQLException erro) {
	JOptionPane.showMessageDialog( null,"usuarioDAO"+erro);
	}
	return null;
	}
}