/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Hibernate.HibernateUtil;
import Modulos.Protocolo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Wesley
 */
public class EditarProtocolo extends javax.swing.JFrame {

    Sessao sessao;
    TelaInicial telaInicial;
    int id;
    
    /**
     * Creates new form CadastroProtoloco
     */
    public EditarProtocolo(Sessao sessao) {
        this.sessao = sessao;
        initComponents();
        if (jr_fisica.isSelected()) {
            txt_nome_empresa.setEnabled(false);
            txt_cnpj.setEnabled(false);
        }
        
    }
    
    public void recebendoDados(String id,String nome,String cpf_cnpj,String data,String livro,String registro,String folha,String anotacao){
        this.id = Integer.parseInt(id);
        if(cpf_cnpj.length()==14){
            txt_nome_representante.setText(nome);
            txt_cpf.setText(cpf_cnpj);
            jr_fisica.setSelected(true);
            txt_nome_empresa.setEnabled(false);
            txt_cnpj.setEnabled(false);
            txt_nome_empresa.setText("");
            txt_cnpj.setText("");
            txt_nome_representante.setEnabled(true);
            txt_cpf.setEnabled(true);
        } else {
            txt_nome_empresa.setText(nome);
            txt_cnpj.setText(cpf_cnpj);
            jr_juridica.setSelected(true);
            txt_nome_representante.setEnabled(false);
            txt_cpf.setEnabled(false);
            txt_nome_representante.setText("");
            txt_cpf.setText("");
            txt_nome_empresa.setEnabled(true);
            txt_cnpj.setEnabled(true);
        }        
        txt_registro.setText(registro);
        txt_data.setText(data);
        txt_livro.setText(livro);
        txt_folha.setText(folha);
        txt_anotacao.setText(anotacao);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jr_fisica = new javax.swing.JRadioButton();
        jr_juridica = new javax.swing.JRadioButton();
        jl_nome_representante1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_anotacao = new javax.swing.JTextArea();
        jb_atualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_nome_empresa = new javax.swing.JTextField();
        txt_registro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_nome_representante = new javax.swing.JTextField();
        jl_nome_representante = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JFormattedTextField();
        txt_cnpj = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_livro = new javax.swing.JTextField();
        txt_folha = new javax.swing.JTextField();
        txt_data = new javax.swing.JFormattedTextField();
        jb_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(jr_fisica);
        jr_fisica.setSelected(true);
        jr_fisica.setText("Pessoa Física");
        jr_fisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_fisicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jr_juridica);
        jr_juridica.setText("Pessoa Jurídica");
        jr_juridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_juridicaActionPerformed(evt);
            }
        });

        jl_nome_representante1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_nome_representante1.setText("Data do registro");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Anotação");

        txt_anotacao.setColumns(20);
        txt_anotacao.setRows(5);
        jScrollPane2.setViewportView(txt_anotacao);

        jb_atualizar.setText("Atualizar");
        jb_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_atualizarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nome da empresa");

        txt_nome_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_empresaActionPerformed(evt);
            }
        });
        txt_nome_empresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nome_empresaKeyTyped(evt);
            }
        });

        txt_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_registroActionPerformed(evt);
            }
        });
        txt_registro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_registroKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Registro");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Folha");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("CADASTRO DE PROTOCOLO");

        txt_nome_representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_representanteActionPerformed(evt);
            }
        });
        txt_nome_representante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nome_representanteKeyTyped(evt);
            }
        });

        jl_nome_representante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_nome_representante.setText("Nome do apresentante");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CPF");

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfActionPerformed(evt);
            }
        });

        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cnpjActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CNPJ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Livro");

        txt_livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_livroActionPerformed(evt);
            }
        });
        txt_livro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_livroKeyTyped(evt);
            }
        });

        txt_folha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_folhaActionPerformed(evt);
            }
        });
        txt_folha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_folhaKeyTyped(evt);
            }
        });

        try {
            txt_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_data.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataFocusLost(evt);
            }
        });

        jb_voltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jb_voltar.setText("Voltar");
        jb_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jr_fisica)
                                .addGap(18, 18, 18)
                                .addComponent(jr_juridica)))
                        .addGap(0, 866, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jl_nome_representante)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_nome_empresa, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_nome_representante))
                                        .addGap(36, 36, 36)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_cnpj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                        .addComponent(txt_cpf, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jb_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_nome_representante1)
                                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_livro, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_folha, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jr_fisica)
                    .addComponent(jr_juridica))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_nome_representante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nome_representante, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jl_nome_representante1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_folha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_data)
                            .addComponent(txt_livro, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jb_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jr_fisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_fisicaActionPerformed
        // TODO add your handling code here:
        if (jr_fisica.isSelected()) {
            txt_nome_empresa.setEnabled(false);
            txt_cnpj.setEnabled(false);
            txt_nome_empresa.setText("");
            txt_cnpj.setText("");
            txt_nome_representante.setEnabled(true);
            txt_cpf.setEnabled(true);
        }

    }//GEN-LAST:event_jr_fisicaActionPerformed

    private void jb_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_atualizarActionPerformed
       
        if (!txt_data.equals("  /  /    ")) {
            try {
                SessionFactory sf = HibernateUtil.getSessionFactory();
                Session s = sf.openSession();
                Transaction t = s.beginTransaction();

                Protocolo p = new Protocolo();
                p.setId(this.id);
                p.setAnotacao(txt_anotacao.getText());
                if(!txt_cnpj.getText().equals("  .   .   /    -  ")){ 
                    p.setCnpj_empresa(txt_cnpj.getText());
                }else{
                    p.setCnpj_empresa("");
                }
                
                if(!txt_cpf.getText().equals("   .   .   -  ")){
                    p.setCpf_representante(txt_cpf.getText());
                }else{
                    p.setCpf_representante("");
                }
                if(!txt_data.getText().equals("  /  /    ")){
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = (Date) formatter.parse(txt_data.getText());
                p.setData(date);
                }else{
                    p.setData(null);
                }
                p.setEmpresa(sessao.currentEmpresa());
                p.setFolha(txt_folha.getText());
                p.setLivro(txt_livro.getText());
                p.setNome_empresa(txt_nome_empresa.getText());
                p.setNome_representante(txt_nome_representante.getText());
                p.setRegistro(txt_registro.getText());
                boolean erro;
                if (jr_juridica.isSelected()) {
                    erro = p.valido(p, 'J');
                }else{
                    erro = p.valido(p, 'F');
                }
                if(!erro){
                s.clear();
                s.update(p);                
                t.commit();
                s.close();
                
                telaInicial = new TelaInicial(sessao);
                if(!txt_nome_representante.getText().equals("")){
                    telaInicial.recebendoDadosTabela(p.getIdString(),p.getNome_representante(),p.getCpf_representante(),p.getDataString(),p.getLivro(),p.getRegistro(),p.getFolha(),p.getAnotacao());
                }else{
                    telaInicial.recebendoDadosTabela(p.getIdString(),p.getNome_empresa(),p.getCnpj_empresa(),p.getDataString(),p.getLivro(),p.getRegistro(),p.getFolha(),p.getAnotacao());    
                }
                
                JOptionPane.showMessageDialog(null,"Atualização realizada com sucesso!");
                
                
                }else{
                    JOptionPane.showMessageDialog(null,"Complete os campos corretamente!");
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(EditarProtocolo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jb_atualizarActionPerformed

    private void txt_nome_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_empresaActionPerformed

    private void txt_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_registroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_registroActionPerformed

    private void txt_nome_representanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_representanteActionPerformed

    private void txt_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfActionPerformed

    private void txt_cnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpjActionPerformed

    private void txt_livroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_livroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_livroActionPerformed

    private void txt_folhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_folhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_folhaActionPerformed

    private void jr_juridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_juridicaActionPerformed
        // TODO add your handling code here:
        if (jr_juridica.isSelected()) {
            txt_nome_representante.setEnabled(false);
            txt_cpf.setEnabled(false);
            txt_nome_representante.setText("");
            txt_cpf.setText("");
            txt_nome_empresa.setEnabled(true);
            txt_cnpj.setEnabled(true);
        }
    }//GEN-LAST:event_jr_juridicaActionPerformed

    private void txt_nome_representanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nome_representanteKeyTyped
        int max = 250;
        if(txt_nome_representante.getText().length() >= max){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Só pode ser digitado no maximo "+max+" caracteres.");
        }
    }//GEN-LAST:event_txt_nome_representanteKeyTyped

    private void txt_nome_empresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nome_empresaKeyTyped
       int max = 250;
        if(txt_nome_empresa.getText().length() >= max){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Só pode ser digitado no maximo "+max+" caracteres.");
        }
    }//GEN-LAST:event_txt_nome_empresaKeyTyped

    private void txt_registroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_registroKeyTyped
        int max = 250;
        if(txt_registro.getText().length() >= max){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Só pode ser digitado no maximo "+max+" caracteres.");
        }
    }//GEN-LAST:event_txt_registroKeyTyped

    private void txt_livroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_livroKeyTyped
       int max = 20;
        if(txt_livro.getText().length() >= max){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Só pode ser digitado no maximo "+max+" caracteres.");
        }
    }//GEN-LAST:event_txt_livroKeyTyped

    private void txt_folhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_folhaKeyTyped
       int max = 50;
        if(txt_folha.getText().length() >= max){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Só pode ser digitado no maximo "+max+" caracteres.");
        }
    }//GEN-LAST:event_txt_folhaKeyTyped

    private void jb_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_voltarActionPerformed
        this.setVisible(false);
        new TelaInicial(sessao).setVisible(true);
        telaInicial = new TelaInicial(sessao);
        if(!txt_nome_representante.getText().equals("")){
            telaInicial.recebendoDadosTabela(""+this.id,txt_nome_representante.getText(),txt_cpf.getText(),txt_data.getText(),txt_livro.getText(),txt_registro.getText(),txt_folha.getText(),txt_anotacao.getText());
        }else{
            telaInicial.recebendoDadosTabela(""+this.id,txt_nome_representante.getText(),txt_cpf.getText(),txt_data.getText(),txt_livro.getText(),txt_registro.getText(),txt_folha.getText(),txt_anotacao.getText());    
        }
    }//GEN-LAST:event_jb_voltarActionPerformed

    private void txt_dataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataFocusLost
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        String dataString = txt_data.getText();

        try {
          Date data = sdf.parse(dataString);
          
        } catch(ParseException e) {
          JOptionPane.showMessageDialog(null, "Data inválida!");
          txt_data.setText("");
        }
    }//GEN-LAST:event_txt_dataFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProtocolo(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_atualizar;
    private javax.swing.JButton jb_voltar;
    private javax.swing.JLabel jl_nome_representante;
    private javax.swing.JLabel jl_nome_representante1;
    private javax.swing.JRadioButton jr_fisica;
    private javax.swing.JRadioButton jr_juridica;
    private javax.swing.JTextArea txt_anotacao;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JFormattedTextField txt_data;
    private javax.swing.JTextField txt_folha;
    private javax.swing.JTextField txt_livro;
    private javax.swing.JTextField txt_nome_empresa;
    private javax.swing.JTextField txt_nome_representante;
    private javax.swing.JTextField txt_registro;
    // End of variables declaration//GEN-END:variables
}