package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import model.Usuario;
import view.TelaDeAutenticacao;
import view.TelaDeCadastroDeUsuarios;

public class LitePDV {
    
    private static Usuario usuarioAtual = null;
    
    public static void main(String args[]){
	if(!DataCheck.checkForAdmin()){
	    JOptionPane.showMessageDialog(null, "Sem usuários administradores cadastrados, pelo menos um obrigatório");
	    TelaDeCadastroDeUsuarios win = new TelaDeCadastroDeUsuarios();
	    win.setVisible(true);
            win.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    win.lockOnAdmin();
	    win.addWindowListener(new WindowAdapter() {
		public void windowClosed(WindowEvent e) {
		     telaDeLogin();
		}
		
	    });
	}else{
	telaDeLogin();
	}
	
    }
    
    
    public static void setCurrentUser(Usuario u){
	LitePDV.usuarioAtual = u;
    }
    public static Usuario getCurrentUser(){
	return LitePDV.usuarioAtual;
    }
    
   
    public static void telaDeLogin(){
	TelaDeAutenticacao win = new TelaDeAutenticacao();
	win.setVisible(true);
    }    
}