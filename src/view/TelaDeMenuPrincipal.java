/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.Usuario;

/**
 *
 * @author paulo
 */
public class TelaDeMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public TelaDeMenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbNovaOperacao = new javax.swing.JButton();
        jbClientes = new javax.swing.JButton();
        jbProdutos = new javax.swing.JButton();
        jbRegistros = new javax.swing.JButton();
        jbAdministracao = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jpusuario = new javax.swing.JPanel();
        jlusuario = new javax.swing.JLabel();
        jlusuariotipo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LitePDV");
        setResizable(false);

        jbNovaOperacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/venda.png"))); // NOI18N
        jbNovaOperacao.setText("Nova Operação");
        jbNovaOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovaOperacaoActionPerformed(evt);
            }
        });

        jbClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cliente.png"))); // NOI18N
        jbClientes.setText("Clientes");
        jbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClientesActionPerformed(evt);
            }
        });

        jbProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/produto.png"))); // NOI18N
        jbProdutos.setText("Produtos");
        jbProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProdutosActionPerformed(evt);
            }
        });

        jbRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/compra.png"))); // NOI18N
        jbRegistros.setText("Registros");
        jbRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrosActionPerformed(evt);
            }
        });

        jbAdministracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fornecedor.png"))); // NOI18N
        jbAdministracao.setText("Administração");
        jbAdministracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdministracaoActionPerformed(evt);
            }
        });

        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sair.png"))); // NOI18N
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jlusuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlusuario.setText("<usuario>");

        jlusuariotipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlusuariotipo.setText("<tipo>");

        javax.swing.GroupLayout jpusuarioLayout = new javax.swing.GroupLayout(jpusuario);
        jpusuario.setLayout(jpusuarioLayout);
        jpusuarioLayout.setHorizontalGroup(
            jpusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlusuariotipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        jpusuarioLayout.setVerticalGroup(
            jpusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpusuarioLayout.createSequentialGroup()
                .addComponent(jlusuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlusuariotipo)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbNovaOperacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSair)
                    .addComponent(jbClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAdministracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(jpusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNovaOperacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbProdutos))
                    .addComponent(jpusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbRegistros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAdministracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jbSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovaOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovaOperacaoActionPerformed
	TelaDeVenda win = new TelaDeVenda();
	win.setVisible(true);
        setEnabled(false);
        win.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent g){
                setEnabled(true);
		
            }
        });
    }//GEN-LAST:event_jbNovaOperacaoActionPerformed

    private void jbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClientesActionPerformed
        TelaDeClientes win = new TelaDeClientes();
	win.setVisible(true);
        setEnabled(false);
        win.addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosed(WindowEvent e) {
		 setEnabled(true);
            }
        });
    }//GEN-LAST:event_jbClientesActionPerformed

    private void jbProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProdutosActionPerformed
        TelaDeProdutos win = new TelaDeProdutos();
	win.setVisible(true);
        setEnabled(false);
        win.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent g){
                setEnabled(true);
            }
        });
    }//GEN-LAST:event_jbProdutosActionPerformed

    private void jbRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrosActionPerformed
        TelaDeRelatorios win = new TelaDeRelatorios();
	win.setVisible(true);
        setEnabled(false);
        win.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent g){
                setEnabled(true);
            }
        });
    }//GEN-LAST:event_jbRegistrosActionPerformed

    private void jbAdministracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdministracaoActionPerformed
        TelaDeAdministrador win = new TelaDeAdministrador();
	win.setVisible(true);
        setEnabled(false);
        win.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent g){
                setEnabled(true);
            }
        });
    }//GEN-LAST:event_jbAdministracaoActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSairActionPerformed


    public void setUserAndType(Usuario u){
	jlusuario.setText(u.getNome());
	switch(u.getTipo()){
	    case "A":
		jlusuariotipo.setText("Administrador");
		break;
	    case "O":
		jlusuariotipo.setText("Operador");
		jbAdministracao.setEnabled(false);
		break;
	    default:
		jlusuariotipo.setText("ERRO");
	}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAdministracao;
    private javax.swing.JButton jbClientes;
    private javax.swing.JButton jbNovaOperacao;
    private javax.swing.JButton jbProdutos;
    private javax.swing.JButton jbRegistros;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel jlusuario;
    private javax.swing.JLabel jlusuariotipo;
    private javax.swing.JPanel jpusuario;
    // End of variables declaration//GEN-END:variables
}