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
import siscontrolemedico.jeanne.br.eu.Entidade.Usuario;
import siscontrolemedico.jeanne.edu.br.Negocio.ConsultaBO;
import siscontrolemedico.jeanne.edu.br.Negocio.ConverterData;

/**
 *
 * @author Jeanne
 */
public class ConsultasAgendadas extends javax.swing.JFrame {
     private List<Consulta> listaConsulta;
    /**
     * Creates new form ConsultasAgendadas
     */
    public ConsultasAgendadas() throws SQLException {
        initComponents();
        this.carregarTabela();
    }
    
    
  private void carregarTabela() throws SQLException {
        ConsultaBO consultaBO = new ConsultaBO();
        this.listaConsulta = consultaBO.buscarTodos();
        ModeloTabela model = new ModeloTabela();
        this.tblConsultas.setModel(model);
    }
   public String getColumnName(int coluna) {
            if (coluna == 0) {
                return "Médico";
            } else if (coluna == 1) {
                return "Paciente";
            } else if (coluna == 2) {
                return "Hora";
            }else if (coluna == 3) {
                return "Data";
            }
            return null;
        }
    
    
    private void excluir() throws SQLException {
        
       int linhaSelecionada = this.tblConsultas.getSelectedRow();
            
        try { 
            Consulta consultaSelecionado = listaConsulta.get(linhaSelecionada);
            ConsultaBO consultaBO = new ConsultaBO();
            
            String mensagem = "Realmente deseja excluir a Consulta Marcada ?";
                   
            int opcao = JOptionPane.showConfirmDialog(this,
                            mensagem,
                            "Excluir funcionário",
                            JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                consultaBO.excluirConsulta(consultaSelecionado.getId());
                this.carregarTabelaFuncionario();
                
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "É necessário selecionar uma linha da tabela para possibilitar a exclusão da consulta.",
                    "Exclusão de funcionário",
                    JOptionPane.INFORMATION_MESSAGE);
        }  

    
    }

    private void carregarTabelaFuncionario() throws SQLException {
        ConsultaBO consultaBO = new ConsultaBO();
        this.listaConsulta = consultaBO.buscarTodos();
        ModeloTabela modeloTabela = new ModeloTabela() {
        };
        tblConsultas.setModel(modeloTabela);
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
                 return consulta.getUsuario().getNome();
                //return ConverterData.DataParaString((Date) consulta.getData());
            } else if (coluna == 1) {
                return consulta.getPaciente().getNome();
                //return consulta.getHorario();
            } else if (coluna == 2) {
                return consulta.getHorario();
                //return consulta.getPaciente().getNome();
            }else if (coluna == 3) {
                return ConverterData.DataParaString((Date) consulta.getData());
            }
            return null;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas Marcadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vani", 1, 12))); // NOI18N

        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tblConsultas);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscontrolemedico/jeanne/edu/br/Icone/1467932325_File_delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(520, 374));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         try {
             this.excluir();
         } catch (SQLException ex) {
             Logger.getLogger(ConsultasAgendadas.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultasAgendadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasAgendadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasAgendadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasAgendadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsultasAgendadas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultasAgendadas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables
}
