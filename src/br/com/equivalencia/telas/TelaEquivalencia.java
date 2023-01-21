package br.com.equivalencia.telas;

import br.com.equivalencia.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaEquivalencia extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void pesquisar_area() {
        String sql = "select * from tb_area_tecnologica order by nome_area";
        txtIdArea.setText(null);
        txtIdCurso.setText(null);
        txtIdPpc.setText(null);
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            cboArea.removeAllItems();
            while (rs.next()) {
                cboArea.addItem(rs.getString(2));
                //cboArea.updateUI();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar_id_area() {

        String sql = "select id_area from tb_area_tecnologica where nome_area=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboArea.getSelectedItem().toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtIdArea.setText(rs.getString(1));
            }
            cboCurso.removeAllItems();
            pesquisar_curso();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pesquisar_curso() {
        String sql = "select * from tb_cursos where id_area=?";
        txtIdCurso.setText(null);
        txtIdPpc.setText(null);
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdArea.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                cboCurso.addItem(rs.getString(2));
                //cboCurso.updateUI();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar_id_curso() {

        String sql = "select id_curso from tb_cursos where nome_curso=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboCurso.getSelectedItem().toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtIdCurso.setText(rs.getString(1));
                pesquisar_ppc();
            } else {
                txtIdCurso.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existem cursos cadastrados para a área selecionada!");
        }
    }

    private void pesquisar_ppc() {
        String sql = "select * from tb_ppc where id_curso=? order by desc_ano";
        cboPpc.removeAllItems();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdCurso.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                cboPpc.addItem(rs.getString(2));
            }
            txtIdPpc.setText(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existem planos de curso cadastrados para o curso selecionado!");
        }
    }

    private void setar_id_ppc() {

        String sql = "select id_ppc from tb_ppc where desc_ano=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboPpc.getSelectedItem().toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtIdPpc.setText(rs.getString(1));
            } else {
                txtIdPpc.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existem cursos cadastrados para a área selecionada!");
        }
    }
    
    private void listar_disciplinas() {
        setar_id_ppc();
        String sql = "select id_disciplina as 'Id U.C.', nome_disciplina as 'Disciplina', ch_disciplina as 'C.H. da U.C.', ch_presencial as 'C.H. Presencial', ch_ead as 'C.H. EAD', id_grupo_equivalencia as 'Grupo Equivalência', id_ppc as 'PPC' from tb_disciplinas where id_ppc=?";
        tblDisciplinas.setEnabled(true);
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdPpc.getText());
            rs = pst.executeQuery();
            tblDisciplinas.setVisible(true);
            tblDisciplinas.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

        private void pesquisar_area1() {
        String sql = "select * from tb_area_tecnologica order by nome_area";
        txtIdArea1.setText(null);
        txtIdCurso1.setText(null);
        txtIdPpc1.setText(null);
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            cboArea1.removeAllItems();
            while (rs.next()) {
                cboArea1.addItem(rs.getString(2));
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar_id_area1() {

        String sql = "select id_area from tb_area_tecnologica where nome_area=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboArea1.getSelectedItem().toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtIdArea1.setText(rs.getString(1));
            }
            cboCurso1.removeAllItems();
            pesquisar_curso1();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pesquisar_curso1() {
        String sql = "select * from tb_cursos where id_area=?";
        txtIdCurso1.setText(null);
        txtIdPpc1.setText(null);
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdArea1.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                cboCurso1.addItem(rs.getString(2));
                //cboCurso.updateUI();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar_id_curso1() {

        String sql = "select id_curso from tb_cursos where nome_curso=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboCurso1.getSelectedItem().toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtIdCurso1.setText(rs.getString(1));
                pesquisar_ppc1();
            } else {
                txtIdCurso1.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existem cursos cadastrados para a área selecionada!");
        }
    }

    private void pesquisar_ppc1() {
        String sql = "select * from tb_ppc where id_curso=? order by desc_ano";
        cboPpc1.removeAllItems();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdCurso1.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                cboPpc1.addItem(rs.getString(2));
            }
            txtIdPpc1.setText(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existem planos de curso cadastrados para o curso selecionado!");
        }
    }

    private void setar_id_ppc1() {

        String sql = "select id_ppc from tb_ppc where desc_ano=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboPpc1.getSelectedItem().toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtIdPpc1.setText(rs.getString(1));
            } else {
                txtIdPpc1.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existem planos de curso cadastrados para o curso selecionado!");
        }
    }
    
    private void listar_disciplinas1() {
        setar_id_ppc1();
        String sql = "select id_disciplina as 'Id U.C.', nome_disciplina as 'Disciplina', ch_disciplina as 'C.H. da U.C.', ch_presencial as 'C.H. Presencial', ch_ead as 'C.H. EAD', id_grupo_equivalencia as 'Grupo Equivalência', id_ppc as 'PPC' from tb_disciplinas where id_ppc=?";
        tblDisciplinas1.setEnabled(true);
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdPpc1.getText());
            rs = pst.executeQuery();
            tblDisciplinas1.setVisible(true);
            tblDisciplinas1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    public TelaEquivalencia() {
        initComponents();
        conexao = ModuloConexao.conector();
        tblDisciplinas.setEnabled(false);
        tblDisciplinas1.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdArea = new javax.swing.JTextField();
        txtIdCurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdPpc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisciplinas = new javax.swing.JTable();
        txtIdPpc1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdCurso1 = new javax.swing.JTextField();
        txtIdArea1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        cboArea = new javax.swing.JComboBox<>();
        cboCurso = new javax.swing.JComboBox<>();
        cboPpc = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        cboArea1 = new javax.swing.JComboBox<>();
        cboCurso1 = new javax.swing.JComboBox<>();
        cboPpc1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDisciplinas1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Id. Área Técnológica:");

        txtIdArea.setEnabled(false);

        txtIdCurso.setEnabled(false);

        jLabel2.setText("Id. Curso Técnico:");

        txtIdPpc.setEnabled(false);

        jLabel3.setText("Id. Plano de Curso:");

        tblDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Carga Horária", "C.H. Presencial", "C.H. EAD"
            }
        ));
        jScrollPane1.setViewportView(tblDisciplinas);

        txtIdPpc1.setEnabled(false);

        jLabel4.setText("Id. Plano de Curso:");

        jLabel5.setText("Id. Curso Técnico:");

        txtIdCurso1.setEnabled(false);

        txtIdArea1.setEnabled(false);

        jLabel6.setText("Id. Área Técnológica:");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        cboArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboAreaFocusLost(evt);
            }
        });

        cboCurso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboCursoFocusLost(evt);
            }
        });

        cboPpc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboPpcFocusLost(evt);
            }
        });

        jButton1.setText("Listar PPC");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboArea1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboArea1FocusLost(evt);
            }
        });

        cboCurso1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboCurso1FocusLost(evt);
            }
        });

        cboPpc1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboPpc1FocusLost(evt);
            }
        });

        tblDisciplinas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Carga Horária", "C.H. Presencial", "C.H. EAD"
            }
        ));
        jScrollPane4.setViewportView(tblDisciplinas1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdPpc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboArea, 0, 260, Short.MAX_VALUE)
                                .addComponent(cboCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboPpc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdPpc1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboArea1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboCurso1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPpc1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(241, 241, 241))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtIdPpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtIdArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtIdCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtIdPpc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPpc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        try {
            conexao.close();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_formWindowClosed

    private void cboAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboAreaFocusLost
        // TODO add your handling code here:
        setar_id_area();
    }//GEN-LAST:event_cboAreaFocusLost

    private void cboCursoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboCursoFocusLost
        // TODO add your handling code here:
        setar_id_curso();
        pesquisar_ppc();
    }//GEN-LAST:event_cboCursoFocusLost

    private void cboAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboAreaFocusGained
        // TODO add your handling code here:
        pesquisar_area();
    }//GEN-LAST:event_cboAreaFocusGained

    private void cboPpcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboPpcFocusLost
        // TODO add your handling code here:
       setar_id_ppc();
       listar_disciplinas();
    }//GEN-LAST:event_cboPpcFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        listar_disciplinas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboArea1FocusGained
        // TODO add your handling code here:
        pesquisar_area1();
    }//GEN-LAST:event_cboArea1FocusGained

    private void cboArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboArea1FocusLost
        // TODO add your handling code here:
        pesquisar_curso1();
        setar_id_area1();
    }//GEN-LAST:event_cboArea1FocusLost

    private void cboCurso1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboCurso1FocusLost
        // TODO add your handling code here:
        pesquisar_ppc1();
        setar_id_curso1();
    }//GEN-LAST:event_cboCurso1FocusLost

    private void cboPpc1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboPpc1FocusLost
        // TODO add your handling code here:
        listar_disciplinas1();
    }//GEN-LAST:event_cboPpc1FocusLost

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
            java.util.logging.Logger.getLogger(TelaEquivalencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEquivalencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEquivalencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEquivalencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEquivalencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboArea;
    private javax.swing.JComboBox<String> cboArea1;
    private javax.swing.JComboBox<String> cboCurso;
    private javax.swing.JComboBox<String> cboCurso1;
    private javax.swing.JComboBox<String> cboPpc;
    private javax.swing.JComboBox<String> cboPpc1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable tblDisciplinas;
    private javax.swing.JTable tblDisciplinas1;
    public static javax.swing.JTextField txtIdArea;
    public static javax.swing.JTextField txtIdArea1;
    public static javax.swing.JTextField txtIdCurso;
    public static javax.swing.JTextField txtIdCurso1;
    public static javax.swing.JTextField txtIdPpc;
    public static javax.swing.JTextField txtIdPpc1;
    // End of variables declaration//GEN-END:variables
}
