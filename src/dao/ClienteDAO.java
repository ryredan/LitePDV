package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Relatorio;

public class ClienteDAO implements IDAO<Cliente>{
    
    @Override
    public void inserir(Cliente c){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("INSERT INTO tbclientes (nome, datadenascimento, cpf, endereco, cep, numerocasa, complemento, bairro, cidade, uf, telefone, celular, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	    ps.setString(1, c.getNome());
	    ps.setDate(2, new java.sql.Date(c.getDatadenascimento().getTime()));
	    ps.setString(3, c.getCpf());
	    ps.setString(4, c.getEndereco());
	    ps.setString(5, c.getCep());
	    ps.setString(6, c.getNumerocasa());
	    ps.setString(7, c.getComplemento());
	    ps.setString(8, c.getBairro());
	    ps.setString(9, c.getCidade());
	    ps.setString(10, c.getUf());
	    ps.setString(11, c.getTelefone());
	    ps.setString(12, c.getCelular());
	    ps.setString(13, c.getEmail());
	    ps.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	RelatorioDAO r = new RelatorioDAO();
	r.inserir(new Relatorio("Novo Cliente", "Criado o cliente " + c.getNome()));
	
    }
    @Override
        public void excluir(Cliente c){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("DELETE FROM tbclientes WHERE id=?");
	    ps.setInt(1, c.getId());
	    ps.execute();

	} catch (SQLException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	RelatorioDAO r = new RelatorioDAO();
	r.inserir(new Relatorio("Cliente excluído", "O cliente " + c.getNome() + " foi removido do banco de dados"));
    }
    @Override
    public void alterar(Cliente c){
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("UPDATE tbclientes SET nome=?, datadenascimento=?, cpf=?, endereco=?, cep=?, numerocasa=?, complemento=?, bairro=?, cidade=?, uf=?, telefone=?, celular=?, email=? WHERE id=?");
	    ps.setString(1, c.getNome());
	    ps.setDate(2, new java.sql.Date(c.getDatadenascimento().getTime()));
	    ps.setString(3, c.getCpf());
	    ps.setString(4, c.getEndereco());
	    ps.setString(5, c.getCep());
	    ps.setString(6, c.getNumerocasa());
	    ps.setString(7, c.getComplemento());
	    ps.setString(8, c.getBairro());
	    ps.setString(9, c.getCidade());
	    ps.setString(10, c.getUf());
	    ps.setString(11, c.getTelefone());
	    ps.setString(12, c.getCelular());
	    ps.setString(13, c.getEmail());
	    ps.setInt(14, c.getId());
	    ps.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	RelatorioDAO r = new RelatorioDAO();
	r.inserir(new Relatorio("Cliente alterado", "O cliente " + c.getNome() + " teve dados alterados"));
    }
    
    @Override
    public ArrayList<Cliente> listarTodos(){
	return pesquisar("");
    }
    
    @Override
    public Cliente recuperar(int codigo) throws Exception {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public ArrayList<Cliente> pesquisar(String termodepesquisa){
	ArrayList<Cliente> returnarray = new ArrayList<>();
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT * FROM tbclientes WHERE nome LIKE ?");
	    ps.setString(1, "%" + termodepesquisa + "%");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
		Cliente c = new Cliente();
		c.setId(rs.getInt("id"));
		c.setNome(rs.getString("nome"));
		c.setDatadenascimento(rs.getDate("datadenascimento"));
		c.setCpf(rs.getString("cpf"));
		c.setEndereco(rs.getString("endereco"));
		c.setCep(rs.getString("cep"));
		c.setNumerocasa(rs.getString("numerocasa"));
		c.setComplemento(rs.getString("complemento"));
		c.setBairro(rs.getString("bairro"));
		c.setCidade(rs.getString("cidade"));
		c.setUf(rs.getString("uf"));
		c.setTelefone(rs.getString("telefone"));
		c.setCelular(rs.getString("celular"));
		c.setEmail(rs.getString("email"));
		returnarray.add(c);
	    }
	    }catch(SQLException ex) {
	    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return returnarray;
    }
}
