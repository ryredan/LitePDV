package model;

public class Item {
    private int id;
    private Produto produto;
    private int quantidade;
    private double subtotal;

    public void setId(int id){
        this.id = id;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId(){
        return id;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public void atualizarSubTotal(){
        subtotal = produto.getPreco() * getQuantidade();
}
    
    public double getSubTotal(){
        return subtotal;
    }
    
}
