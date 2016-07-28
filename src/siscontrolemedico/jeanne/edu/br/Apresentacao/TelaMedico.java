/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Apresentacao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import siscontrolemedico.jeanne.br.eu.Entidade.Consulta;
import siscontrolemedico.jeanne.br.eu.Entidade.Paciente;
import siscontrolemedico.jeanne.br.eu.Entidade.Prontuario;
import siscontrolemedico.jeanne.br.eu.Entidade.Usuario;
import siscontrolemedico.jeanne.edu.br.Excessao.CampoObrigatorioException;
import siscontrolemedico.jeanne.edu.br.Negocio.ConsultaBO;
import siscontrolemedico.jeanne.edu.br.Negocio.ConverterData;
import siscontrolemedico.jeanne.edu.br.Negocio.ProntuarioBO;

/**
 *
 * @author Aluno
 */
public class TelaMedico extends javax.swing.JFrame {

    Paciente pacientes;
    Prontuario prontuario;
    Usuario usuarios;
    Consulta consultas;

     private List<Consulta> listaConsulta;

    TelaMedico() throws SQLException {
        initComponents();  
        this.carregarTabela();
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProntuario = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuItemConsultasAgendadas = new javax.swing.JMenuItem();
        mnuItemProntuarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prontuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vani", 1, 12))); // NOI18N

        jLabel1.setText("Prontuário: ");

        txtProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProntuarioActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1467932231_Login_out.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1468014871_Paste.png"))); // NOI18N
        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Horário", "Paciente", "Título 4"
            }
        ));
        jScrollPane1.setViewportView(tblConsultas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(411, 431, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(txtProntuario, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jMenu1.setText("Consultas");

        mnuItemConsultasAgendadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1467932368_File.png"))); // NOI18N
        mnuItemConsultasAgendadas.setText("Consultas Agendadas");
        mnuItemConsultasAgendadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemConsultasAgendadasActionPerformed(evt);
            }
        });
        jMenu1.add(mnuItemConsultasAgendadas);

        mnuItemProntuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1467932458_Folder.png"))); // NOI18N
        mnuItemProntuarios.setText("Prontuarios");
        mnuItemProntuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemProntuariosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuItemProntuarios);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(656, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mnuItemConsultasAgendadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemConsultasAgendadasActionPerformed
        try {
            ConsultasAgendadas consultas = new ConsultasAgendadas();
            consultas.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuItemConsultasAgendadasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Salvar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProntuarioActionPerformed
       
    }//GEN-LAST:event_txtProntuarioActionPerformed

    private void mnuItemProntuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemProntuariosActionPerformed
        try {
            ProntuariosCadastrados prontuarios = new ProntuariosCadastrados();
            prontuarios.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuItemProntuariosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaMedico().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaMedico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnuItemConsultasAgendadas;
    private javax.swing.JMenuItem mnuItemProntuarios;
    private javax.swing.JTable tblConsultas;
    private javax.swing.JTextField txtProntuario;
    // End of variables declaration//GEN-END:variables

    private void carregarTabela() throws SQLException {
        ConsultaBO consultaBO = new ConsultaBO();
        this.listaConsulta = consultaBO.buscarTodos();
        ModeloTabela model = new ModeloTabela();
        this.tblConsultas.setModel(model);
    }

    private void Salvar() throws SQLException {
     
     try {
            //recupera linha da tabela Selecionada
            int linhaSelecionada = this.tblConsultas.getSelectedRow();
            Consulta consultaSelecionado = listaConsulta.get(linhaSelecionada);
            
            String prontuario = txtProntuario.getText().trim();
            Prontuario prontuarios = new Prontuario();
            prontuarios.setProntuario(prontuario);
            prontuarios.setConsulta(consultaSelecionado);//seta o parametro da consulta pela linha selecionada
           
            ProntuarioBO prontuarioBO = new ProntuarioBO();
            ProntuarioBO.salvar(prontuarios);
            JOptionPane.showMessageDialog(this, "Prontuario Salvo com Sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE); 
        } catch (CampoObrigatorioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }       
    }

    

    

    private String recuperarFiltro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    private void carregarTabelaPesquisaPaciente() {
        ModeloTabela model = new ModeloTabela();
        this.tblConsultas.setModel(model);
    }

    private class ModeloTabela extends AbstractTableModel {
       
        @Override
        public int getRowCount() {
            return listaConsulta.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int linha, int coluna) {
            Consulta consulta = listaConsulta.get(linha);
            if (coluna == 0) {
                return ConverterData.DataParaString((Date) consulta.getData());
            } else if (coluna == 1) {
                return consulta.getHorario();
            } else if (coluna == 2) {
                return consulta.getPaciente().getNome();
            }else if (coluna == 3) {
                return consulta.getUsuario().getNome();
            }
            return null;
        }
        public String getColumnName(int coluna) {
            if (coluna == 0) {
                return "DATA";
            } else if (coluna == 1) {
                return "HORÁRIO";
            } else if (coluna == 2) {
                return "PACIENTE";
            }else if (coluna == 3) {
                return "MÉDICO";
            }
            return null;
        }
    }
}
