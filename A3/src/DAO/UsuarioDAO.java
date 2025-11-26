
    package DAO;

    import Model.Usuario;
    import util.Conexao;
    import java.sql.*;
    import java.security.MessageDigest;


    public class UsuarioDAO {

          // Gera hash SHA-256
        private String hashSenha(String senha) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(senha.getBytes("UTF-8"));

                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if(hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean autenticar(String username, String senha) {

            String sql = "SELECT * FROM usuario WHERE username = ? AND senha = ?";

            try (Connection con = Conexao.getConnection();
                 PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.setString(1, username);
                stmt.setString(2, hashSenha(senha));

                ResultSet rs = stmt.executeQuery();

                return rs.next(); // true = autenticado

            } catch (SQLException e) {
                System.out.println("Erro ao autenticar: " + e.getMessage());
                return false;
            }
        }
    }
