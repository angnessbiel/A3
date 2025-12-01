package View;

import javax.swing.JPanel;


public class TelaMenuProduto extends JPanel {

    public TelaMenuProduto() {
        initComponents();
    }
    GerenciaProduto objeto = new GerenciaProduto();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(215, 215, 215));
        setPreferredSize(new java.awt.Dimension(550, 490));
        setLayout(new java.awt.GridBagLayout());

        jButton2.setBackground(new java.awt.Color(156, 156, 156));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(10, 10, 10));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/package.png"))); // NOI18N
        jButton2.setText("Gerenciar Estoque");
        jButton2.setMaximumSize(new java.awt.Dimension(300, 300));
        jButton2.setMinimumSize(new java.awt.Dimension(130, 70));
        jButton2.setPreferredSize(new java.awt.Dimension(180, 70));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 71;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 173, 158, 176);
        add(jButton2, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(156, 156, 156));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(10, 10, 10));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/plus.png"))); // NOI18N
        jButton1.setText("Novo Produto");
        jButton1.setMaximumSize(new java.awt.Dimension(300, 300));
        jButton1.setMinimumSize(new java.awt.Dimension(130, 70));
        jButton1.setPreferredSize(new java.awt.Dimension(170, 70));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(174, 173, 0, 176);
        add(jButton1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastroProduto objeto = new CadastroProduto();
        objeto.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        objeto.setVisible(true);
        objeto.carregaTabela();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
