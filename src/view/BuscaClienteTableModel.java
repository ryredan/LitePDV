package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

public class BuscaClienteTableModel extends AbstractTableModel{
    private ArrayList<Cliente> clientes;
    private String colunas[] = {"Nome", "Endereço", "Telefone"};

    public void setClientList(ArrayList<Cliente> newlist){
	clientes = newlist;
    }
    
    @Override
    public int getRowCount() {
	if(clientes == null){
	    return 0;
	}else{
	    return clientes.size();
	}
    }

    @Override
    public int getColumnCount() {
	return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
	switch(col){
	    case 0:
		return clientes.get(row).getNome();
	    case 1:
		return clientes.get(row).getEndereco();
            case 2:
                return clientes.get(row).getCelular();
	    default:
		return null;
	}
    }
    
    @Override
    public String getColumnName(int n) {
	return colunas[n];
    }

    @Override
    public Class<?> getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }
    
    public Cliente getClientAtIndex(int row){
	return clientes.get(row);
    }
}
