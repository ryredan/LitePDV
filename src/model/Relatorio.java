package model;

import controller.LitePDV;
import java.util.Calendar;
import java.util.Date;

public class Relatorio extends GenericClass{
    private Date data = Calendar.getInstance().getTime();
    private String usuario = LitePDV.getCurrentUser().getNome();
    private String tipo;
    private String detalhes;

    public Relatorio(){
	
    }
    
    public Relatorio(String t, String dt){
	setTipo(t);
	setDetalhes(dt);
    }
    public Date getData() {
	return data;
    }

    public void setData(Date data) {
	this.data = data;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }

    public String getDetalhes() {
	return detalhes;
    }

    public void setDetalhes(String detalhes) {
	this.detalhes = detalhes;
    }
    
    
}
