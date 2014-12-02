package GUI;

import java.awt.Toolkit;


/**
 *
 * @author JoãoRicardo
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setIcon();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        cadastros = new javax.swing.JMenu();
        usuarios = new javax.swing.JMenuItem();
        contasReceber = new javax.swing.JMenu();
        contasPagar = new javax.swing.JMenu();
        ajuda = new javax.swing.JMenu();
        sobre = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastros.setText("Cadastros");

        usuarios.setText("Usuários");
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });
        cadastros.add(usuarios);

        jMenuBar1.add(cadastros);

        contasReceber.setText("Contas a receber");
        jMenuBar1.add(contasReceber);

        contasPagar.setText("Contas a pagar");
        jMenuBar1.add(contasPagar);

        ajuda.setText("Ajuda");

        sobre.setText("Sobre");
        sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobreActionPerformed(evt);
            }
        });
        ajuda.add(sobre);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        ajuda.add(sair);

        jMenuBar1.add(ajuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobreActionPerformed

    }//GEN-LAST:event_sobreActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed

    }//GEN-LAST:event_sairActionPerformed

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        CadastroUsuario usr = new CadastroUsuario();
        usr.setVisible(true);
    }//GEN-LAST:event_usuariosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/sisfi_icone.png")));
    }      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajuda;
    private javax.swing.JMenu cadastros;
    private javax.swing.JMenu contasPagar;
    private javax.swing.JMenu contasReceber;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenuItem sobre;
    private javax.swing.JMenuItem usuarios;
    // End of variables declaration//GEN-END:variables
}
