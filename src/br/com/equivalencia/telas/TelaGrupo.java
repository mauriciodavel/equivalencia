package br.com.equivalencia.telas;

import br.com.equivalencia.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaGrupo extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void pesquisar_grupo() {
        String sql = "select id_grupo as 'Id Grupo', desc_grupo as 'Nome Grupo' from tb_grupo_equivalencia where desc_grupo like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "%" + txtPesquisaGrupo.getText() + "%");
            rs = pst.executeQuery();
            tblGrupo.setVisible(true);
            tblGrupo.setModel(DbUtils.resultSetToTableModel(rs));
            tblGrupo.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar_campos_grupo() {
        int setar = tblGrupo.getSelectedRow();
        txtIdGrupo.setText(tblGrupo.getModel().getValueAt(setar, 0).toString());
        txtNomeGrupo.setText(tblGrupo.getModel().getValueAt(setar, 1).toString());
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnCadastrar.setEnabled(false);
    }

    private void adicionar() {

        String sql = "insert into tb_grupo_equivalencia(desc_grupo, ch_minima, ch_maxima) values(?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeGrupo.getText());
            pst.setString(2, txtChMin.getText());
            pst.setString(3, txtChMax.getText());

            // validação dos campos obrigatórios
            if ((txtNomeGrupo.getText().isEmpty()) || (txtChMin.getText().isEmpty()) || (txtNomeGrupo.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Campo de preenchimento obrigatório está em branco!");

            } else {

                // a linha abaixo atualiza a tabela de usuário com os dados do formulário
                // a linha abaixo é usada para confirmar a inserção dos dados na tabela
                int adicionado = pst.executeUpdate();
                // a linha abaixo serve de apoio ao entendimento da lógica

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Grupo de Equivalência cadastrado com sucesso!");
                    // as linhas abaixo limpam os campos para que o usuario possa cadastrar um novo
                    txtIdGrupo.setText(null);
                    txtNomeGrupo.setText(null);
                    txtChMin.setText(null);
                    txtChMax.setText(null);
                    btnEditar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update tb_grupo_equivalencia set desc_grupo=?, ch_minima=?, ch_maxima=? where id_grupo=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeGrupo.getText());
            pst.setString(2, txtChMin.getText());
            pst.setString(3, txtChMax.getText());
            pst.setString(4, txtIdGrupo.getText());

            // validação dos campos obrigatórios
            if ((txtIdGrupo.getText().isEmpty()) || (txtNomeGrupo.getText().isEmpty()) || (txtChMin.getText().isEmpty()) || (txtChMax.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Campo de preenchimento obrigatório está em branco!");

            } else {

                int adicionado = pst.executeUpdate();
                // a linha abaixo serve de apoio ao entendimento da lógica
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Informações de Grupo de Equivalência alteradas com sucesso!");
                    // as linhas abaixo limpam os campos para que o usuario possa cadastrar um novo
                    txtIdGrupo.setText(null);
                    txtNomeGrupo.setText(null);
                    txtChMin.setText(null);
                    txtChMax.setText(null);
                    btnCadastrar.setEnabled(true);
                    btnEditar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método responsável pela remoção de usuários
    private void remover() {
        // a estrutura abaixo confirma a remoção do usuário
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja remover este Grupo de Equivalência?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_grupo_equivalencia where id_grupo=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtIdGrupo.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Grupo de Equivalência removido com sucesso!");
                    txtIdGrupo.setText(null);
                    txtNomeGrupo.setText(null);
                    btnCadastrar.setEnabled(true);
                    btnEditar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void fecharconexao() {
        try {
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public TelaGrupo() {
        initComponents();
        conexao = ModuloConexao.conector();
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        tblGrupo.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lblIdGrupo = new javax.swing.JLabel();
        lblNomeGrupo = new javax.swing.JLabel();
        txtIdGrupo = new javax.swing.JTextField();
        txtNomeGrupo = new javax.swing.JTextField();
        txtPesquisaGrupo = new javax.swing.JTextField();
        lblPequisaGrupo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrupo = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtChMin = new javax.swing.JTextField();
        txtChMax = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIS Equivalencia - Grupos de Equivalência");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("CADASTRO DE GRUPOS DE EQUIVALÊNCIA");

        lblIdGrupo.setText("Id Grupo:");

        lblNomeGrupo.setText("Nome Grupo:");

        txtIdGrupo.setEnabled(false);

        txtPesquisaGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaGrupoKeyReleased(evt);
            }
        });

        lblPequisaGrupo.setText("Nome Grupo:");

        tblGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Grupo", "Nome Grupo", "C.H. Mínima", "C.H. Máxima"
            }
        ));
        tblGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGrupoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGrupo);
        if (tblGrupo.getColumnModel().getColumnCount() > 0) {
            tblGrupo.getColumnModel().getColumn(0).setMinWidth(100);
            tblGrupo.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblGrupo.getColumnModel().getColumn(0).setMaxWidth(100);
            tblGrupo.getColumnModel().getColumn(1).setMinWidth(100);
            tblGrupo.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblGrupo.getColumnModel().getColumn(1).setMaxWidth(100);
            tblGrupo.getColumnModel().getColumn(2).setMinWidth(100);
            tblGrupo.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblGrupo.getColumnModel().getColumn(2).setMaxWidth(100);
            tblGrupo.getColumnModel().getColumn(3).setMinWidth(100);
            tblGrupo.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblGrupo.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/delete.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/update.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/create.png"))); // NOI18N
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("C.H. Mínima:");

        jLabel2.setText("C.H. Máxima:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addGap(253, 253, 253))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblNomeGrupo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdGrupo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lblPequisaGrupo))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtChMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChMax, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPesquisaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdGrupo)
                            .addComponent(txtIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeGrupo)
                            .addComponent(txtNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtChMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(txtChMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPequisaGrupo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtPesquisaGrupoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaGrupoKeyReleased
        // TODO add your handling code here:
        pesquisar_grupo();
    }//GEN-LAST:event_txtPesquisaGrupoKeyReleased

    private void tblGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGrupoMouseClicked
        // TODO add your handling code here:
        setar_campos_grupo();
    }//GEN-LAST:event_tblGrupoMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        fecharconexao();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(TelaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdGrupo;
    private javax.swing.JLabel lblNomeGrupo;
    private javax.swing.JLabel lblPequisaGrupo;
    private javax.swing.JTable tblGrupo;
    private javax.swing.JTextField txtChMax;
    private javax.swing.JTextField txtChMin;
    private javax.swing.JTextField txtIdGrupo;
    private javax.swing.JTextField txtNomeGrupo;
    private javax.swing.JTextField txtPesquisaGrupo;
    // End of variables declaration//GEN-END:variables
}
