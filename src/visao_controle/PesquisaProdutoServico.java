/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao_controle;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ProdutoServico;
import modelo.dao.ProdutoServicoDAO;

/**
 *
 * @author karollyne
 */
public class PesquisaProdutoServico extends javax.swing.JDialog {

    ProdutoServicoDAO psd = new ProdutoServicoDAO();
    private ArrayList<ProdutoServico> listaProdutoServico = new ArrayList<>();
    private ArrayList<String> pesquisa = new ArrayList<>();

    /**
     * Creates new form PesquisaProdutoServico
     */
    public PesquisaProdutoServico() {
        initComponents();
        setModal(true);
        listar();
    }

    private void listar() {

        try {
            this.listaProdutoServico = psd.listarProdutosServicos(jtfPesquisa.getText());
            DefaultTableModel modeloTabela = (DefaultTableModel) jtLista.getModel();
            modeloTabela.setNumRows(0); //Limpa a tabela
            if (this.listaProdutoServico != null) {
                for (ProdutoServico p : this.listaProdutoServico) {
                    Object[] linha = new Object[4];
                    linha[0] = p.getNome();
                    linha[1] = p.getValor();
                    linha[2] = p.getFrequenciaAplicacao();
                    if (p.isServico() == true) {
                        linha[3] = "Serviço";
                    } else {
                        linha[3] = "Produto";
                    }
                    modeloTabela.addRow(linha);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao listar produtos e serviços", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
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
        jLabel1 = new javax.swing.JLabel();
        jtfPesquisa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLista = new javax.swing.JTable();
        jbAdicionar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 22, 59));
        jLabel1.setText("Lista de Produtos e Serviços");

        jtfPesquisa.setBackground(new java.awt.Color(1, 22, 59));
        jtfPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        jtfPesquisa.setToolTipText("Enter");
        jtfPesquisa.setMinimumSize(new java.awt.Dimension(6, 32));
        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyTyped(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N

        jtLista.setBackground(new java.awt.Color(1, 22, 59));
        jtLista.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtLista.setForeground(new java.awt.Color(255, 255, 255));
        jtLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "VALOR", "FREQUÊNCIA DE APLICAÇÃO", "TIPO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLista.setColumnSelectionAllowed(true);
        jtLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtLista.setFillsViewportHeight(true);
        jtLista.setGridColor(new java.awt.Color(1, 22, 59));
        jtLista.setIntercellSpacing(new java.awt.Dimension(3, 3));
        jtLista.setRowHeight(25);
        jtLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLista);
        jtLista.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtLista.getColumnModel().getColumnCount() > 0) {
            jtLista.getColumnModel().getColumn(0).setPreferredWidth(70);
            jtLista.getColumnModel().getColumn(1).setPreferredWidth(20);
            jtLista.getColumnModel().getColumn(2).setResizable(false);
            jtLista.getColumnModel().getColumn(2).setPreferredWidth(110);
            jtLista.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jbAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbAdicionar.setForeground(new java.awt.Color(1, 22, 59));
        jbAdicionar.setText("ADICIONAR");
        jbAdicionar.setToolTipText("");
        jbAdicionar.setBorderPainted(false);
        jbAdicionar.setContentAreaFilled(false);
        jbAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAdicionar.setPreferredSize(new java.awt.Dimension(125, 40));
        jbAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarActionPerformed(evt);
            }
        });

        jbExcluir.setBackground(new java.awt.Color(1, 22, 59));
        jbExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jbExcluir.setText("EXCLUIR");
        jbExcluir.setToolTipText("");
        jbExcluir.setBorderPainted(false);
        jbExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbExcluir.setMaximumSize(new java.awt.Dimension(103, 79));
        jbExcluir.setMinimumSize(new java.awt.Dimension(103, 79));
        jbExcluir.setPreferredSize(new java.awt.Dimension(125, 40));
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/home.png"))); // NOI18N
        jbHome.setToolTipText("Tela inicial");
        jbHome.setContentAreaFilled(false);
        jbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbHome, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jbHome, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarActionPerformed
        CadastroProdutoServico produtoservico = new CadastroProdutoServico();
        produtoservico.setVisible(true);
        listar();
    }//GEN-LAST:event_jbAdicionarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            int linhaSelecionada = jtLista.getSelectedRow();
            if (linhaSelecionada < 0) {
                JOptionPane.showMessageDialog(this, "Selecione uma linha da lista.", "Atenção",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que quer excluir este registro?", "Atenção",
                        JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    ProdutoServico linha = this.listaProdutoServico.get(linhaSelecionada);
                    linha.setRegistro_ativo(false);
                    psd.salvar(linha);
                    listar();

                }

            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao excluir", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jtListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaMouseClicked
        if (evt.getClickCount() == 2) {
            int linhaSelecionada = jtLista.getSelectedRow();
            ProdutoServico ps = this.listaProdutoServico.get(linhaSelecionada);
            CadastroProdutoServico produtoservico = new CadastroProdutoServico();
            produtoservico.setpsEdicao(ps);
            produtoservico.setVisible(true);
            listar();
        }
    }//GEN-LAST:event_jtListaMouseClicked

    private void jtfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyPressed
        if (evt.getKeyCode() == 10) {
            listar();
        }
    }//GEN-LAST:event_jtfPesquisaKeyPressed

    private void jtfPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyTyped
        if (!(evt.getKeyChar() + "").matches("[0-9A-Za-zãáéóõ\\- ]")) {
            evt.consume();
        } else if (String.valueOf(evt.getKeyChar()).matches(",")) {
            evt.consume();
        } else {
            listar();
        }
    }//GEN-LAST:event_jtfPesquisaKeyTyped

    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        if (jtfPesquisa.getText().equals("")) {
            listar();
        } else if ((evt.getKeyChar() + "").matches("[0-9A-Za-zãáéóõ\\- ]")) {
            listar();
        }

    }//GEN-LAST:event_jtfPesquisaKeyReleased

    private void jbHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHomeActionPerformed
        dispose();
    }//GEN-LAST:event_jbHomeActionPerformed

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
            java.util.logging.Logger.getLogger(PesquisaProdutoServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaProdutoServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaProdutoServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaProdutoServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaProdutoServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdicionar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbHome;
    private javax.swing.JTable jtLista;
    private javax.swing.JTextField jtfPesquisa;
    // End of variables declaration//GEN-END:variables
}
