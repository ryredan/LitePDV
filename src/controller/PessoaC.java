package controller;

import model.Cliente;
import model.Usuario;
import model.Pessoa;

public class PessoaC {
    
    public static boolean isEntryValid(Pessoa p){
	if( p.getNome() != null &&
	    p.getDatadenascimento() != null &&
	    p.getCpf() != null){
	    if( p instanceof Usuario){
		Usuario u = (Usuario) p;
		return( u.getIdentificacao() != null &&
		    u.getEmail() != null &&
		    u.getLogin() != null &&
		    u.getSenha() != null &&
		    u.getTipo() != null &&
		    u.getIdentificacao() != null &&
		    u.getEmail() != null &&
		    u.getLogin() != null &&
		    u.getSenha() != null &&
		    u.getTipo() != null);
	    }else
	    if( p instanceof Cliente){
		Cliente c = (Cliente) p;
		return( c.getEndereco() != null &&
		    c.getCep() != null &&
		    c.getNumerocasa() != null &&
		    c.getComplemento() != null &&
		    c.getBairro() != null &&
		    c.getCidade() != null &&
		    c.getUf() != null &&
		    c.getEmail() != null);
	    }
	}
	return false;
    }
    
}
