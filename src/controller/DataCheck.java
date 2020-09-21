package controller;

import dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;

public class DataCheck {
    
    public static boolean entryExists(String table, String column, String value) throws ClassNotFoundException, SQLException{
	String query = "SELECT * FROM "+ table + " WHERE " + column + "=" +"\"" + value + "\"";
	PreparedStatement ps = Conexao.getConnection().prepareStatement(query);
	ResultSet rs = ps.executeQuery();
	return rs.next();
    }
    
    public static Usuario loginAttempt(String login, String senha){
	
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT * FROM tbusuarios WHERE login=? AND senha=?");
	    ps.setString(1, login);
	    ps.setString(2, senha);
	    ResultSet rs = ps.executeQuery();
	    if(rs.next()){
		Usuario user = new Usuario();
		user.setNome(rs.getString("nome"));
		user.setIdentificacao(rs.getString("identificacao"));
		user.setTipo(rs.getString("tipo"));
		return user;
	    }    
	} catch (SQLException ex) {
	    Logger.getLogger(DataCheck.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
    
    public static boolean checkForAdmin(){
	try{
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT tipo FROM tbusuarios WHERE tipo='A'");
	    ResultSet rs = ps.executeQuery();
	    if(rs.next()){
		return true;
	    }
	}catch(SQLException e){
	    JOptionPane.showMessageDialog(null, e, "Erro de comando", JOptionPane.PLAIN_MESSAGE);
	}
	return false;
    }
}
