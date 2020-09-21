package dao;

import controller.LitePDV;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Relatorio;
import model.Usuario;

public class UsuarioDAO implements IDAO<Usuario>{

    @Override
    public void inserir(Usuario u){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("INSERT INTO tbusuarios (login, senha, identificacao, nome, datadenascimento, cpf, email, telefone, celular, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	    ps.setString(1, u.getLogin());
	    ps.setString(2, u.getSenha());
	    ps.setString(3, u.getIdentificacao());
	    ps.setString(4, u.getNome());
	    ps.setDate(5, new java.sql.Date(u.getDatadenascimento().getTime()));
	    ps.setString(6, u.getCpf());
	    ps.setString(7, u.getEmail());
	    ps.setString(8, u.getTelefone());
	    ps.setString(9, u.getCelular());
	    ps.setString(10, u.getTipo());
	    ps.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	RelatorioDAO r = new RelatorioDAO();
	r.inserir(new Relatorio("Novo Usuario", "Criado o usuario " + u.getNome() + " com nível de acesso " + u.getTipo()));
    }
    @Override
    public void excluir(Usuario u){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("DELETE FROM tbusuarios WHERE id=?");
	    ps.setInt(1, u.getId());
	    ps.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	RelatorioDAO r = new RelatorioDAO();
	r.inserir(new Relatorio("Usuario excluído", "O Usuário " + u.getNome() + " foi removido"));
	
    }
    @Override
    public void alterar(Usuario u){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("UPDATE tbusuarios SET login=?, senha=?, identificacao=?, nome=?, datadenascimento=?, cpf=?, email=?, telefone=?, celular=?, tipo=? WHERE id=?");
	    ps.setString(1, u.getLogin());
	    ps.setString(2, u.getSenha());
	    ps.setString(3, u.getIdentificacao());
	    ps.setString(4, u.getNome());
	    ps.setDate(5, new java.sql.Date(u.getDatadenascimento().getTime()));
	    ps.setString(6, u.getCpf());
	    ps.setString(7, u.getEmail());
	    ps.setString(8, u.getTelefone());
	    ps.setString(9, u.getCelular());
	    ps.setString(10, u.getTipo());
	    ps.setInt(11, u.getId());
	    ps.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    @Override
    public ArrayList<Usuario> listarTodos(){
	ArrayList<Usuario> returnarray = new ArrayList<>();
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT * FROM tbusuarios");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNome(rs.getString("nome"));
		u.setDatadenascimento(rs.getDate("datadenascimento"));
		u.setCpf(rs.getString("cpf"));
		u.setIdentificacao(rs.getString("identificacao"));
		u.setTelefone(rs.getString("telefone"));
		u.setCelular(rs.getString("celular"));
		u.setEmail(rs.getString("email"));
		u.setLogin(rs.getString("login"));
		u.setSenha(rs.getString("senha"));
		u.setTipo(rs.getString("tipo"));
		returnarray.add(u);
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return returnarray;
    }

    @Override
    public Usuario recuperar(int codigo) throws Exception {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
