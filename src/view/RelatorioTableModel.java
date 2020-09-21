package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Relatorio;

public class RelatorioTableModel extends AbstractTableModel{

    String columns[] = {"Data", "Usuario", "Tipo", "Detalhes"};
    ArrayList<Relatorio> relatorios;

    public ArrayList<Relatorio> getRelatorios() {
	return relatorios;
    }

    public void setRelatorios(ArrayList<Relatorio> relatorios) {
	this.relatorios = relatorios;
    }
    
    @Override
    public int getRowCount() {
	if(relatorios == null){
	    return 0;
	}
	return relatorios.size();
    }

    @Override
    public int getColumnCount() {
	return columns.length;
    }
    
    @Override
    public String getColumnName(int n) {
	return columns[n];
    }

    @Override
    public Object getValueAt(int row, int col) {
	switch(col){
	    case 0:
		return relatorios.get(row).getData();
	    case 1:
		return relatorios.get(row).getUsuario();
	    case 2:
		return relatorios.get(row).getTipo();
	    case 3:
		return relatorios.get(row).getDetalhes();
	    default:
		return null;
	}
    }
    
}
