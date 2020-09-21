/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ProdutoDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;

public class TelaDeProdutos extends javax.swing.JFrame {

    private ProdutoTableModel ptm = new ProdutoTableModel();
    private ArrayList<Produto> todososprodutos;
    
    public TelaDeProdutos() {
        initComponents();
	updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbnovo = new javax.swing.JButton();
        jbeditar = new javax.swing.JButton();
        jbexcluir = new javax.swing.JButton();
        jbfechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");
        setResizable(false);

        jTable1.setModel(ptm);
        jScrollPane1.setViewportView(jTable1);

        jbnovo.setText("Novo");
        jbnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnovoActionPerformed(evt);
            }
        });

        jbeditar.setText("Editar");
        jbeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeditarActionPerformed(evt);
            }
        });

        jbexcluir.setText("Excluir");
        jbexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbexcluirActionPerformed(evt);
            }
        });

        jbfechar.setText("Fechar");
        jbfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbexcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbeditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbnovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jbfechar))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbnovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbeditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbexcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbfechar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbfecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbfecharActionPerformed

    private void jbnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnovoActionPerformed
        TelaDeCadastroDeProdutos win = new TelaDeCadastroDeProdutos();
	win.setVisible(true);
        setEnabled(false);
        win.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent g){
                updateTable();
                setEnabled(true);
            }
        });
    }//GEN-LAST:event_jbnovoActionPerformed

    private void jbeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeditarActionPerformed
	try{
            TelaDeCadastroDeProdutos win = new TelaDeCadastroDeProdutos(ptm.getProductAtIndex(jTable1.getSelectedRow()));
	    win.setVisible(true);
	    setEnabled(false);
	    win.addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosed(WindowEvent e) {
		 updateTable();
		 setEnabled(true);
            }
        });
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Selecione um PRODUTO", "Atenção",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbeditarActionPerformed

    private void jbexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbexcluirActionPerformed
        try {
        ProdutoDAO p = new ProdutoDAO();
	p.excluir(ptm.getProductAtIndex(jTable1.getSelectedRow()));
	updateTable();
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Selecione um PRODUTO", "Atenção",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbexcluirActionPerformed
    private void updateTable(){
	ProdutoDAO p = new ProdutoDAO();
	todososprodutos = p.listarTodos();
	ptm.setProdList(todososprodutos);
	ptm.fireTableDataChanged();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbeditar;
    private javax.swing.JButton jbexcluir;
    private javax.swing.JButton jbfechar;
    private javax.swing.JButton jbnovo;
    // End of variables declaration//GEN-END:variables
}
