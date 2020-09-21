package model;

public class Cliente extends Pessoa{
    private String endereco;
    private String cep;
    private String numerocasa;
    private String complemento;

    public String getNumerocasa() {
	return numerocasa;
    }

    public void setNumerocasa(String numerocasa) {
	this.numerocasa = numerocasa;
    }

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }
    private String bairro;
    private String cidade;
    private String uf;

    public String getEndereco() {
	return endereco;
    }

    public void setEndereco(String endereco) {
	this.endereco = endereco;
    }
    
    public String getCep() {
	return cep;
    }

    public void setCep(String cep) {
	this.cep = cep;
    }

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	this.bairro = bairro;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getUf() {
	return uf;
    }

    public void setUf(String uf) {
	this.uf = uf;
    }   
    
}
