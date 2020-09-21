package view;

import controller.DataCheck;
import controller.PessoaC;
import dao.UsuarioDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;

public class TelaDeCadastroDeUsuarios extends javax.swing.JFrame {

    private Usuario tempuser;
    private String cpfatual;
    private String identificacaoatual;
    private String loginatual;
    private String emailatual;

    public TelaDeCadastroDeUsuarios() {
	this.tempuser = new Usuario();
	initComponents();
	setButtonGroupConfig();
	jbsalvar.addActionListener(new java.awt.event.ActionListener(){
	    public void actionPerformed(java.awt.event.ActionEvent evt){
		cadastrar();
	    }
	});
    }
    
    public TelaDeCadastroDeUsuarios(Usuario u){
	this.tempuser = u;
	initComponents();
	setButtonGroupConfig();
	jtflogin.setText(tempuser.getLogin());
	jpfsenha.setText(tempuser.getSenha());
	jftfidentificacao.setText(tempuser.getIdentificacao());
	jtfnome.setText(tempuser.getNome());
	jftfdatadenascimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(tempuser.getDatadenascimento().getTime()));
	jftfcpf.setText(tempuser.getCpf());
	jtfemail.setText(tempuser.getEmail());
	jftftelefone.setText(tempuser.getTelefone());
	jftfcelular.setText(tempuser.getCelular());
	switch(tempuser.getTipo()){
	    case "A":
		jrbAdministrador.doClick();
		break;
	    case "O":
		jrbOperador.doClick();
		break;
	}
	cpfatual = tempuser.getCpf();
	identificacaoatual = tempuser.getIdentificacao();
	loginatual = tempuser.getLogin();
	emailatual = tempuser.getEmail();
	
	jbsalvar.addActionListener(new java.awt.event.ActionListener(){
	    public void actionPerformed(java.awt.event.ActionEvent evt){
		modificar();
	    }
	});
	

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpdadospessoais = new javax.swing.JPanel();
        jlemail = new javax.swing.JLabel();
        jtfnome = new javax.swing.JTextField();
        jtfemail = new javax.swing.JTextField();
        jlnome = new javax.swing.JLabel();
        jlidentificacao = new javax.swing.JLabel();
        jldatadenascimento = new javax.swing.JLabel();
        jftfdatadenascimento = new javax.swing.JFormattedTextField();
        jlcpf = new javax.swing.JLabel();
        jftfcpf = new javax.swing.JFormattedTextField();
        jltelefone = new javax.swing.JLabel();
        jlcelular = new javax.swing.JLabel();
        jftftelefone = new javax.swing.JFormattedTextField();
        jftfcelular = new javax.swing.JFormattedTextField();
        jftfidentificacao = new javax.swing.JFormattedTextField();
        jpacesso = new javax.swing.JPanel();
        jllogin = new javax.swing.JLabel();
        jlsenha = new javax.swing.JLabel();
        jtflogin = new javax.swing.JTextField();
        jpfsenha = new javax.swing.JPasswordField();
        jpfconfirmesenha = new javax.swing.JPasswordField();
        jlconfirmesenha = new javax.swing.JLabel();
        jptipodeacesso = new javax.swing.JPanel();
        jrbAdministrador = new javax.swing.JRadioButton();
        jrbOperador = new javax.swing.JRadioButton();
        jbsalvar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ficha de Usuario");
        setResizable(false);

        jpdadospessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jlemail.setText("E-mail:");

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

        jtfemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfemailFocusLost(evt);
            }
        });
        jtfemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfemailActionPerformed(evt);
            }
        });

        jlnome.setText("Nome:");

        jlidentificacao.setText("Identificação:");

        jldatadenascimento.setText("Data de Nascimento:");

        try {
            jftfdatadenascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfdatadenascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftfdatadenascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftfdatadenascimentoFocusLost(evt);
            }
        });
        jftfdatadenascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfdatadenascimentoActionPerformed(evt);
            }
        });

        jlcpf.setText("C.P.F:");

        try {
            jftfcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfcpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftfcpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftfcpfFocusLost(evt);
            }
        });
        jftfcpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfcpfActionPerformed(evt);
            }
        });

        jltelefone.setText("Telefone:");

        jlcelular.setText("Celular:");

        try {
            jftftelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftftelefone.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftftelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftftelefoneFocusLost(evt);
            }
        });
        jftftelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftftelefoneActionPerformed(evt);
            }
        });

        try {
            jftfcelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfcelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftfcelularFocusLost(evt);
            }
        });
        jftfcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfcelularActionPerformed(evt);
            }
        });

        try {
            jftfidentificacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfidentificacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftfidentificacaoFocusLost(evt);
            }
        });
        jftfidentificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfidentificacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpdadospessoaisLayout = new javax.swing.GroupLayout(jpdadospessoais);
        jpdadospessoais.setLayout(jpdadospessoaisLayout);
        jpdadospessoaisLayout.setHorizontalGroup(
            jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                        .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jftfcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(307, 307, 307))
                            .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                                .addComponent(jlcpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlidentificacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jftfidentificacao))
                    .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                        .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jltelefone)
                            .addComponent(jlemail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                                .addComponent(jftftelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jlcelular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jftfcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfemail)))
                    .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                        .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                                .addComponent(jlnome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfnome, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                                .addGap(391, 391, 391)
                                .addComponent(jldatadenascimento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftfdatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jpdadospessoaisLayout.setVerticalGroup(
            jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpdadospessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlnome)
                    .addComponent(jldatadenascimento)
                    .addComponent(jtfnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfdatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlcpf)
                        .addComponent(jlidentificacao)
                        .addComponent(jftfidentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jftfcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jltelefone)
                    .addComponent(jlcelular)
                    .addComponent(jftftelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlemail))
                .addContainerGap())
        );

        jpacesso.setBorder(javax.swing.BorderFactory.createTitledBorder("Acesso"));

        jllogin.setText("Login:");

        jlsenha.setText("Senha:");

        jtflogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfloginFocusLost(evt);
            }
        });
        jtflogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfloginActionPerformed(evt);
            }
        });

        jpfsenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfsenhaFocusLost(evt);
            }
        });
        jpfsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfsenhaActionPerformed(evt);
            }
        });

        jpfconfirmesenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfconfirmesenhaFocusLost(evt);
            }
        });
        jpfconfirmesenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfconfirmesenhaActionPerformed(evt);
            }
        });

        jlconfirmesenha.setText("Confirme a senha:");

        jptipodeacesso.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Usuário"));

        jrbAdministrador.setText("Administrador");
        jrbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAdministradorActionPerformed(evt);
            }
        });

        jrbOperador.setText("Operador");
        jrbOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOperadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jptipodeacessoLayout = new javax.swing.GroupLayout(jptipodeacesso);
        jptipodeacesso.setLayout(jptipodeacessoLayout);
        jptipodeacessoLayout.setHorizontalGroup(
            jptipodeacessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jptipodeacessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jptipodeacessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbOperador)
                    .addComponent(jrbAdministrador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jptipodeacessoLayout.setVerticalGroup(
            jptipodeacessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jptipodeacessoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbOperador))
        );

        javax.swing.GroupLayout jpacessoLayout = new javax.swing.GroupLayout(jpacesso);
        jpacesso.setLayout(jpacessoLayout);
        jpacessoLayout.setHorizontalGroup(
            jpacessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpacessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpacessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jllogin)
                    .addComponent(jlconfirmesenha)
                    .addComponent(jpfconfirmesenha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpacessoLayout.createSequentialGroup()
                        .addGroup(jpacessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtflogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlsenha))
                        .addGap(18, 18, 18)
                        .addComponent(jptipodeacesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpacessoLayout.setVerticalGroup(
            jpacessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpacessoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jllogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpacessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpacessoLayout.createSequentialGroup()
                        .addComponent(jtflogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlsenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpfsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jptipodeacesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlconfirmesenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfconfirmesenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbsalvar.setText("Salvar");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpdadospessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpacesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jpdadospessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpacesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbsalvar)
                    .addComponent(jbcancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfnomeActionPerformed
	jftfdatadenascimento.requestFocusInWindow();
    }//GEN-LAST:event_jtfnomeActionPerformed

    private void jtfnomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfnomeFocusLost
	if (jtfnome.getText().length() > 100){
            JOptionPane.showMessageDialog(null, "Nome execede o numero de cacteres permitidos","Atenção",JOptionPane.INFORMATION_MESSAGE);
	    tempuser.setNome(jtfnome.getText().substring(0, 100));
        }else{
	    tempuser.setNome(jtfnome.getText());
	}
	if(tempuser.getNome().isEmpty()){ //Metodo que verifica se o nome digitado esta vazio;
	    jtfnome.setBackground(Color.red);
	}else{
	    jtfnome.setBackground(Color.white);
	}
                       
	
    }//GEN-LAST:event_jtfnomeFocusLost

    private void jftfdatadenascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfdatadenascimentoActionPerformed
        jftfcpf.requestFocusInWindow();
    }//GEN-LAST:event_jftfdatadenascimentoActionPerformed

    private void jftfdatadenascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfdatadenascimentoFocusLost
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	try{
	Date ddn = sdf.parse(jftfdatadenascimento.getText());
	tempuser.setDatadenascimento(ddn);
	jftfdatadenascimento.setBackground(Color.white);
	}catch(ParseException e){
	    tempuser.setDatadenascimento(null);
	    jftfdatadenascimento.setBackground(Color.red);
	    jftfdatadenascimento.setCaretPosition(0);
	}
    }//GEN-LAST:event_jftfdatadenascimentoFocusLost

    private void jftfcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfcpfActionPerformed
        jftfidentificacao.requestFocusInWindow();
    }//GEN-LAST:event_jftfcpfActionPerformed

    private void jftfcpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfcpfFocusLost
        if(jftfcpf.getText().trim().length() == 14){
	    try{
		if(jftfcpf.getText().equals(cpfatual)){
		    tempuser.setCpf(cpfatual);
		    jftfcpf.setBackground(Color.white);
		}else if(!DataCheck.entryExists("tbusuarios", "cpf", jftfcpf.getText())){
		    tempuser.setCpf(jftfcpf.getText());
		    jftfcpf.setBackground(Color.white);
		}else{
		    tempuser.setCpf(null);
		    jftfcpf.setBackground(Color.red);
		}
	    }catch(ClassNotFoundException e){
		System.out.println("Erro de Driver");
	    }catch(SQLException e){
		System.out.println("Erro de comando");
	    }
	}else{
	    tempuser.setCpf(null);
	    jftfcpf.setBackground(Color.red);
	}
	
    }//GEN-LAST:event_jftfcpfFocusLost

    private void jftfidentificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfidentificacaoActionPerformed
        jftftelefone.requestFocusInWindow();
    }//GEN-LAST:event_jftfidentificacaoActionPerformed

    private void jftfidentificacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfidentificacaoFocusLost
	if(jftfidentificacao.getText().trim().length() == 10){
	    try{
		if(jftfidentificacao.getText().equals(identificacaoatual)){
		    tempuser.setIdentificacao(identificacaoatual);
		    jftfidentificacao.setBackground(Color.white);
		}else if(!DataCheck.entryExists("tbusuarios", "identificacao", jftfidentificacao.getText())){
		    tempuser.setIdentificacao(jftfidentificacao.getText());
		    jftfidentificacao.setBackground(Color.white);
		}else{
		    tempuser.setIdentificacao(null);
		    jftfidentificacao.setBackground(Color.red);
		}
	    }catch(ClassNotFoundException e){
		System.out.println("Erro de Driver");
	    }catch(SQLException e){
		System.out.println("Erro de comando");
	    }
	}else{
	    tempuser.setIdentificacao(null);
	    jftfidentificacao.setBackground(Color.red);
	}
	
    }//GEN-LAST:event_jftfidentificacaoFocusLost

    private void jftftelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftftelefoneActionPerformed
        jftfcelular.requestFocusInWindow();
    }//GEN-LAST:event_jftftelefoneActionPerformed

    private void jftftelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftftelefoneFocusLost
        tempuser.setTelefone(jftftelefone.getText());
    }//GEN-LAST:event_jftftelefoneFocusLost

    private void jftfcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfcelularActionPerformed
	jtfemail.requestFocusInWindow();
    }//GEN-LAST:event_jftfcelularActionPerformed

    private void jftfcelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfcelularFocusLost
        tempuser.setCelular(jftfcelular.getText());
    }//GEN-LAST:event_jftfcelularFocusLost

    private void jtfemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfemailActionPerformed
        jtflogin.requestFocusInWindow();
    }//GEN-LAST:event_jtfemailActionPerformed

    private void jtfemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfemailFocusLost
	if(jtfemail.getText().isEmpty()){
	    tempuser.setEmail(null);
	    jtfemail.setBackground(Color.red);
	}else{
	    try{
		if(jtfemail.getText().equals(emailatual)){
		    tempuser.setEmail(emailatual);
		    jtfemail.setBackground(Color.white);
		}else if(!DataCheck.entryExists("tbusuarios", "email", jtfemail.getText())){
		    tempuser.setEmail(jtfemail.getText());
		    jtfemail.setBackground(Color.white);
		}else{
		    tempuser.setEmail(null);
		    jtfemail.setBackground(Color.red);
		}
	    }catch(ClassNotFoundException e){
		System.out.println("Erro de Driver");
	    }catch(SQLException e){
		System.out.println("Erro de comando");
	    }
	}
    }//GEN-LAST:event_jtfemailFocusLost

    private void jtfloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfloginActionPerformed
        jpfsenha.requestFocusInWindow();
    }//GEN-LAST:event_jtfloginActionPerformed

    private void jtfloginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfloginFocusLost
        if(jtflogin.getText().isEmpty()){
	    jtflogin.setBackground(Color.red);
	    tempuser.setLogin(null);
	}else{
	    try{
		if(jtflogin.getText().equals(loginatual)){
		    tempuser.setLogin(loginatual);
		    jtflogin.setBackground(Color.white);
		}else if(!DataCheck.entryExists("tbusuarios", "login", jtflogin.getText())){
		    tempuser.setLogin(jtflogin.getText());
		    jtflogin.setBackground(Color.white);
		}else{
		    tempuser.setLogin(null);
		    jtflogin.setBackground(Color.red);
		}
	    }catch(ClassNotFoundException e){
		System.out.println("Erro de Driver");
	    }catch(SQLException e){
		System.out.println("Erro de comando");
	    }
	}
    }//GEN-LAST:event_jtfloginFocusLost

    private void jpfsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfsenhaActionPerformed
        jpfconfirmesenha.requestFocusInWindow();
    }//GEN-LAST:event_jpfsenhaActionPerformed

    private void jpfsenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfsenhaFocusLost
/*        String senha = new String(jpfsenha.getPassword());
        if(senha.isEmpty()){
	    jpfsenha.setBackground(Color.red);
	    tempuser.setSenha(null);
	}else{
	    
	}
*/
    }//GEN-LAST:event_jpfsenhaFocusLost

    private void jpfconfirmesenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfconfirmesenhaActionPerformed
        jbsalvar.requestFocusInWindow();
    }//GEN-LAST:event_jpfconfirmesenhaActionPerformed

    private void jpfconfirmesenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfconfirmesenhaFocusLost
        String senha = new String(jpfsenha.getPassword());
	String confirmacao = new String(jpfconfirmesenha.getPassword());
        if (confirmacao.equals("")){
            tempuser.setSenha(null);
	    jpfconfirmesenha.setBackground(Color.red);
        }else if(confirmacao.equals(senha)){
	    tempuser.setSenha(confirmacao);
            jpfconfirmesenha.setBackground(Color.white);
	}else{
	    jpfconfirmesenha.setBackground(Color.red);
	}
    }//GEN-LAST:event_jpfconfirmesenhaFocusLost

    private void jrbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAdministradorActionPerformed
        tempuser.setTipo("A");
    }//GEN-LAST:event_jrbAdministradorActionPerformed

    private void jrbOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOperadorActionPerformed
        tempuser.setTipo("O");
    }//GEN-LAST:event_jrbOperadorActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbcancelarActionPerformed
	
    private void cadastrar(){
	if(PessoaC.isEntryValid(tempuser)){
            try {
                UsuarioDAO u = new UsuarioDAO();
                u.inserir(tempuser);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(TelaDeCadastroDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Dados inválidos", "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void modificar(){
        if(PessoaC.isEntryValid(tempuser)){
            try {
                UsuarioDAO u = new UsuarioDAO();
                u.alterar(tempuser);
                dispose();
            }catch (Exception ex) {
                Logger.getLogger(TelaDeCadastroDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Dados inválidos", "Erro no cadastro", JOptionPane.ERROR_MESSAGE);       
        }
    }
    private void setButtonGroupConfig(){
	buttonGroup1.add(jrbAdministrador);
	buttonGroup1.add(jrbOperador);
    }
    
    public void lockOnAdmin(){
	    jrbAdministrador.doClick();
	    jrbAdministrador.setEnabled(false);
	    jrbOperador.setEnabled(false);
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbsalvar;
    private javax.swing.JFormattedTextField jftfcelular;
    private javax.swing.JFormattedTextField jftfcpf;
    private javax.swing.JFormattedTextField jftfdatadenascimento;
    private javax.swing.JFormattedTextField jftfidentificacao;
    private javax.swing.JFormattedTextField jftftelefone;
    private javax.swing.JLabel jlcelular;
    private javax.swing.JLabel jlconfirmesenha;
    private javax.swing.JLabel jlcpf;
    private javax.swing.JLabel jldatadenascimento;
    private javax.swing.JLabel jlemail;
    private javax.swing.JLabel jlidentificacao;
    private javax.swing.JLabel jllogin;
    private javax.swing.JLabel jlnome;
    private javax.swing.JLabel jlsenha;
    private javax.swing.JLabel jltelefone;
    private javax.swing.JPanel jpacesso;
    private javax.swing.JPanel jpdadospessoais;
    private javax.swing.JPasswordField jpfconfirmesenha;
    private javax.swing.JPasswordField jpfsenha;
    private javax.swing.JPanel jptipodeacesso;
    private javax.swing.JRadioButton jrbAdministrador;
    private javax.swing.JRadioButton jrbOperador;
    private javax.swing.JTextField jtfemail;
    private javax.swing.JTextField jtflogin;
    private javax.swing.JTextField jtfnome;
    // End of variables declaration//GEN-END:variables
}
