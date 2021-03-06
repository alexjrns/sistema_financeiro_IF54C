/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ContaDAO;
import Entidades.Conta;
import Entidades.Usuario;
import JDBC.ExecutaBanco;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author JoãoRicardo
 */
public class ContaBancaria extends javax.swing.JFrame {
    private Usuario usu;
    private ExecutaBanco exe;
    private ContaDAO conDAO;
    
    /**
     * Creates new form TitulosReceber
     */
    public ContaBancaria() {
        initComponents();
        setIcon();
        exe = new ExecutaBanco();
        conDAO = new ContaDAO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumero = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        lblLogin2 = new javax.swing.JLabel();
        lblLogin3 = new javax.swing.JLabel();
        lblLogin5 = new javax.swing.JLabel();
        lblLogin6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();
        txtSaldoAtual = new javax.swing.JTextField();
        txtLimiteCredito = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de contas bancárias");
        setResizable(false);

        txtNumero.setEditable(false);

        lblNumero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumero.setText("Número");

        lblLogin2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLogin2.setText("Descrição:");

        lblLogin3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLogin3.setText("Saldo Atual:");

        lblLogin5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLogin5.setText("Valor Limite de Crédito:");

        lblLogin6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLogin6.setText("Data de Registro:");

        txtCodigo.setEditable(false);

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigo.setText("Código");

        tblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDadosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDadosMousePressed(evt);
            }
        });
        tblDados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDadosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDados);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtDescricao.setEditable(false);

        txtSaldoAtual.setEditable(false);

        txtLimiteCredito.setEditable(false);

        txtData.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNumero)
                    .addComponent(lblLogin3)
                    .addComponent(lblLogin2)
                    .addComponent(lblLogin5)
                    .addComponent(lblLogin6)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSaldoAtual)
                    .addComponent(txtDescricao)
                    .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLimiteCredito)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtData))
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin3)
                    .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin5)
                    .addComponent(txtLimiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin6)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnCancelar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnRemover))
                .addContainerGap())
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

    private Conta setConta(){
        int codConta = Integer.parseInt(txtCodigo.getText());
        String numero = txtNumero.getText();
        String descricao = txtDescricao.getText();
        Double saldoAtual = Double.parseDouble(txtSaldoAtual.getText());
        Double limiteCredito = Double.parseDouble(txtLimiteCredito.getText());
        String dta = txtData.getText();
        
        int dia = Integer.parseInt(dta.substring(0, 2));
        System.out.println(dia);
        int mes = Integer.parseInt(dta.substring(3, 5));
        System.out.println(mes);
        int ano = Integer.parseInt(dta.substring(6, 10));
        System.out.println(ano);
        Calendar data = Calendar.getInstance();
        data.set(ano, mes, dia);

        return new Conta(codConta, descricao, saldoAtual, limiteCredito, data);
    }        

    private void tblDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseClicked
        int row = tblDados.getSelectedRow();
        txtCodigo.setText(tblDados.getValueAt(row, 0).toString());
        txtNumero.setText(tblDados.getValueAt(row , 1).toString());
        txtDescricao.setText(tblDados.getValueAt(row, 2).toString());
        txtSaldoAtual.setText(tblDados.getValueAt(row, 3).toString());
        txtLimiteCredito.setText(tblDados.getValueAt(row, 4).toString());
        txtData.setText(tblDados.getValueAt(row, 5).toString());

        btnAlterar.setEnabled(true);
        if (usu.isTesoureiro())
        btnRemover.setEnabled(true);
        else
        btnRemover.setEnabled(false);
    }//GEN-LAST:event_tblDadosMouseClicked

    private void tblDadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMousePressed

    }//GEN-LAST:event_tblDadosMousePressed

    private void tblDadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDadosKeyPressed

    }//GEN-LAST:event_tblDadosKeyPressed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txtCodigo.setText(String.valueOf(exe.codAtual("conta")));
        txtNumero.setText("");
        txtNumero.setEditable(true);
        txtDescricao.setText("");
        txtDescricao.setEditable(true);
        txtSaldoAtual.setText("");
        txtSaldoAtual.setEditable(true);
        txtLimiteCredito.setText("");
        txtLimiteCredito.setEditable(true);
        txtData.setText("");
        txtData.setEditable(true);

        btnNovo.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnRemover.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        txtNumero.setEditable(true);
        txtDescricao.setEditable(true);
        txtSaldoAtual.setEditable(true);
        txtLimiteCredito.setEditable(true);
        txtData.setEditable(true);

        btnNovo.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnRemover.setEnabled(false);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(conDAO.salvar(this.setConta())){
            txtNumero.setEditable(false);
            txtDescricao.setEditable(false);
            txtSaldoAtual.setEditable(false);
            txtLimiteCredito.setEditable(false);
            txtData.setEditable(false);

            btnNovo.setEnabled(true);
            btnPesquisar.setEnabled(true);
            btnAlterar.setEnabled(true);
            btnSalvar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnRemover.setEnabled(false);
            tblDados.setModel(conDAO.consultarTodosTable());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtCodigo.setText("");
        txtNumero.setText("");
        txtNumero.setEditable(false);
        txtDescricao.setText("");
        txtDescricao.setEditable(false);
        txtSaldoAtual.setText("");
        txtSaldoAtual.setEditable(false);
        txtLimiteCredito.setText("");
        txtLimiteCredito.setEditable(false);
        txtData.setText("");
        txtData.setEditable(false);

        btnNovo.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnRemover.setEnabled(false);
        tblDados.setModel(conDAO.consultarTodosTable());
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int result = (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse registro?", "Confirmção", JOptionPane.YES_NO_OPTION));
        if(result == JOptionPane.YES_NO_OPTION){
            if(conDAO.remover(this.setConta())){
                txtCodigo.setText("");
                txtNumero.setText("");
                txtNumero.setEditable(false);
                txtDescricao.setText("");
                txtDescricao.setEditable(false);
                txtSaldoAtual.setText("");
                txtSaldoAtual.setEditable(false);
                txtLimiteCredito.setText("");
                txtLimiteCredito.setEditable(false);
                txtData.setText("");
                txtData.setEditable(false);

                btnNovo.setEnabled(true);
                btnPesquisar.setEnabled(true);
                btnAlterar.setEnabled(false);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnRemover.setEnabled(false);

                tblDados.setModel(conDAO.consultarTodosTable());
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        tblDados.setModel(conDAO.consultarTodosTable());
        txtCodigo.setText("");
        txtNumero.setText("");
        txtNumero.setEditable(false);
        txtDescricao.setText("");
        txtDescricao.setEditable(false);
        txtSaldoAtual.setText("");
        txtSaldoAtual.setEditable(false);
        txtLimiteCredito.setText("");
        txtLimiteCredito.setEditable(false);
        txtData.setText("");
        txtData.setEditable(false);

        btnNovo.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnRemover.setEnabled(false);
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(ContaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ContaBancaria().setVisible(true);
            }
        });
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/sisfi_icone.png")));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblLogin2;
    private javax.swing.JLabel lblLogin3;
    private javax.swing.JLabel lblLogin5;
    private javax.swing.JLabel lblLogin6;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JTable tblDados;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtLimiteCredito;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSaldoAtual;
    // End of variables declaration//GEN-END:variables
}
