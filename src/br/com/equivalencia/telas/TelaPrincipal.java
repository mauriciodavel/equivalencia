package br.com.equivalencia.telas;

import br.com.equivalencia.dal.ModuloConexao;
import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class TelaPrincipal extends javax.swing.JFrame {   

    Connection conexao = null;
    
    private void carregarRelatorio(String caminho, Map parametros) throws SQLException{
        try {
            JasperReport relatorio = JasperCompileManager.compileReport(caminho);
            JasperPrint relatorio_preenchido = JasperFillManager.fillReport(relatorio, parametros, conexao);
            JasperViewer.viewReport(relatorio_preenchido);
            conexao.close();
        } catch (JRException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar relatório!");
        } catch (SQLException ex){
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar relatório!");
        }
    }
    

    public TelaPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        conexao = ModuloConexao.conector();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        btnArea = new javax.swing.JButton();
        btnCurso = new javax.swing.JButton();
        btnGrupoEquiv = new javax.swing.JButton();
        btnUnidades = new javax.swing.JButton();
        btnPpc = new javax.swing.JButton();
        btnEquivalencia = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        manCadArea = new javax.swing.JMenuItem();
        menCadCursos = new javax.swing.JMenuItem();
        menCadPpc = new javax.swing.JMenuItem();
        menCadGrupo = new javax.swing.JMenuItem();
        menCadUc = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menEquivalencia = new javax.swing.JMenu();
        menRealizarEquivalencia = new javax.swing.JMenuItem();
        menRel = new javax.swing.JMenu();
        menRelArea = new javax.swing.JMenuItem();
        menOpc = new javax.swing.JMenu();
        menOpcLogout = new javax.swing.JMenuItem();
        menOpcSair = new javax.swing.JMenuItem();
        menAjuda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIS Equivalência - SENAI Vitória - Tela Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/area_tec.png"))); // NOI18N
        btnArea.setEnabled(false);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/cursos.png"))); // NOI18N
        btnCurso.setEnabled(false);

        btnGrupoEquiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/grupos_equivalência.png"))); // NOI18N
        btnGrupoEquiv.setEnabled(false);

        btnUnidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/ucs.png"))); // NOI18N
        btnUnidades.setEnabled(false);

        btnPpc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/ppc.png"))); // NOI18N
        btnPpc.setEnabled(false);

        btnEquivalencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/icones/equivalênica.png"))); // NOI18N

        jDesktopPane1.setLayer(btnArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnGrupoEquiv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnUnidades, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnPpc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnEquivalencia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(btnArea, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPpc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGrupoEquiv, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArea, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrupoEquiv, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPpc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149))
        );

        menCad.setText("Cadastro");
        menCad.setEnabled(false);

        manCadArea.setText("Área Tecnológica");
        manCadArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manCadAreaActionPerformed(evt);
            }
        });
        menCad.add(manCadArea);

        menCadCursos.setText("Cursos");
        menCadCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadCursosActionPerformed(evt);
            }
        });
        menCad.add(menCadCursos);

        menCadPpc.setText("PPC");
        menCadPpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadPpcActionPerformed(evt);
            }
        });
        menCad.add(menCadPpc);

        menCadGrupo.setText("Grupo de Equivalência");
        menCadGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadGrupoActionPerformed(evt);
            }
        });
        menCad.add(menCadGrupo);

        menCadUc.setText("Unidades Curriculares");
        menCadUc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadUcActionPerformed(evt);
            }
        });
        menCad.add(menCadUc);

        jMenuItem3.setText("Usuários");
        menCad.add(jMenuItem3);

        jMenuBar1.add(menCad);

        menEquivalencia.setText("Equivalência");

        menRealizarEquivalencia.setText("Realizar Equivalência");
        menRealizarEquivalencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRealizarEquivalenciaActionPerformed(evt);
            }
        });
        menEquivalencia.add(menRealizarEquivalencia);

        jMenuBar1.add(menEquivalencia);

        menRel.setText("Relatórios");

        menRelArea.setText("Área Técnológica");
        menRelArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelAreaActionPerformed(evt);
            }
        });
        menRel.add(menRelArea);

        jMenuBar1.add(menRel);

        menOpc.setText("Opções");

        menOpcLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menOpcLogout.setText("Logout");
        menOpcLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcLogoutActionPerformed(evt);
            }
        });
        menOpc.add(menOpcLogout);

        menOpcSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menOpcSair.setText("Sair");
        menOpcSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcSairActionPerformed(evt);
            }
        });
        menOpc.add(menOpcSair);

        jMenuBar1.add(menOpc);

        menAjuda.setText("Ajuda");

        jMenuItem1.setText("Fluxo de Processo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menAjuda.add(jMenuItem1);

        jMenuItem2.setText("Manual");
        menAjuda.add(jMenuItem2);

        jMenuBar1.add(menAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(575, Short.MAX_VALUE))
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Date data=new Date();
        DateFormat formatador=DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void manCadAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manCadAreaActionPerformed
        // TODO add your handling code here:
        TelaArea area = new TelaArea();
        area.setVisible(true);
    }//GEN-LAST:event_manCadAreaActionPerformed

    private void menCadCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadCursosActionPerformed
        // TODO add your handling code here:
        TelaCursos cursos = new TelaCursos();
        cursos.setVisible(true);
    }//GEN-LAST:event_menCadCursosActionPerformed

    private void menCadPpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadPpcActionPerformed
        // TODO add your handling code here:
        TelaPpc ppc = new TelaPpc();
        ppc.setVisible(true);
    }//GEN-LAST:event_menCadPpcActionPerformed

    private void menCadGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadGrupoActionPerformed
        // TODO add your handling code here:
        TelaGrupo grupo = new TelaGrupo();
        grupo.setVisible(true);
    }//GEN-LAST:event_menCadGrupoActionPerformed

    private void menCadUcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadUcActionPerformed
        // TODO add your handling code here:
        TelaDisciplina disciplina = new TelaDisciplina();
        disciplina.setVisible(true);
    }//GEN-LAST:event_menCadUcActionPerformed

    private void menOpcLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcLogoutActionPerformed
        // TODO add your handling code here:
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menOpcLogoutActionPerformed

    private void menOpcSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menOpcSairActionPerformed

    private void menRealizarEquivalenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRealizarEquivalenciaActionPerformed
        // TODO add your handling code here:
        TelaEquivalencia equivalencia = new TelaEquivalencia();
        equivalencia.setVisible(true);
    }//GEN-LAST:event_menRealizarEquivalenciaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TelaFluxograma fluxo = new TelaFluxograma();
        fluxo.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menRelAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelAreaActionPerformed
        try {
            // gerando relatório de clientes
            carregarRelatorio("C:/Users/mdavel/JaspersoftWorkspace/Equivalencia/Blank_A4.jasper", null);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_menRelAreaActionPerformed


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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnArea;
    public static javax.swing.JButton btnCurso;
    private javax.swing.JButton btnEquivalencia;
    public static javax.swing.JButton btnGrupoEquiv;
    public static javax.swing.JButton btnPpc;
    public static javax.swing.JButton btnUnidades;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem manCadArea;
    private javax.swing.JMenu menAjuda;
    public static javax.swing.JMenu menCad;
    private javax.swing.JMenuItem menCadCursos;
    private javax.swing.JMenuItem menCadGrupo;
    private javax.swing.JMenuItem menCadPpc;
    private javax.swing.JMenuItem menCadUc;
    private javax.swing.JMenu menEquivalencia;
    private javax.swing.JMenu menOpc;
    private javax.swing.JMenuItem menOpcLogout;
    private javax.swing.JMenuItem menOpcSair;
    private javax.swing.JMenuItem menRealizarEquivalencia;
    private javax.swing.JMenu menRel;
    private javax.swing.JMenuItem menRelArea;
    // End of variables declaration//GEN-END:variables
}
