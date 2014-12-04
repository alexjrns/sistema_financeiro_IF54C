package GUI;

import Entidades.Usuario;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


/**
 *
 * @author JoãoRicardo
 */
public class Principal extends javax.swing.JFrame {
    private Usuario usu;
    
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
        itmUsuarios = new javax.swing.JMenuItem();
        itmClientes = new javax.swing.JMenuItem();
        itmFornecedor = new javax.swing.JMenuItem();
        itmClassificacoes = new javax.swing.JMenuItem();
        itmContas = new javax.swing.JMenuItem();
        contasReceber = new javax.swing.JMenu();
        itmTitulosReceber = new javax.swing.JMenuItem();
        itmBaixarTitulosReceber = new javax.swing.JMenuItem();
        contasPagar = new javax.swing.JMenu();
        itmTitulosPagar = new javax.swing.JMenuItem();
        itmBaixarTitulosPagar = new javax.swing.JMenuItem();
        ajuda = new javax.swing.JMenu();
        sobre = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SisFi - Sistema de controle financeiro");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cadastros.setText("Cadastros");

        itmUsuarios.setText("Usuários");
        itmUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmUsuariosActionPerformed(evt);
            }
        });
        cadastros.add(itmUsuarios);

        itmClientes.setText("Clientes");
        itmClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmClientesActionPerformed(evt);
            }
        });
        cadastros.add(itmClientes);

        itmFornecedor.setText("Fornecedores");
        itmFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmFornecedorActionPerformed(evt);
            }
        });
        cadastros.add(itmFornecedor);

        itmClassificacoes.setText("Classificações");
        itmClassificacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmClassificacoesActionPerformed(evt);
            }
        });
        cadastros.add(itmClassificacoes);

        itmContas.setText("Contas bancárias");
        itmContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmContasActionPerformed(evt);
            }
        });
        cadastros.add(itmContas);

        jMenuBar1.add(cadastros);

        contasReceber.setText("Contas a receber");

        itmTitulosReceber.setText("Títulos a receber");
        contasReceber.add(itmTitulosReceber);

        itmBaixarTitulosReceber.setText("Baixar títulos a receber");
        contasReceber.add(itmBaixarTitulosReceber);

        jMenuBar1.add(contasReceber);

        contasPagar.setText("Contas a pagar");

        itmTitulosPagar.setText("Títulos a pagar");
        contasPagar.add(itmTitulosPagar);

        itmBaixarTitulosPagar.setText("Baixar títulos a pagar");
        contasPagar.add(itmBaixarTitulosPagar);

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

    public Usuario getUsuarioLogado(){
        return this.usu;
    }
    
    public void setUsuarioLogado(Usuario usuario){
        this.usu = usuario;
    }
    
    private void sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobreActionPerformed

    }//GEN-LAST:event_sobreActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed

    }//GEN-LAST:event_sairActionPerformed

    private void itmUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmUsuariosActionPerformed
        CadastroUsuario usr = new CadastroUsuario();
        usr.setUsuarioLogado(usu);
        usr.setVisible(true);
    }//GEN-LAST:event_itmUsuariosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int result = (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do sistema?", "Confirmção", JOptionPane.YES_NO_OPTION));
        if(result == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void itmClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmClientesActionPerformed
        CadastroCliente cli = new CadastroCliente();
        cli.setUsuarioLogado(usu);
        cli.setVisible(true);
    }//GEN-LAST:event_itmClientesActionPerformed

    private void itmFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmFornecedorActionPerformed
        CadastroFornecedor forn = new CadastroFornecedor();
        forn.setUsuarioLogado(usu);
        forn.setVisible(true);
    }//GEN-LAST:event_itmFornecedorActionPerformed

    private void itmClassificacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmClassificacoesActionPerformed
        CadastroClassificacao cla = new CadastroClassificacao();
        cla.setVisible(true);
    }//GEN-LAST:event_itmClassificacoesActionPerformed

    private void itmContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmContasActionPerformed
        ContaBancaria con = new ContaBancaria();
        con.setUsuarioLogado(usu);
        con.setVisible(true);
    }//GEN-LAST:event_itmContasActionPerformed

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
    private javax.swing.JMenuItem itmBaixarTitulosPagar;
    private javax.swing.JMenuItem itmBaixarTitulosReceber;
    private javax.swing.JMenuItem itmClassificacoes;
    private javax.swing.JMenuItem itmClientes;
    private javax.swing.JMenuItem itmContas;
    private javax.swing.JMenuItem itmFornecedor;
    private javax.swing.JMenuItem itmTitulosPagar;
    private javax.swing.JMenuItem itmTitulosReceber;
    private javax.swing.JMenuItem itmUsuarios;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenuItem sobre;
    // End of variables declaration//GEN-END:variables
}
