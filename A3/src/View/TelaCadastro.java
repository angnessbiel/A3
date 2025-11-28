package View;


import DAO.UsuarioDAO;
import model.Usuario;
import javax.swing.*;

public class TelaCadastro extends JFrame {

    private JTextField txtNome;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnCadastrar;

    public TelaCadastro() {

        setTitle("Cadastro de Usuário");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 20, 200, 25);
        add(txtNome);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(20, 60, 80, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(100, 60, 200, 25);
        add(txtEmail);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 100, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 100, 200, 25);
        add(txtSenha);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 150, 120, 35);
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> cadastrarUsuario());
    }

    private void cadastrarUsuario() {

        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = String.valueOf(txtSenha.getPassword());

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        Usuario usuario = new Usuario(nome, email, senha);
        UsuarioDAO dao = new UsuarioDAO();

        if (dao.cadastrar(usuario)) {
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            txtNome.setText("");
            txtEmail.setText("");
            txtSenha.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaCadastro().setVisible(true));
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

