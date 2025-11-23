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

    public static ArrayList getMinhaLista = new ArrayList<>();

    public ProdutoDAO() {
    }

    public Connection getConexao() {
        return Connect.getConnection();
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM produto");
                res.next();
                maiorID = res.getInt("id");
            }

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    // Retorna a Lista de produtos(objetos)
    public ArrayList getMinhaLista() {

        getMinhaLista.clear(); // Limpa ArrayList

        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT * FROM produto");
                while (res.next()) {

                    int id = res.getInt("id");
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

    // Deleta um produto espec�fico pelo seu campo ID
    public boolean DeleteProdutoBD(int id) {
        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                stmt.executeUpdate("DELETE FROM produto WHERE id = " + id);
            }

        } catch (SQLException erro) {
        }

        return true;
    }

    // Edita um produto espec�fico pelo seu campo ID
    public boolean UpdateProdutoBD(Produto objeto) {

        String sql = "UPDATE produto SET nome = ?, descricao = ?, quantEstq = ?, preco = ?, data_cad = ? WHERE id = ?";

        try {
            try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
                stmt.setString(1, objeto.getNome());
                stmt.setString(2, objeto.getDesc());
                stmt.setInt(3, objeto.getQuantEstq());
                stmt.setDouble(4, objeto.getPreco());
                stmt.setDate(5, (java.sql.Date) objeto.getData_cad());
                stmt.setInt(6, objeto.getId());

                stmt.execute();
            }

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Produto carregaProduto(int id) {

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

        } catch (SQLException erro) {
        }
        return objeto;
    }

        public ArrayList MinhaLista() {

    getMinhaLista.clear();

    String sql = "SELECT * FROM produto";

    try (Connection conn = Connect.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet res = stmt.executeQuery()) {

        while (res.next()) {
            Produto p = new Produto(
                res.getInt("id"),
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

    
    
    
    
    
}
