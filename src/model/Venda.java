package model;

import java.util.ArrayList;

public class Venda {
    private int id;
    private ArrayList<Item> itens;
    private double precototal;
    private Cliente clienteproprietario;
    private double dinheiro;

    public double getDinheiro() {
	return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
	this.dinheiro = dinheiro;
    }
    
    public Venda(){
        itens = new ArrayList<>(0);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void atualizarPrecototal() {
        this.precototal = 0;
        for(int i = 0; i < itens.size(); i++){
            precototal += itens.get(i).getSubTotal();
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<Item> getItens() {
	return itens;
    }

    public void setItens(ArrayList<Item> itens) {
	this.itens = itens;
    }

    public Cliente getClienteproprietario() {
	return clienteproprietario;
    }

    public void setClienteproprietario(Cliente clienteproprietario) {
	this.clienteproprietario = clienteproprietario;
    }

    public double getPrecototal() {
        return precototal;
    }
    
    public void limparItens(){
	getItens().clear();
    }
    
    public void adicionarItem(Item novoitem){
        getItens().add(novoitem);
        
    }
    public void removerItem(int index){
	getItens().remove(index);
    }
    
    public void atribuirCliente(Cliente clienteatual){
        clienteproprietario = clienteatual;
    }
    
    public Cliente getCliente(){
        return clienteproprietario;
    }
}
