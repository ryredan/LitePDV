package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuario;

public class UsuarioTableModel extends AbstractTableModel{

    private final String colunas[] = {"Nome", "Tipo"};
    private List<Usuario> usuarios;
    
    public void setUserList(List<Usuario> users){
	usuarios = users;
    }
    
    @Override
    public int getRowCount() {
	if(usuarios == null){
	    return 0;
	}
	return usuarios.size();
    }

    @Override
    public int getColumnCount() {
	return colunas.length;
    }

    @Override
    public String getColumnName(int n) {
	return colunas[n];
    }
/*
    @Override
    public Class<?> getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }
/*
    @Override
    public boolean isCellEditable(int arg0, int arg1) {
	return false;
    }
*/
    @Override
    public Object getValueAt(int row, int col) {
	switch(col){
	    case 0:
		return usuarios.get(row).getNome();
	    case 1:
		return usuarios.get(row).getTipo();
	    default:
		return null;
	}
    }
    
    public Usuario getUserAtIndex(int row){
	return usuarios.get(row);
    }
}
