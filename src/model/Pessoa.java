package model;

import java.util.Date;

public class Pessoa extends GenericClass {
    private String nome;
    private Date datadenascimento;
    private String cpf;
    private String telefone;
    private String celular;
    private String email;

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;	
    }

    public Date getDatadenascimento() {
	return datadenascimento;
    }

    public void setDatadenascimento(Date datadenascimento) {
	this.datadenascimento = datadenascimento;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public String getCelular() {
	return celular;
    }

    public void setCelular(String celular) {
	this.celular = celular;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }
}
