package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;

public class ProdutoTableModel extends AbstractTableModel{
    private final String colums[] = {"Código", "Nome", "Preço", "Descrição"};    
    private List<Produto> produtos;
    
    public void setProdList(List<Produto> prod){
	produtos = prod;
    }
    
    public int getRowCount() {
	if (produtos == null){
	    return 0;
	}
	return produtos.size();
    }

    public int getColumnCount() {
	return colums.length;
    }

    public String getColumnName(int n) {
	return colums[n];
    }

    public Class<?> getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }
    
    public Object getValueAt(int row, int col) {
	switch(col){
	    case 0:
		return produtos.get(row).getId();
	    case 1:
		return produtos.get(row).getNome();
            case 2:
                return produtos.get(row).getPreco();
	    case 3:
		return produtos.get(row).getDescricao();
	    default:
		return null;
	}
    }
    
    public Produto getProductAtIndex(int row){
	return produtos.get(row);
    }
}
