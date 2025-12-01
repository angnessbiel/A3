package View;

import javax.swing.JPanel;

public class TelaMenuUsuario extends javax.swing.JPanel {

    private long idUsuarioLogado;

    public TelaMenuUsuario(long idUsuario) {
        initComponents();
        this.idUsuarioLogado = idUsuario;
    }

    public TelaMenuUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnEditarUsuario = new javax.swing.JButton();

        setBackground(new java.awt.Color(215, 215, 215));
        setLayout(new java.awt.GridBagLayout());

        btnEditarUsuario.setBackground(new java.awt.Color(156, 156, 156));
        btnEditarUsuario.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnEditarUsuario.setForeground(new java.awt.Color(10, 10, 10));
        btnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/edit.png"))); // NOI18N
        btnEditarUsuario.setText("Editar Perfil");
        btnEditarUsuario.setMaximumSize(new java.awt.Dimension(300, 300));
        btnEditarUsuario.setMinimumSize(new java.awt.Dimension(130, 70));
        btnEditarUsuario.setPreferredSize(new java.awt.Dimension(170, 70));
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });
        add(btnEditarUsuario, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        TelaEdicaoUsuario telaEdicao = new TelaEdicaoUsuario(this.idUsuarioLogado);
        telaEdicao.setVisible(true);
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarUsuario;
    // End of variables declaration//GEN-END:variables
}
