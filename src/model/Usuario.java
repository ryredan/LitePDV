package model;

public class Usuario extends Pessoa{
    private String login;
    private String senha;
    private String identificacao;
    private String tipo;

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getIdentificacao() {
	return identificacao;
    }

    public void setIdentificacao(String identificacao) {
	this.identificacao = identificacao;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }
    
}
