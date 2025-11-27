package View;

import javax.swing.JPanel;

public class TelaMenuUsuario extends javax.swing.JPanel {

    public TelaMenuUsuario() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(215, 215, 215));
        setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(156, 156, 156));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(10, 10, 10));
        jButton1.setText("Fazer Login");
        jButton1.setMaximumSize(new java.awt.Dimension(300, 300));
        jButton1.setPreferredSize(new java.awt.Dimension(170, 70));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 56;
        gridBagConstraints.ipady = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(167, 187, 0, 187);
        add(jButton1, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(156, 156, 156));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(10, 10, 10));
        jButton2.setText("Configurações");
        jButton2.setMaximumSize(new java.awt.Dimension(300, 300));
        jButton2.setPreferredSize(new java.awt.Dimension(170, 70));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 187, 165, 187);
        add(jButton2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
