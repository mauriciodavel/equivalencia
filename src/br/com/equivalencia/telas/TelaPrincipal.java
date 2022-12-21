package br.com.equivalencia.telas;

import java.text.DateFormat;
import java.util.Date;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        manCadArea = new javax.swing.JMenuItem();
        menCadCursos = new javax.swing.JMenuItem();
        menCadPpc = new javax.swing.JMenuItem();
        menCadUc = new javax.swing.JMenuItem();
        menCadGrupo = new javax.swing.JMenuItem();
        menOpc = new javax.swing.JMenu();
        menOpcLogout = new javax.swing.JMenuItem();
        menOpcSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIS Equivalência - SENAI Vitória - Tela Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menCad.setText("Cadastro");

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

        menCadUc.setText("Unidades Curriculares");
        menCadUc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadUcActionPerformed(evt);
            }
        });
        menCad.add(menCadUc);

        menCadGrupo.setText("Grupo de Equivalência");
        menCadGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadGrupoActionPerformed(evt);
            }
        });
        menCad.add(menCadGrupo);

        jMenuBar1.add(menCad);

        menOpc.setText("Opções");

        menOpcLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        menOpcLogout.setText("Logout");
        menOpcLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcLogoutActionPerformed(evt);
            }
        });
        menOpc.add(menOpcLogout);

        menOpcSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menOpcSair.setText("Sair");
        menOpcSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcSairActionPerformed(evt);
            }
        });
        menOpc.add(menOpcSair);

        jMenuBar1.add(menOpc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
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
                .addContainerGap(556, Short.MAX_VALUE))
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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem manCadArea;
    private javax.swing.JMenu menCad;
    private javax.swing.JMenuItem menCadCursos;
    private javax.swing.JMenuItem menCadGrupo;
    private javax.swing.JMenuItem menCadPpc;
    private javax.swing.JMenuItem menCadUc;
    private javax.swing.JMenu menOpc;
    private javax.swing.JMenuItem menOpcLogout;
    private javax.swing.JMenuItem menOpcSair;
    // End of variables declaration//GEN-END:variables
}
