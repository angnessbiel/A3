package View;

import javax.swing.JOptionPane;
import DAO.UsuarioDAO;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class TelaEdicaoUsuario extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaEdicaoUsuario.class.getName());
    private long idUsuarioLogado;

    public TelaEdicaoUsuario(long idUsuario) {
        initComponents();
        this.idUsuarioLogado = idUsuario;
        setLocationRelativeTo(null);
        txtNovoNome.putClientProperty("JComponent.roundRect", true);
        txtSenhaAtual.putClientProperty("JComponent.roundRect", true);
        txtNovaSenha.putClientProperty("JComponent.roundRect", true);

    }

    public TelaEdicaoUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        txtNovoNome.putClientProperty("JComponent.roundRect", true);
        txtSenhaAtual.putClientProperty("JComponent.roundRect", true);
        txtNovaSenha.putClientProperty("JComponent.roundRect", true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNovoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenhaAtual = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(215, 215, 215));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("  Edição de Usuário");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setLabelFor(txtNovoNome);
        jLabel2.setText("Alterar Nome:");
        jLabel2.setMaximumSize(new java.awt.Dimension(44, 19));
        jLabel2.setMinimumSize(new java.awt.Dimension(44, 19));
        jLabel2.setPreferredSize(new java.awt.Dimension(44, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 39, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        txtNovoNome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNovoNome.setMargin(new java.awt.Insets(5, 8, 5, 8));
        txtNovoNome.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 277;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 39, 0, 0);
        getContentPane().add(txtNovoNome, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setLabelFor(txtSenhaAtual);
        jLabel3.setText("Senha Atual:");
        jLabel3.setMaximumSize(new java.awt.Dimension(44, 19));
        jLabel3.setMinimumSize(new java.awt.Dimension(44, 19));
        jLabel3.setPreferredSize(new java.awt.Dimension(44, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 39, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        txtSenhaAtual.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtSenhaAtual.setMargin(new java.awt.Insets(5, 8, 5, 8));
        txtSenhaAtual.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 277;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 39, 0, 0);
        getContentPane().add(txtSenhaAtual, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setLabelFor(txtNovaSenha);
        jLabel4.setText("Nova Senha:");
        jLabel4.setMaximumSize(new java.awt.Dimension(44, 19));
        jLabel4.setMinimumSize(new java.awt.Dimension(44, 19));
        jLabel4.setPreferredSize(new java.awt.Dimension(44, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 39, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        txtNovaSenha.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNovaSenha.setMargin(new java.awt.Insets(5, 8, 5, 8));
        txtNovaSenha.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 277;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 39, 0, 0);
        getContentPane().add(txtNovaSenha, gridBagConstraints);

        jButton1.setText("Cancelar");
        jButton1.setMaximumSize(new java.awt.Dimension(90, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(90, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setMaximumSize(new java.awt.Dimension(90, 30));
        btnSalvar.setMinimumSize(new java.awt.Dimension(90, 30));
        btnSalvar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 184;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String novoNome = txtNovoNome.getText().trim();
        String senhaAtualDigitada = new String(txtSenhaAtual.getPassword());
        String novaSenha = new String(txtNovaSenha.getPassword());

        int idUsuarioLogado = 1;

        boolean querAlterarNome = !novoNome.isEmpty();
        boolean querAlterarSenha = !novaSenha.isEmpty();

        if (!querAlterarNome && !querAlterarSenha) {
            JOptionPane.showMessageDialog(this, "Nenhum campo preenchido para alteração.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (querAlterarSenha) {
            if (senhaAtualDigitada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha a Senha Atual para confirmar a alteração de senha.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        UsuarioDAO dao = new UsuarioDAO();

        try {
            // Se for alterar a senha, primeiro AUTENTICA
            if (querAlterarSenha) {
                String senhaArmazenada = dao.buscarSenhaAtual(this.idUsuarioLogado);

                if (senhaArmazenada == null || !senhaAtualDigitada.equals(senhaArmazenada)) {
                    JOptionPane.showMessageDialog(this, "A Senha Atual informada está incorreta.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
                    return; // Para o processo, pois a autenticação falhou
                }

                // Senha atual está correta, a Nova Senha será atualizada no BD
            }

            if (dao.atualizarDados(this.idUsuarioLogado, novoNome, novaSenha, querAlterarNome, querAlterarSenha)) {
                JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar os dados. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            FlatMacLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Falha ao iniciar o Laf");
        }

        UIManager.put("defaultFont", new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 13));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaEdicaoUsuario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JTextField txtNovoNome;
    private javax.swing.JPasswordField txtSenhaAtual;
    // End of variables declaration//GEN-END:variables
}
