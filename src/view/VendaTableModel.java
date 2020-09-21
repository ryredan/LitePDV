package view;

import java.text.DecimalFormat;
import javax.swing.table.AbstractTableModel;
import model.Item;
import model.Venda;

public class VendaTableModel extends AbstractTableModel{

    private Venda venda;
    private String colunas[] = {"Item", "Código", "Nome", "Qtd.", "Valor", "Sub Total"};

    public Venda getVenda() {
	return venda;
    }

    public void setVenda(Venda venda) {
	this.venda = venda;
    }
    
    public int getRowCount() {
	if(getVenda() == null){
	    return 0;
	}
	return getVenda().getItens().size();
    }

    @Override
    public int getColumnCount() {
	return colunas.length;
    }

    @Override
    public String getColumnName(int n) {
	return colunas[n];
    }

    public Class<?> getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }
    
    public Object getValueAt(int row, int col) {
	DecimalFormat df= new DecimalFormat("#.00");
	switch(col){
	    case 0:
		return row; //indice da tabela
	    case 1:
		return getVenda().getItens().get(row).getProduto().getId(); //codigo do produto
            case 2:
                return getVenda().getItens().get(row).getProduto().getNome(); //nome do produto
	    case 3:
		return getVenda().getItens().get(row).getQuantidade(); //quantidade do produto
	    case 4:
		return df.format(getVenda().getItens().get(row).getProduto().getPreco()); //preco unitario do produto
	    case 5:
		return df.format(getVenda().getItens().get(row).getSubTotal()); //subtotal (preco unitario * quantidade)
	    default:
		return null;
	}
    }
    
    public Item getProductAtIndex(int row){
	return venda.getItens().get(row);
    }
}
