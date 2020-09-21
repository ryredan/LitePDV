package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

public class ClienteTableModel extends AbstractTableModel{
    
    private final String colums[] = {"Nome", "Telefone", "Endereço"};    
    private List<Cliente> clientes;
    
    public void setUserList(List<Cliente> fregues){
	clientes = fregues;
    }
    
    @Override
    public int getRowCount() {
	if (clientes == null){
	    return 0;
	}
	return clientes.size();
    }

    @Override
    public int getColumnCount() {
	return colums.length;
    }
  @Override
    public String getColumnName(int n) {
	return colums[n];
    }

    @Override
    public Class<?> getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }
    
    @Override
    public Object getValueAt(int row, int col) {
	switch(col){
	    case 0:
		return clientes.get(row).getNome();
	    case 1:
		return clientes.get(row).getTelefone();
            case 2:
                return clientes.get(row).getEndereco();
	    default:
		return null;
	}
    }
    
    public Cliente getClientAtIndex(int row){
	return clientes.get(row);
    }
    
    
}
