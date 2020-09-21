package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Produto;

public class BuscaProdutoTableModel extends AbstractTableModel{
    private ArrayList<Produto> produtos;
    private String colunas[] = {"Codigo", "Nome", "Preço"};

    public void setProdList(ArrayList<Produto> prod){
	produtos = prod;
    }
    
    public int getRowCount() {
	if(produtos == null){
	    return 0;
	}else{
	    return produtos.size();
	}
    }

    @Override
    public int getColumnCount() {
	return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
	DecimalFormat df = new DecimalFormat("#.00");
	switch(col){
	    case 0:
		return produtos.get(row).getId();
	    case 1:
		return produtos.get(row).getNome();
            case 2:
                return "R$: " + df.format(produtos.get(row).getPreco());
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
    
    public Produto getProductAtIndex(int row){
	return produtos.get(row);
    }
    
}
