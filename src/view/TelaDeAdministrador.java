package view;

import dao.UsuarioDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

public class TelaDeAdministrador extends javax.swing.JFrame {

    private UsuarioTableModel utm = new UsuarioTableModel();
    private ArrayList<Usuario> todososusuarios;
    
    public TelaDeAdministrador() {
        initComponents();
	updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtusuarios = new javax.swing.JTable();
        jbnovo = new javax.swing.JButton();
        jbeditar = new javax.swing.JButton();
        jbexcluir = new javax.swing.JButton();
        jbfechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administração");
        setResizable(false);

        jtusuarios.setModel(utm);
        jtusuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtusuarios);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbnovo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbeditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbexcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbfechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbnovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbeditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbexcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbfechar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbfecharActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbfecharActionPerformed

    private void jbnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnovoActionPerformed
	TelaDeCadastroDeUsuarios win = new TelaDeCadastroDeUsuarios();
	win.setVisible(true);
	setEnabled(false);
	win.addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosed(WindowEvent e) {
		 updateTable();
		 setEnabled(true);
	    }
	    
	});
    }//GEN-LAST:event_jbnovoActionPerformed

    private void jbeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeditarActionPerformed
        try{
            TelaDeCadastroDeUsuarios win = new TelaDeCadastroDeUsuarios(utm.getUserAtIndex(jtusuarios.getSelectedRow()));
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
            JOptionPane.showMessageDialog(null, "Selecione um USUÁRIO", "Atenção",JOptionPane.ERROR_MESSAGE);        
        }
    }//GEN-LAST:event_jbeditarActionPerformed

    private void jbexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbexcluirActionPerformed
       try{
           UsuarioDAO u = new UsuarioDAO();
	u.excluir(utm.getUserAtIndex(jtusuarios.getSelectedRow()));
	updateTable();
       }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Selecione um USUÁRIO", "Atenção",JOptionPane.ERROR_MESSAGE);        
        }        
    }//GEN-LAST:event_jbexcluirActionPerformed
    private void updateTable(){
	UsuarioDAO u = new UsuarioDAO();
	todososusuarios = u.listarTodos();
	utm.setUserList(todososusuarios);
	utm.fireTableDataChanged();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbeditar;
    private javax.swing.JButton jbexcluir;
    private javax.swing.JButton jbfechar;
    private javax.swing.JButton jbnovo;
    private javax.swing.JTable jtusuarios;
    // End of variables declaration//GEN-END:variables
}
