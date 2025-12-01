package DAO;

import Model.Usuario;
import util.Conexao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO {

    public boolean cadastrar(Usuario u) {

        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            String senhaPura = u.getSenha();
            String senhaHashed = BCrypt.hashpw(senhaPura, BCrypt.gensalt());

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, senhaHashed);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public Usuario autenticar(String email, String senhaDigitada) {

        String sql = "SELECT * FROM usuario WHERE email = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaHashedDoBanco = rs.getString("senha");

                if (BCrypt.checkpw(senhaDigitada, senhaHashedDoBanco)) {
                    Usuario u = new Usuario();
                    u.setId(rs.getLong("id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    return u;
                } else {
                    // Senha incorreta
                    return null;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        }

        return null;
    }

    public String buscarSenhaAtual(long idUsuario) {
        String sql = "SELECT senha FROM usuario WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("senha");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar senha: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizarDados(long idUsuario, String novoNome, String novaSenha,
            boolean querAlterarNome, boolean querAlterarSenha) {

        if (!querAlterarNome && !querAlterarSenha) {
            return true;
        }

        StringBuilder sql = new StringBuilder("UPDATE usuario SET ");

        if (querAlterarNome) {
            sql.append("nome = ?");
        }

        if (querAlterarSenha) {
            if (querAlterarNome) {
                sql.append(", ");
            }
            sql.append("senha = ?");
        }

        sql.append(" WHERE id = ?");

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int index = 1;

            if (querAlterarNome) {
                stmt.setString(index++, novoNome);
            }

            if (querAlterarSenha) {
                String novaSenhaHashed = BCrypt.hashpw(novaSenha, BCrypt.gensalt());
                stmt.setString(index++, novaSenhaHashed);
            }

            stmt.setLong(index, idUsuario);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados: " + e.getMessage());
            return false;
        }
    }
}
