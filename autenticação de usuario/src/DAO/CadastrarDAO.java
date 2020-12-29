package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.CadastrarDTO;
public class CadastrarDAO {
	
	Connection conn;
	PreparedStatement pstm;
	public void cadastrarUsuario(CadastrarDTO objcadastrardto) {
	String sql="insert into usuario (nome_usuario,senha_usuario) values (?,?)";
	
	conn = new ConexaoDAO().conctaBD();
	
	try {
		
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,objcadastrardto.getNome_cadastro());
		pstm.setString(2,objcadastrardto.getSenha_cadastro());
		pstm.execute();
		pstm.close();
	}catch (Exception erro) {
		JOptionPane.showInternalMessageDialog(null, "CAdastrarDAO"+erro);
	}
			
 }
}