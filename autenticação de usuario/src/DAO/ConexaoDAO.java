package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/bancoteste";
    private static final String drive = "com.mysql.jdbc.Driver";
    private static Connection conn = null;
	public Connection conctaBD() {
	//Connection conn=null;
	try {
		Class.forName(drive);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(url, usuario, senha);
        // Retorna a conexao aberta
        return conn;
	} catch (SQLException erro) {
		JOptionPane.showInputDialog(null,erro.getMessage());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return conn;	
	
	}
}
