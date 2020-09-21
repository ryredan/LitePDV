package view;

import controller.DataCheck;
import controller.PessoaC;
import dao.ClienteDAO;
import dao.Conexao;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Cliente;

public class TelaDeCadastroDeClientes extends javax.swing.JFrame {
    private String cpfatual;
    private Cliente tempclient;
    /**
     * Creates new form TelaDeCadastroDeClientes
     */
    public TelaDeCadastroDeClientes() {
	tempclient = new Cliente();
        initComponents();
	jbsalvar.addActionListener(new java.awt.event.ActionListener(){
	    public void actionPerformed(java.awt.event.ActionEvent evt){
		cadastrar();
	    }
	});
        
    }
        public TelaDeCadastroDeClientes(Cliente c) throws SQLException{
	this.tempclient = c;
	initComponents();
	jtfnome.setText(tempclient.getNome());
	jftfdatadenascimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(tempclient.getDatadenascimento().getTime()));
	jftfcpf.setText(tempclient.getCpf());
	jtflogradouro.setText(tempclient.getEndereco());
	jtfnumero.setText(tempclient.getNumerocasa());
	jtfcomplemento.setText(tempclient.getComplemento());
	jftfcep.setText(tempclient.getCep());
	jtfbairro.setText(tempclient.getBairro());
	jtfcidade.setText(tempclient.getCidade());
	jcbuf.setSelectedItem(tempclient.getUf());
	jftftelefone.setText(tempclient.getTelefone());
	jftfcelular.setText(tempclient.getCelular());
	jtfemail.setText(tempclient.getEmail());
        cpfatual = tempclient.getCpf();
      	jbsalvar.addActionListener(new java.awt.event.ActionListener(){
	    public void actionPerformed(java.awt.event.ActionEvent evt){
		modificar();
	    }
	});
	

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpdadospessoais = new javax.swing.JPanel();
        jlnome = new javax.swing.JLabel();
        jtfnome = new javax.swing.JTextField();
        jldatadenascimento = new javax.swing.JLabel();
        jftfdatadenascimento = new javax.swing.JFormattedTextField();
        jlcpf = new javax.swing.JLabel();
        jftfcpf = new javax.swing.JFormattedTextField();
        jpendereco = new javax.swing.JPanel();
        jlendereco = new javax.swing.JLabel();
        jtflogradouro = new javax.swing.JTextField();
        jlnumero = new javax.swing.JLabel();
        jtfnumero = new javax.swing.JTextField();
        jlcomplemento = new javax.swing.JLabel();
        jtfcomplemento = new javax.swing.JTextField();
        jlcidade = new javax.swing.JLabel();
        jtfcidade = new javax.swing.JTextField();
        jluf = new javax.swing.JLabel();
        jcbuf = new javax.swing.JComboBox<>();
        jlcep = new javax.swing.JLabel();
        jftfcep = new javax.swing.JFormattedTextField();
        jlbairro = new javax.swing.JLabel();
        jtfbairro = new javax.swing.JTextField();
        jpcontato = new javax.swing.JPanel();
        jltelefone = new javax.swing.JLabel();
        jftftelefone = new javax.swing.JFormattedTextField();
        jlcelular = new javax.swing.JLabel();
        jftfcelular = new javax.swing.JFormattedTextField();
        jlemail = new javax.swing.JLabel();
        jtfemail = new javax.swing.JTextField();
        jbcancelar = new javax.swing.JButton();
        jbsalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ficha do Cliente");
        setResizable(false);

        jpdadospessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

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

        jldatadenascimento.setText("Data de Nascimento");

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

        jlcpf.setText("C.P.F");

        try {
            jftfcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfcpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftfcpf.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
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

        javax.swing.GroupLayout jpdadospessoaisLayout = new javax.swing.GroupLayout(jpdadospessoais);
        jpdadospessoais.setLayout(jpdadospessoaisLayout);
        jpdadospessoaisLayout.setHorizontalGroup(
            jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                        .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlnome)
                            .addComponent(jtfnome, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jldatadenascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jftfdatadenascimento)))
                    .addComponent(jlcpf)
                    .addComponent(jftfcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpdadospessoaisLayout.setVerticalGroup(
            jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdadospessoaisLayout.createSequentialGroup()
                .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlnome)
                    .addComponent(jldatadenascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfdatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlcpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jftfcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jpendereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jlendereco.setText("Logradouro");

        jtflogradouro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtflogradouroFocusLost(evt);
            }
        });
        jtflogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtflogradouroActionPerformed(evt);
            }
        });

        jlnumero.setText("Numero");

        jtfnumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfnumeroFocusLost(evt);
            }
        });
        jtfnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfnumeroActionPerformed(evt);
            }
        });

        jlcomplemento.setText("Complemento");

        jtfcomplemento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfcomplementoFocusLost(evt);
            }
        });
        jtfcomplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfcomplementoActionPerformed(evt);
            }
        });

        jlcidade.setText("Cidade");

        jtfcidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfcidadeFocusLost(evt);
            }
        });
        jtfcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfcidadeActionPerformed(evt);
            }
        });

        jluf.setText("UF");

        jcbuf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jcbuf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcbufFocusLost(evt);
            }
        });
        jcbuf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbufActionPerformed(evt);
            }
        });

        jlcep.setText("CEP");

        try {
            jftfcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfcep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftfcep.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftfcep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftfcepFocusLost(evt);
            }
        });
        jftfcep.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jftfcepInputMethodTextChanged(evt);
            }
        });
        jftfcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfcepActionPerformed(evt);
            }
        });

        jlbairro.setText("Bairro");

        jtfbairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfbairroFocusLost(evt);
            }
        });
        jtfbairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfbairroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpenderecoLayout = new javax.swing.GroupLayout(jpendereco);
        jpendereco.setLayout(jpenderecoLayout);
        jpenderecoLayout.setHorizontalGroup(
            jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpenderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpenderecoLayout.createSequentialGroup()
                        .addComponent(jlcomplemento)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpenderecoLayout.createSequentialGroup()
                        .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpenderecoLayout.createSequentialGroup()
                                .addComponent(jlendereco)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfcomplemento)
                            .addComponent(jtflogradouro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpenderecoLayout.createSequentialGroup()
                                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfbairro)
                                    .addGroup(jpenderecoLayout.createSequentialGroup()
                                        .addComponent(jlbairro)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlcidade)
                                    .addComponent(jtfcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlcep)
                            .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlnumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfnumero))
                            .addComponent(jftfcep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jluf))
                        .addGap(45, 45, 45))))
        );
        jpenderecoLayout.setVerticalGroup(
            jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpenderecoLayout.createSequentialGroup()
                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlendereco)
                    .addComponent(jlnumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtflogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlcomplemento)
                    .addComponent(jlcep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlcidade)
                    .addComponent(jluf)
                    .addComponent(jlbairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpenderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpcontato.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        jltelefone.setText("Telefone");

        try {
            jftftelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
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

        jlcelular.setText("Celular");

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

        jlemail.setText("Email");

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

        javax.swing.GroupLayout jpcontatoLayout = new javax.swing.GroupLayout(jpcontato);
        jpcontato.setLayout(jpcontatoLayout);
        jpcontatoLayout.setHorizontalGroup(
            jpcontatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpcontatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpcontatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlemail)
                    .addGroup(jpcontatoLayout.createSequentialGroup()
                        .addGroup(jpcontatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jltelefone)
                            .addComponent(jftftelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpcontatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlcelular)
                            .addComponent(jftfcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtfemail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpcontatoLayout.setVerticalGroup(
            jpcontatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpcontatoLayout.createSequentialGroup()
                .addGroup(jpcontatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jltelefone)
                    .addComponent(jlcelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpcontatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jftftelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlemail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jbcancelar.setText("Cancelar");
        jbcancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpdadospessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpendereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpcontato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbsalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbcancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpdadospessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpcontato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbcancelar)
                    .addComponent(jbsalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfnomeActionPerformed
        jftfdatadenascimento.requestFocusInWindow();
    }//GEN-LAST:event_jtfnomeActionPerformed

    private void jtfnomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfnomeFocusLost
       
        tempclient.setNome(jtfnome.getText());
        
        if (jtfnome.getText().trim().equals("")){
            jtfnome.setBackground(Color.red);
            tempclient.setNome(null);
                     
        }else if(tempclient.getNome().isEmpty()){
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
	tempclient.setDatadenascimento(ddn);
	jftfdatadenascimento.setBackground(Color.white);
	}catch(ParseException e){
	    tempclient.setDatadenascimento(null);
	    jftfdatadenascimento.setBackground(Color.red);
	    jftfdatadenascimento.setCaretPosition(0);            
        }
    }//GEN-LAST:event_jftfdatadenascimentoFocusLost

    private void jftfcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfcpfActionPerformed
        jtflogradouro.requestFocusInWindow();
    }//GEN-LAST:event_jftfcpfActionPerformed

    private void jftfcpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfcpfFocusLost
        if(jftfcpf.getText().trim().length() == 14){ //testa se o CPF eh valido;	     	
            try{
		if(jftfcpf.getText().equals(cpfatual)){
		    tempclient.setCpf(cpfatual);
		    jftfcpf.setBackground(Color.white);
		}else if(!DataCheck.entryExists("tbclientes", "cpf", jftfcpf.getText())){ //|| (informacoes.equals(jftfcpf.getText()))){
                    tempclient.setCpf(jftfcpf.getText());
                    jftfcpf.setBackground(Color.white);
                }else{
                    tempclient.setCpf(null);
                    jftfcpf.setBackground(Color.red);
                }
                }catch(ClassNotFoundException e){
                    System.out.println("Erro de Driver");
                }catch(SQLException e){
                    System.out.println("Erro de comando");
                }
        }else{ 	 
            tempclient.setCpf(null);
            jftfcpf.setBackground(Color.red);
        }
    }//GEN-LAST:event_jftfcpfFocusLost

    private void jtflogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtflogradouroActionPerformed
        jtfnumero.requestFocusInWindow();
    }//GEN-LAST:event_jtflogradouroActionPerformed

    private void jtflogradouroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtflogradouroFocusLost
        tempclient.setEndereco(jtflogradouro.getText());
        if (jtflogradouro.getText().trim().equals("") ){
            tempclient.setEndereco(null);
            jtflogradouro.setBackground(Color.red);
        }
        else if(tempclient.getEndereco().isEmpty()){
	    jtflogradouro.setBackground(Color.red);
	}else{
	    jtflogradouro.setBackground(Color.white);
	}
    }//GEN-LAST:event_jtflogradouroFocusLost

    private void jtfnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfnumeroActionPerformed
        jtfcomplemento.requestFocusInWindow();
    }//GEN-LAST:event_jtfnumeroActionPerformed

    private void jtfnumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfnumeroFocusLost
        tempclient.setNumerocasa(jtfnumero.getText());
        if (jtfnumero.getText().trim().equals("")){
            tempclient.setNumerocasa(null);
            jtfnumero.setBackground(Color.red);
        }
        else if(tempclient.getNumerocasa().isEmpty()){
	    jtfnumero.setBackground(Color.red);
	}else{
	    jtfnumero.setBackground(Color.white);
	}
    }//GEN-LAST:event_jtfnumeroFocusLost

    private void jtfcomplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfcomplementoActionPerformed
       jftfcep.requestFocusInWindow();
    }//GEN-LAST:event_jtfcomplementoActionPerformed

    private void jtfcomplementoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfcomplementoFocusLost
        tempclient.setComplemento(jtfcomplemento.getText());
    }//GEN-LAST:event_jtfcomplementoFocusLost

    private void jftfcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfcepActionPerformed
        jtfbairro.requestFocusInWindow();
    }//GEN-LAST:event_jftfcepActionPerformed

    private void jftfcepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfcepFocusLost
        if(jftfcep.getText().replaceAll(" ", "").length() == 9){ 	  
            tempclient.setCep(jftfcep.getText());
            jftfcep.setBackground(Color.white);
        }else{ 	     
            JOptionPane.showMessageDialog(null, "CEP Invalido");
            jftfcep.setBackground(Color.red);
        }
        
        
    }//GEN-LAST:event_jftfcepFocusLost

    private void jtfcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfcidadeActionPerformed
        jcbuf.requestFocusInWindow();
    }//GEN-LAST:event_jtfcidadeActionPerformed

    private void jtfcidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfcidadeFocusLost
        tempclient.setCidade(jtfcidade.getText());
        if (jtfcidade.getText().trim().equals("")){
            tempclient.setCidade(null);
            jtfcidade.setBackground(Color.red);
        }else{
            jtfcidade.setBackground(Color.white);
        }
        
    }//GEN-LAST:event_jtfcidadeFocusLost

    private void jcbufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbufActionPerformed
        jftftelefone.requestFocusInWindow();
    }//GEN-LAST:event_jcbufActionPerformed

    private void jcbufFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbufFocusLost
        tempclient.setUf(jcbuf.getSelectedItem().toString());
    }//GEN-LAST:event_jcbufFocusLost

    private void jftftelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftftelefoneActionPerformed
        jftfcelular.requestFocusInWindow();
    }//GEN-LAST:event_jftftelefoneActionPerformed

    private void jftftelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftftelefoneFocusLost
        tempclient.setTelefone(jftftelefone.getText());
        if (jftftelefone.getText().equals("")){
            tempclient.setTelefone(null);
            jtfnumero.setBackground(Color.red);
        }else{
            jtfnumero.setBackground(Color.white);
        }
        
    }//GEN-LAST:event_jftftelefoneFocusLost

    private void jftfcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfcelularActionPerformed
        jtfemail.requestFocusInWindow();
    }//GEN-LAST:event_jftfcelularActionPerformed

    private void jftfcelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfcelularFocusLost
        tempclient.setCelular(jftfcelular.getText());
    }//GEN-LAST:event_jftfcelularFocusLost

    private void jtfemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfemailActionPerformed
        jbsalvar.requestFocusInWindow();
    }//GEN-LAST:event_jtfemailActionPerformed

    private void jtfemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfemailFocusLost
        tempclient.setEmail(jtfemail.getText());
    }//GEN-LAST:event_jtfemailFocusLost

    private void cadastrar(){
	if(PessoaC.isEntryValid(tempclient)){
	    ClienteDAO c = new ClienteDAO();
	    c.inserir(tempclient);
	    dispose();
	}else{
	    JOptionPane.showMessageDialog(null, "Dados invalidos", "Erro", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    private void modificar(){
        if(PessoaC.isEntryValid(tempclient)){
           ClienteDAO c = new ClienteDAO();
           c.alterar(tempclient);
           dispose();
        }else{
	    JOptionPane.showMessageDialog(null, "Dados invalidos", "Erro", JOptionPane.ERROR_MESSAGE);
	}
    }
    private void jtfbairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbairroActionPerformed
        jtfcidade.requestFocusInWindow();
        
    }//GEN-LAST:event_jtfbairroActionPerformed

    private void jtfbairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfbairroFocusLost
        tempclient.setBairro(jtfbairro.getText());
        if (jtfbairro.getText().trim().equals("")){
            tempclient.setBairro(null);
            jtfbairro.setBackground(Color.red);
        }else{
            jtfbairro.setBackground(Color.white);
        }
    }//GEN-LAST:event_jtfbairroFocusLost

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void jbsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbsalvarActionPerformed

    private void jftfcepInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jftfcepInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jftfcepInputMethodTextChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbsalvar;
    private javax.swing.JComboBox<String> jcbuf;
    private javax.swing.JFormattedTextField jftfcelular;
    private javax.swing.JFormattedTextField jftfcep;
    private javax.swing.JFormattedTextField jftfcpf;
    private javax.swing.JFormattedTextField jftfdatadenascimento;
    private javax.swing.JFormattedTextField jftftelefone;
    private javax.swing.JLabel jlbairro;
    private javax.swing.JLabel jlcelular;
    private javax.swing.JLabel jlcep;
    private javax.swing.JLabel jlcidade;
    private javax.swing.JLabel jlcomplemento;
    private javax.swing.JLabel jlcpf;
    private javax.swing.JLabel jldatadenascimento;
    private javax.swing.JLabel jlemail;
    private javax.swing.JLabel jlendereco;
    private javax.swing.JLabel jlnome;
    private javax.swing.JLabel jlnumero;
    private javax.swing.JLabel jltelefone;
    private javax.swing.JLabel jluf;
    private javax.swing.JPanel jpcontato;
    private javax.swing.JPanel jpdadospessoais;
    private javax.swing.JPanel jpendereco;
    private javax.swing.JTextField jtfbairro;
    private javax.swing.JTextField jtfcidade;
    private javax.swing.JTextField jtfcomplemento;
    private javax.swing.JTextField jtfemail;
    private javax.swing.JTextField jtflogradouro;
    private javax.swing.JTextField jtfnome;
    private javax.swing.JTextField jtfnumero;
    // End of variables declaration//GEN-END:variables
}
