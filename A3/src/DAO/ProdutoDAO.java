package DAO;

import Model.Produto;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {

    // CORREÇÃO 1: Adicionar Generics <Produto>
    public static ArrayList<Produto> getMinhaLista = new ArrayList<>();

    public ProdutoDAO() {
    }

    // Assumindo que 'Connect' existe e tem o método getConnection()
    public Connection getConexao() {
        return Connect.getConnection();
    }

    public long maiorID() throws SQLException {

        long maiorID = 0;
        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM produto");
                res.next();

                maiorID = res.getLong("id");
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        return maiorID;
    }

    // CORREÇÃO 2: Retornar ArrayList<Produto>
    public ArrayList<Produto> getMinhaLista() {

        getMinhaLista.clear(); // Limpa ArrayList

        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT * FROM produto");
                while (res.next()) {

                    long id = res.getLong("id");
                    String nome = res.getString("nome");
                    String desc = res.getString("descricao");
                    int quantEstq = res.getInt("quantestq");
                    double preco = res.getDouble("preco");
                    Date data_cad = res.getDate("data_cad");

                    Produto objeto = new Produto(
                            id,
                            nome,
                            desc,
                            quantEstq,
                            preco,
                            data_cad
                    );
                    getMinhaLista.add(objeto);

                }
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());

        }
        return getMinhaLista;
    }

    // Cadastra novo produto
    public void InsertProdutoBD(Produto p) throws SQLException {
        Connection conn = Connect.getConnection();
        String sql = "INSERT INTO produto (nome, descricao, quantEstq, preco, data_cad) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getDesc());
        ps.setInt(3, p.getQuantEstq());
        ps.setDouble(4, p.getPreco());
        ps.setDate(5, new java.sql.Date(p.getData_cad().getTime())); // converte java.util.Date -> java.sql.Date
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    // Deleta um produto específico pelo seu ID
    public boolean DeleteProdutoBD(long id) {

        try (Statement stmt = this.getConexao().createStatement()) {
            stmt.executeUpdate("DELETE FROM produto WHERE id = " + id);

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        return true;
    }

    // Edita um produto específico pelo seu ID
    public boolean UpdateProdutoBD(Produto objeto) {

        String sql = "UPDATE produto SET nome = ?, descricao = ?, quantEstq = ?, preco = ? WHERE id = ?";

        try {
            try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
                stmt.setString(1, objeto.getNome());
                stmt.setString(2, objeto.getDesc());
                stmt.setInt(3, objeto.getQuantEstq());
                stmt.setDouble(4, objeto.getPreco());
                stmt.setLong(5, objeto.getId());

                stmt.execute();
            }

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Produto carregaProduto(long id) {

        Produto objeto = new Produto();
        objeto.setId(id);

        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT * FROM produto WHERE id = " + id);
                res.next();

                objeto.setNome(res.getString("nome"));
                objeto.setDesc(res.getString("descricao"));
                objeto.setQuantEstq(res.getInt("quantEstq"));
                objeto.setPreco(res.getDouble("preco"));
                objeto.setData_cad(res.getDate("data_cad"));
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return objeto;
    }

    // CORREÇÃO 3: Retornar ArrayList<Produto>
    public ArrayList<Produto> MinhaLista() {

        getMinhaLista.clear();

        String sql = "SELECT * FROM produto";

        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                Produto p = new Produto(
                        res.getLong("id"),
                        res.getString("nome"),
                        res.getString("descricao"),
                        res.getInt("quantEstq"),
                        res.getDouble("preco"),
                        res.getDate("data_cad")
                );
                getMinhaLista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar lista: " + e.getMessage());
        }

        return getMinhaLista;
    }
    
    // Este método já estava usando Generics corretamente
    public List<Produto> listarTodosProdutos() {
        List<Produto> lista = new ArrayList<>();

        String sql = "SELECT id, nome, descricao, quantEstq, preco, data_cad FROM produto ORDER BY nome";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setDesc(rs.getString("descricao"));
                p.setQuantEstq(rs.getInt("quantEstq"));
                p.setPreco(rs.getDouble("preco"));
                p.setData_cad(rs.getDate("data_cad"));

                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos para relatório: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão no relatório: " + e.getMessage());
            }
        }
        return lista;
    }

}