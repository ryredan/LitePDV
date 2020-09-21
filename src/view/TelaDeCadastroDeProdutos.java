package view;

import dao.ProdutoDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import model.Produto;

public class TelaDeCadastroDeProdutos extends javax.swing.JFrame {

    private Produto tempproduto;
    
    public TelaDeCadastroDeProdutos() {
	tempproduto = new Produto();
	initComponents();
	jbsalvar.addActionListener(new java.awt.event.ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		cadastrar();
		dispose();
	    }
	});
    }
    
    public TelaDeCadastroDeProdutos(Produto p){
	tempproduto = p;
	initComponents();
	jtfnome.setText(tempproduto.getNome());
	jftfpreco.setValue(tempproduto.getPreco());
	jtadescricao.setText(tempproduto.getDescricao());
	jbsalvar.addActionListener(new java.awt.event.ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		modificar();
		dispose();
	    }
	});
	
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlnome = new javax.swing.JLabel();
        jtfnome = new javax.swing.JTextField();
        jlpreco = new javax.swing.JLabel();
        jldescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtadescricao = new javax.swing.JTextArea();
        jbcancelar = new javax.swing.JButton();
        jbsalvar = new javax.swing.JButton();
        jftfpreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ficha de Produtos");
        setResizable(false);

        jlnome.setText("Nome");

        jtfnome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfnomeFocusLost(evt);
            }
        });
        jtfnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfnomeActionPerformed(evt);
            }
        });

        jlpreco.setText("Preço");

        jldescricao.setText("Descrição");

        jtadescricao.setColumns(20);
        jtadescricao.setRows(5);
        jtadescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtadescricaoFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jtadescricao);

        jbcancelar.setText("Cancelar");
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        jbsalvar.setText("Salvar");
        jbsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalvarActionPerformed(evt);
            }
        });

        jftfpreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jftfpreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftfprecoFocusLost(evt);
            }
        });
        jftfpreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfprecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlnome)
                                .addGap(0, 230, Short.MAX_VALUE))
                            .addComponent(jtfnome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jftfpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlpreco)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jldescricao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbsalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbcancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlnome)
                    .addComponent(jlpreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jldescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbcancelar)
                    .addComponent(jbsalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfnomeActionPerformed
        jftfpreco.requestFocusInWindow();
    }//GEN-LAST:event_jtfnomeActionPerformed

    private void jtfnomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfnomeFocusLost
        tempproduto.setNome(jtfnome.getText());
        if (jtfnome.getText().trim().equals("")){
            jtfnome.setBackground(Color.red);
            tempproduto.setNome(null);
        }else if(tempproduto.getNome().isEmpty()){
            jtfnome.setBackground(Color.red);  
            
	}else{
	    jtfnome.setBackground(Color.white);
        }
    }//GEN-LAST:event_jtfnomeFocusLost

    private void jftfprecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfprecoActionPerformed
        jtadescricao.requestFocusInWindow();
    }//GEN-LAST:event_jftfprecoActionPerformed

    private void jftfprecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfprecoFocusLost
        try{
	    tempproduto.setPreco(Double.parseDouble(jftfpreco.getText()));
        
        if (jtfnome.getText().trim().equals("")){
            jtfnome.setBackground(Color.red);
	}else{
	    jtfnome.setBackground(Color.white);
        }
	}catch(NumberFormatException ex){
	    jftfpreco.setValue(null);
	}
	
    }//GEN-LAST:event_jftfprecoFocusLost

    private void jtadescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtadescricaoFocusLost
        tempproduto.setDescricao(jtadescricao.getText());
    }//GEN-LAST:event_jtadescricaoFocusLost

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void jbsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbsalvarActionPerformed

    private void cadastrar(){
	ProdutoDAO p = new ProdutoDAO();
        p.inserir(tempproduto);        
    }
    
    private void modificar(){
	ProdutoDAO p = new ProdutoDAO();
	p.alterar(tempproduto);
        dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbsalvar;
    private javax.swing.JFormattedTextField jftfpreco;
    private javax.swing.JLabel jldescricao;
    private javax.swing.JLabel jlnome;
    private javax.swing.JLabel jlpreco;
    private javax.swing.JTextArea jtadescricao;
    private javax.swing.JTextField jtfnome;
    // End of variables declaration//GEN-END:variables
}
