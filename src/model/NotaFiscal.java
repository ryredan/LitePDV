package model;

import java.text.DecimalFormat;

public class NotaFiscal {
    private Venda venda;

    public Venda getVenda() {
	return venda;
    }

    public void setVenda(Venda venda) {
	this.venda = venda;
    }
    
    public NotaFiscal(Venda v){
	setVenda(v);
    }
    
    public String gerarNota(){
	DecimalFormat df = new DecimalFormat("#.00");
	String nota = "";
	nota += "LitePDV\n" + 
		"Cliente: " + getVenda().getClienteproprietario().getNome() + "\n" +   
		"Endereço: " + getVenda().getClienteproprietario().getEndereco() + " " + getVenda().getClienteproprietario().getNumerocasa() + "\n" + 
		"Telefone: " + getVenda().getClienteproprietario().getTelefone() + "/" + getVenda().getClienteproprietario().getCelular() + "\n" +
		"==============================" + "\n";
	for(int i = 0; i < getVenda().getItens().size(); i++){
	    nota += getVenda().getItens().get(i).getProduto().getNome() + " x" + getVenda().getItens().get(i).getQuantidade() + " = " + df.format(getVenda().getItens().get(i).getSubTotal()) + "\n";
	}
	nota += "==============================" + "\n" +
		"VALOR TOTAL:\n" + getVenda().getPrecototal() + "\n" + 
		"DINHEIRO:\n" + getVenda().getDinheiro() + "\n" + 
		"TROCO:\n" + (getVenda().getDinheiro() - getVenda().getPrecototal());
	return nota;
    }
}
