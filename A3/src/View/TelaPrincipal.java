package View;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class TelaPrincipal extends javax.swing.JFrame {

    private long idUsuarioLogado;
    private String nomeUsuarioLogado;

    private CardLayout cardLayout;

    GerenciaProduto objeto = new GerenciaProduto();

    public TelaPrincipal(long idUsuario, String nomeUsuario) {
        initComponents();
        this.idUsuarioLogado = idUsuario;
        this.nomeUsuarioLogado = nomeUsuario;
        setLocationRelativeTo(null);
        meuInit();

        exibirMensagemBoasVindas();

    }

    public TelaPrincipal() {
        this(0, "Usuario test");
    }

    private void exibirMensagemBoasVindas() {
        if (lblBoasVindas != null && nomeUsuarioLogado != null) {
            lblBoasVindas.setText("Bem-vindo(a), " + this.nomeUsuarioLogado + "!");
        }
    }

    private void meuInit() {
        cardLayout = (CardLayout) painelPrincipal.getLayout();

        TelaMenuProduto painelProduto = new TelaMenuProduto();
        TelaMenuUsuario painelUsuario = new TelaMenuUsuario(this.idUsuarioLogado);

        // Se quiser uma tela inicial vazia ou de boas vindas:
        painelPrincipal.add(jPanel2, "home");
        painelPrincipal.add(painelProduto, "telaProduto");
        painelPrincipal.add(painelUsuario, "telaUsuario");

        cardLayout.show(painelPrincipal, "home");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblBoasVindas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Estoque");

        jPanel3.setBackground(new java.awt.Color(4, 55, 65));
        jPanel3.setPreferredSize(new java.awt.Dimension(150, 550));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(0, 114, 129));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(250, 250, 250));
        jButton1.setText("Produto");
        jButton1.setInheritsPopupMenu(true);
        jButton1.setPreferredSize(new java.awt.Dimension(100, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(81, 14, 0, 17);
        jPanel3.add(jButton1, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(0, 114, 129));
        jButton3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(250, 250, 250));
        jButton3.setText("Usuário");
        jButton3.setPreferredSize(new java.awt.Dimension(100, 60));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.ipady = 41;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 17);
        jPanel3.add(jButton3, gridBagConstraints);

        jButton4.setBackground(new java.awt.Color(0, 114, 129));
        jButton4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(250, 250, 250));
        jButton4.setText("Sair");
        jButton4.setPreferredSize(new java.awt.Dimension(100, 60));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 43;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 93, 17);
        jPanel3.add(jButton4, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel1.setBackground(new java.awt.Color(4, 55, 65));
        jPanel1.setPreferredSize(new java.awt.Dimension(495, 60));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 250, 250));
        jLabel1.setText("Sistema de Estoque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 6, 276);
        jPanel1.add(jLabel1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        painelPrincipal.setBackground(new java.awt.Color(215, 215, 215));
        painelPrincipal.setLayout(new java.awt.CardLayout());

        lblBoasVindas.setBackground(new java.awt.Color(255, 255, 255));
        lblBoasVindas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBoasVindas.setForeground(new java.awt.Color(0, 0, 0));
        lblBoasVindas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblBoasVindas);

        painelPrincipal.add(jPanel2, "card2");

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cardLayout.show(painelPrincipal, "telaProduto");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cardLayout.show(painelPrincipal, "telaUsuario");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            FlatMacLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Falha ao iniciar o LaF: " + ex.getMessage());
        }

        UIManager.put("defaultFont", new Font("SansSerif", Font.PLAIN, 13));

        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBoasVindas;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
