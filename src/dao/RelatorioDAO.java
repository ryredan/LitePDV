package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Relatorio;

public class RelatorioDAO implements IDAO<Relatorio>{

    @Override
    public void inserir(Relatorio r) {
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("INSERT INTO tbrelatorios (data, usuario, tipo, detalhes) VALUES (?, ?, ?, ?)");
	    ps.setDate(1, new java.sql.Date(r.getData().getTime()));
	    ps.setString(2, r.getUsuario());
	    ps.setString(3, r.getTipo());
	    ps.setString(4, r.getDetalhes());
	    ps.execute();
	} catch (SQLException ex) {
	    Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public void alterar(Relatorio r){
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void excluir(Relatorio r){
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Relatorio> listarTodos(){
	ArrayList<Relatorio> returnarray = new ArrayList<>();
	try {
	    PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT * FROM tbrelatorios");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
		Relatorio r = new Relatorio();
		r.setId(rs.getInt("id"));
		r.setData(rs.getDate("data"));
		r.setUsuario(rs.getString("usuario"));
		r.setTipo(rs.getString("tipo"));
		r.setDetalhes(rs.getString("detalhes"));
		returnarray.add(r);
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return returnarray;
    }

    @Override
    public Relatorio recuperar(int codigo) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
