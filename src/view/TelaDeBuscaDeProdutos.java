package view;

import dao.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;

public class TelaDeBuscaDeProdutos extends javax.swing.JFrame {
    private BuscaProdutoTableModel bptm = new BuscaProdutoTableModel();
    private Produto produtoselecionado;
    
    public TelaDeBuscaDeProdutos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtprodutos = new javax.swing.JTable();
        jtfbuscar = new javax.swing.JTextField();
        jlbuscar = new javax.swing.JLabel();
        jbadicionar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca de Produtos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jtprodutos.setModel(bptm);
        jScrollPane1.setViewportView(jtprodutos);

        jtfbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfbuscarActionPerformed(evt);
            }
        });

        jlbuscar.setText("Buscar:");

        jbadicionar.setText("Adicionar");
        jbadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbadicionarActionPerformed(evt);
            }
        });

        jbcancelar.setText("Cancelar");
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jbadicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbcancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfbuscar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbcancelar)
                    .addComponent(jbadicionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbuscarActionPerformed
        ProdutoDAO p = new ProdutoDAO();
	updateTable(p.pesquisar(jtfbuscar.getText()));
    }//GEN-LAST:event_jtfbuscarActionPerformed

    private void jbadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbadicionarActionPerformed
        try{
	setSelectedProduct(bptm.getProductAtIndex(jtprodutos.convertRowIndexToModel(jtprodutos.getSelectedRow())));
	}catch(IndexOutOfBoundsException ex){
	    JOptionPane.showMessageDialog(null, "Produto não selecionado", "Atenção", JOptionPane.WARNING_MESSAGE);
	}
	dispose();
    }//GEN-LAST:event_jbadicionarActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void updateTable(ArrayList<Produto> list){
	bptm.setProdList(list);
	bptm.fireTableDataChanged();
    }
    public Produto getSelectedProduct(){
	return produtoselecionado;
    }
    private void setSelectedProduct(Produto p){
	produtoselecionado = p;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbadicionar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JLabel jlbuscar;
    private javax.swing.JTextField jtfbuscar;
    private javax.swing.JTable jtprodutos;
    // End of variables declaration//GEN-END:variables
}
