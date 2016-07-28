/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Apresentacao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import siscontrolemedico.jeanne.br.eu.Entidade.Usuario;
import siscontrolemedico.jeanne.edu.br.Excessao.CampoObrigatorioException;
import siscontrolemedico.jeanne.edu.br.Negocio.UsuarioBO;
import siscontrolemedico.jeanne.edu.br.Excessao.SiscontroleMedicoException;
/**
 *
 * @author Aluno
 */
public class TelaAdministrador extends javax.swing.JFrame {
    private Usuario usuarios;
    public TelaAdministrador() {
        initComponents();
        usuarios = new Usuario();
        OpDesabilitado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRg = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblSexo = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblTipoUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblIcrm = new javax.swing.JLabel();
        txtICRM = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        cbxFeminino = new javax.swing.JRadioButton();
        cbxMasculino = new javax.swing.JRadioButton();
        cbxMedico = new javax.swing.JRadioButton();
        cbxRecepcionista = new javax.swing.JRadioButton();
        cbxAdministrador = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestão de Usuários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblNome.setText("Nome: ");

        jLabel1.setText("CPF: ");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.### -##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("RG:");

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Tel.: ");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblSexo.setText("Sexo: ");

        lblEndereco.setText("Endereço: ");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        lblTipoUsuario.setText("Tipo de Usuário: ");

        jButton1.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1467932231_Login_out.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1468014950_Search.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1468014703_Edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1467932526_Close.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1467932300_Save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblIcrm.setText("ICRM :");

        lblLogin.setText("Login: ");

        lblSenha.setText("Senha: ");

        cbxFeminino.setText("Feminino");
        cbxFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFemininoActionPerformed(evt);
            }
        });

        cbxMasculino.setText("Masculino");
        cbxMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMasculinoActionPerformed(evt);
            }
        });

        cbxMedico.setText("Médico");
        cbxMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedicoActionPerformed(evt);
            }
        });

        cbxRecepcionista.setText("Recepcionista");
        cbxRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRecepcionistaActionPerformed(evt);
            }
        });

        cbxAdministrador.setText("Administrador");
        cbxAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAdministradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRg))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipoUsuario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxFeminino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxMasculino))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxRecepcionista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxAdministrador)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIcrm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(txtICRM))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(cbxFeminino)
                    .addComponent(cbxMasculino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLogin)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSenha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMedico)
                    .addComponent(cbxRecepcionista)
                    .addComponent(cbxAdministrador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIcrm)
                    .addComponent(txtICRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(616, 337));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
          try {
            this.salvar();
            this.limparCamposTela();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.BuscarUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFemininoActionPerformed
        if(cbxFeminino.isSelected())
        {
            cbxMasculino.setSelected(false);
        }
    }//GEN-LAST:event_cbxFemininoActionPerformed

    private void cbxMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMasculinoActionPerformed
        if(cbxMasculino.isSelected())
        {
            cbxFeminino.setSelected(false);
        }
    }//GEN-LAST:event_cbxMasculinoActionPerformed

    private void cbxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedicoActionPerformed
        if(cbxMedico.isSelected())
        {
            AtivarICRM();
            desabilitarOpMedicoSelecionado();
            
        }
    }//GEN-LAST:event_cbxMedicoActionPerformed

    private void cbxRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRecepcionistaActionPerformed
       if(cbxRecepcionista.isSelected())
       {
           desabilitarOpRecepSelecionado();
       }
    }//GEN-LAST:event_cbxRecepcionistaActionPerformed

    private void cbxAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAdministradorActionPerformed
        if(cbxAdministrador.isSelected())
        {
            desabilitarOpAdmSelecionado();
        }
    }//GEN-LAST:event_cbxAdministradorActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            this.excluir();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            this.alterar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JRadioButton cbxAdministrador;
    private javax.swing.JRadioButton cbxFeminino;
    private javax.swing.JRadioButton cbxMasculino;
    private javax.swing.JRadioButton cbxMedico;
    private javax.swing.JRadioButton cbxRecepcionista;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblIcrm;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtICRM;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void salvar() throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException 
    {
        
        this.recuperarCamposTela();
          try
        {   
        UsuarioBO usuariosBO = new UsuarioBO();
        usuariosBO.inserir(usuarios);
        
        JOptionPane.showMessageDialog(null,"usuario Cadastrado Com sucesso!");
         }catch(SiscontroleMedicoException e)
        {
            String mensagem = "Cadastro não efetuado :\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de usuário", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void recuperarCamposTela() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (!txtNome.getText().trim().equals("")) {
            usuarios.setNome(txtNome.getText().trim());
        }else
        {
            throw new CampoObrigatorioException();
        }
        
        if (!txtCpf.getText().trim().equals("")) {
           usuarios.setCpf(txtCpf.getText().trim());
       }else
        {
            throw new CampoObrigatorioException();
        } 
        
        if (!txtRg.getText().trim().equals("")) {
            usuarios.setRg(txtRg.getText().trim());
        }else
        {
            throw new CampoObrigatorioException();
        }
        
        if (!txtTelefone.getText().trim().equals("")) {
            usuarios.setTelefone(txtTelefone.getText().trim());
        }else
        {
            throw new CampoObrigatorioException();
        }
        
        if (!txtEndereco.getText().trim().equals("")) {
            usuarios.setEndereco(txtEndereco.getText().trim());
        }else
        {
            throw new CampoObrigatorioException();
        }
        
        if (cbxFeminino.isSelected())
        {
            usuarios.setSexo("F");
        }else if(cbxMasculino.isSelected())
        {
            usuarios.setSexo("M");
        }else
        {
            throw new CampoObrigatorioException();
        }
        
        if (!txtLogin.getText().trim().equals("")) {
            usuarios.setLogin(txtLogin.getText().trim());
        }else
        {
            throw new CampoObrigatorioException();
        }
        
        if (!txtSenha.getText().trim().equals("")) {
            
             char[] chars = txtSenha.getPassword();  
             String senha = String.valueOf(chars);
             UsuarioBO usuarioBO = new UsuarioBO();
             String senhaCriptografada;
             senhaCriptografada = usuarioBO.criptografarSenha(senha);
             usuarios.setSenha(senhaCriptografada);
        }else
        {
            throw new CampoObrigatorioException();
        }
        
        
        if (cbxAdministrador.isSelected()) {
           usuarios.setCargo("Administrador");
           txtICRM.setEnabled(false);
        } else if (cbxMedico.isSelected()) {
            usuarios.setCargo("Médico");
            txtICRM.setEnabled(true);
        }else if(cbxRecepcionista.isSelected()){
            usuarios.setCargo("Recepcionista");
            txtICRM.setEnabled(false);
        }else
        {
            throw new CampoObrigatorioException();
        }
        
         if (!txtICRM.getText().trim().equals("")) {
            usuarios.setIcrm(txtICRM.getText().trim());
        }
    }

    private void OpDesabilitado() {
        lblIcrm.setEnabled(false);
        txtICRM.setEnabled(false);
    }

    private void AtivarICRM() {
        lblIcrm.setEnabled(true);
        txtICRM.setEnabled(true);
    }   

    private void desabilitarOpMedicoSelecionado() {
        cbxAdministrador.setSelected(false);
        cbxRecepcionista.setSelected(false);
    }

    private void desabilitarOpRecepSelecionado() {
        cbxMedico.setSelected(false);
        cbxAdministrador.setSelected(false);
        OpDesabilitado();
    }

    private void desabilitarOpAdmSelecionado() {
        cbxMedico.setSelected(false);
        cbxRecepcionista.setSelected(false);
        OpDesabilitado();
    }

    

    private void LimparCamposTela() {
      txtCpf.setText(null);
      txtEndereco.setText(null);
      txtICRM.setText(null);
      txtLogin.setText(null);
      txtNome.setText(null);
      txtRg.setText(null);
      txtSenha.setText(null);
      txtTelefone.setText(null);
      cbxAdministrador.setSelected(false);
      cbxFeminino.setSelected(false);
      cbxMasculino.setSelected(false);
      cbxMedico.setSelected(false);
      cbxRecepcionista.setSelected(false);
    }

    private void BuscarUsuario() throws SQLException {
          try {
            Usuario usuarioPesquisado = new Usuario();
            String nome = txtNome.getText().trim();
            usuarioPesquisado.setNome(nome);
            this.validarPesquisa();
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarios = usuarioBO.pesquisar(usuarioPesquisado);
            this.recuperarCamposBusca();
        } catch (SiscontroleMedicoException e) {
            String mensagem = "Pesquisa não realizada:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de usuário", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de usuário", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validarPesquisa() {
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "preencha o campo nome para efetuar a pesquisa");
        }
    }

    private void recuperarCamposBusca() {
      this.txtNome.setText(this.usuarios.getNome());
      this.txtCpf.setText(this.usuarios.getCpf());
      this.txtRg.setText(this.usuarios.getRg());
      this.txtTelefone.setText(this.usuarios.getTelefone());
      
        if(usuarios.getSexo().equals("M")){
            cbxMasculino.setSelected(true);
            cbxFeminino.setSelected(false);
        }else{
            cbxFeminino.setSelected(true);
             cbxMasculino.setSelected(false);
        }
      
      this.txtEndereco.setText(this.usuarios.getEndereco());
       this.txtSenha.setText(this.usuarios.getSenha());
       this.txtLogin.setText(this.usuarios.getLogin());
       
        if(usuarios.getCargo().equals("Administrador"))
        {
            cbxAdministrador.setSelected(true);
            cbxRecepcionista.setSelected(false);
            cbxMedico.setSelected(false);
            txtICRM.setEnabled(false);
            txtICRM.setText("");
        }else if(usuarios.getCargo().equals("Médico"))
        {
            cbxMedico.setSelected(true);
            cbxAdministrador.setSelected(false);
            cbxRecepcionista.setSelected(false);
            txtICRM.setEnabled(true);
            this.txtICRM.setText(this.usuarios.getIcrm());
        }else
        {
            cbxRecepcionista.setSelected(true);
            cbxMedico.setSelected(false);
            cbxAdministrador.setSelected(false);
            txtICRM.setEnabled(false);
            txtICRM.setText("");
        }     
    }

    private void excluir() throws SQLException {
        int resposta;
                String mensagem = "Realmente deseja excluir esse usuário? ";
                String titulo = "Exclusão de Usuário";
                resposta = JOptionPane.showConfirmDialog(this,
                        mensagem, titulo, JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    UsuarioBO usuarioBO = new UsuarioBO();
                    usuarioBO.excluir(usuarios.getNome());
                    String mensagemSuceso = "Usuário excluído com sucesso!!";
                    JOptionPane.showMessageDialog(this,
                            mensagemSuceso, titulo,
                            JOptionPane.INFORMATION_MESSAGE);
                    this.limparCamposTela();
                            
                }        
    }

    private void limparCamposTela() {
        txtNome.setText(null);
        txtRg.setText(null);
        txtCpf.setText(null);
        txtEndereco.setText(null);
        txtICRM.setText(null);
        txtLogin.setText(null);
        txtSenha.setText(null);
        txtTelefone.setText(null);
        cbxFeminino.setSelected(false);
        cbxMasculino.setSelected(false);
        cbxAdministrador.setSelected(false);
        cbxMedico.setSelected(false);
        cbxRecepcionista.setSelected(false);
        
    }

    private void alterar() throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
         int resposta;
                String mensagem = "Realmente deseja Alterar esse usuário? ";
                String titulo = "Alteração de Usuário";
                resposta = JOptionPane.showConfirmDialog(this,
                        mensagem, titulo, JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    this.recuperarCamposTela();
                    UsuarioBO usuarioBO = new UsuarioBO();
                    usuarioBO.alterar(usuarios);
                    String mensagemSuceso = "Usuário Alerado com sucesso!!";
                    JOptionPane.showMessageDialog(this,
                            mensagemSuceso, titulo,
                            JOptionPane.INFORMATION_MESSAGE);
                    this.limparCamposTela();
                            
                }   
        
    }

}
                            
                

    

