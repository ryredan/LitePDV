package dao;

import java.sql.*;

public class Conexao {

    private static final String SERVIDOR = "localhost";
    private static final String PORTA = "3306";
    private static final String BANCO_DE_DADOS = "LitePDVDB";
    private static final String USUARIO = "thegoodfellas";
    private static final String SENHA = "12345";
    private static final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + BANCO_DE_DADOS;

    private static Connection conexao;
    
    private Conexao(){
    }
    
    public static Connection getConnection(){
	if(conexao == null){
	    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
	    } catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	    }
	}
	return conexao;
    }

}
