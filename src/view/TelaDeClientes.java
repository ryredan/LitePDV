package view;

import dao.ClienteDAO;
import dao.Conexao;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;

public class TelaDeClientes extends javax.swing.JFrame {

    private ClienteTableModel ctm = new ClienteTableModel();
    private ArrayList<Cliente> todososclientes;
      
    public TelaDeClientes() {
        initComponents();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtclientes = new javax.swing.JTable();
        jbnovo = new javax.swing.JButton();
        jbeditar = new javax.swing.JButton();
        jbexcluir = new javax.swing.JButton();
        jbfechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        jtclientes.setModel(ctm);
        jtclientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtclientes);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbexcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbeditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbfechar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbnovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbeditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbexcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbfechar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnovoActionPerformed
        TelaDeCadastroDeClientes win = new TelaDeCadastroDeClientes();
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
        setEnabled(false);
        try{
            TelaDeCadastroDeClientes win = new TelaDeCadastroDeClientes(ctm.getClientAtIndex(jtclientes.getSelectedRow()));
            win.setVisible(true);
            win.addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosed(WindowEvent e) {
		 updateTable();
		 setEnabled(true);
	    }
	});
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Selecione um CLIENTE", "Atenção",JOptionPane.ERROR_MESSAGE);
            setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jbeditarActionPerformed

    private void jbexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbexcluirActionPerformed
        ClienteDAO c = new ClienteDAO();
	try{
            c.excluir(ctm.getClientAtIndex(jtclientes.getSelectedRow()));
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Selecione um CLIENTE", "Atenção",JOptionPane.ERROR_MESSAGE);
        }
        
	updateTable();
    }//GEN-LAST:event_jbexcluirActionPerformed

    private void jbfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbfecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbfecharActionPerformed
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbeditar;
    private javax.swing.JButton jbexcluir;
    private javax.swing.JButton jbfechar;
    private javax.swing.JButton jbnovo;
    private javax.swing.JTable jtclientes;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {
	ClienteDAO c = new ClienteDAO();
	todososclientes = c.listarTodos();
	ctm.setUserList(todososclientes);
	ctm.fireTableDataChanged();
    }
}
