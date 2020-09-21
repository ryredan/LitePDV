package dao;

import controller.LitePDV;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;
import model.Relatorio;

public class ProdutoDAO implements IDAO<Produto>{
    
    
    @Override
    public void inserir(Produto p){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("INSERT INTO tbprodutos (nome, preco, descricao) VALUES (?, ?, ?)");
	    ps.setString(1, p.getNome());
	    ps.setFloat(2, (float)p.getPreco());
	    ps.setString(3, p.getDescricao());
	    ps.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	RelatorioDAO r = new RelatorioDAO();
	r.inserir(new Relatorio("Novo Produto", "Criado o produto " + p.getNome()));
    }
    @Override
        public void excluir(Produto p){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("DELETE FROM tbprodutos WHERE id=?");
	    ps.setInt(1, p.getId());
	    ps.execute();
	}catch(SQLException ex){
	    ex.printStackTrace();
	}
	RelatorioDAO r = new RelatorioDAO();
	r.inserir(new Relatorio("Produto excluído", "O produto " + p.getNome() + " foi removido da banco de dados"));
    }

    @Override
    public Produto recuperar(int id){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT * FROM tbprodutos WHERE id=?");
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if(rs.next()){
		Produto p = new Produto();
		p.setId(rs.getInt("id"));
		p.setNome(rs.getString("nome"));
		p.setPreco(rs.getFloat("preco"));
		p.setDescricao(rs.getString("Descricao"));
		return p;
	    }
	}catch (SQLException ex) {
	    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
    
    public ArrayList<Produto> pesquisar(String termodepesquisa){
	ArrayList<Produto> returnarray = new ArrayList<>();
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT * FROM tbprodutos WHERE nome LIKE ?");
	    ps.setString(1, "%" + termodepesquisa + "%");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
		Produto p = new Produto();
		p.setId(rs.getInt("id"));
		p.setNome(rs.getString("nome"));
		p.setPreco(rs.getFloat("preco"));
		p.setDescricao(rs.getString("descricao"));
		returnarray.add(p);
		}
	    }catch(SQLException ex) {
	    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return returnarray;
    }
    
    @Override
    public void alterar(Produto p){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("UPDATE tbprodutos SET nome=?, preco=?, descricao=? WHERE id=?");
	    ps.setString(1, p.getNome());
	    ps.setFloat(2, (float)p.getPreco());
	    ps.setString(3, p.getDescricao());
	    ps.setInt(4, p.getId());
	    ps.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	RelatorioDAO r = new RelatorioDAO();
	r.inserir(new Relatorio("Produto Alterado", "O produto " + p.getNome() + " teve seus dados alterados"));
    }
    
    @Override
    public ArrayList<Produto> listarTodos(){
	ArrayList<Produto> returnarray = new ArrayList<>();
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT * FROM tbprodutos");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
		Produto p = new Produto();
		p.setId(rs.getInt("id"));
		p.setNome(rs.getString("nome"));
		p.setPreco(rs.getFloat("preco"));
		p.setDescricao(rs.getString("descricao"));
		returnarray.add(p);
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return returnarray;
    }
}
