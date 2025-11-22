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

    public static ArrayList<Produto> MinhaLista = new ArrayList<>();

    public ProdutoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_Produtos'");
                res.next();
                maiorID = res.getInt("id");
            }

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public Connection getConexao() {

        @SuppressWarnings("UnusedAssignment")
        Connection connection = null;  //inst�ncia da conex�o

        try {

            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conex�o
            String server = "localhost"; //caminho do MySQL
            String database = "Produto_db";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: N�O CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver n�o encontrado
            System.out.println("O driver nao foi encontrado. " + e.getMessage() );
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        
        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT * FROM tb_Produtos");
                while (res.next()) {
                    
                    
                    int id = res.getInt("Id");
                    String nome = res.getString("Nome");
                    String desc = res.getString ("Descrição");
                    int quantEstq = res.getInt("Quantidade no estoque");
                    double preco = res.getDouble("Preço");
                    Date data_cad = res.getDate ("Data do Cadastro");
                    
                    Produto objeto = new Produto(
                        id,
                        nome,
                        desc,
                        quantEstq,
                        preco,
                        data_cad
                    );
                        MinhaLista.add(objeto);

                }
            }

        } catch (SQLException ex) {
        
        }
        return MinhaLista;
    }
    
    // Cadastra novo aluno
   public void InsertProdutoBD(Produto p) throws SQLException {
        Connection conn = Connect.getConnection(); // seu método de conexão
        String sql = "INSERT INTO produto (id, nome, descricao, quantEstq, preco, data_cad) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.setString(2, p.getNome());
        ps.setString(3, p.getDesc());
        ps.setInt(4, p.getQuantEstq());
        ps.setDouble(5, p.getPreco());
        ps.setDate(6, new java.sql.Date(p.getData_cad().getTime())); // converte java.util.Date -> java.sql.Date
        ps.executeUpdate();
        ps.close();
        conn.close();
    }


    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteProdutoBD(int id) {
        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                stmt.executeUpdate("DELETE FROM tb_alunos WHERE id = " + id);
            }            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateProdutoBD(Produto objeto) {

        String sql = "UPDATE produto SET nome = ?, descricao = ?, quantEstq = ?, preco = ?, data_cad = ? WHERE id = ?";

        try {
            try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
                stmt.setInt(1, objeto.getId());
                stmt.setString(2, objeto.getNome());
                stmt.setString(3, objeto.getDesc());
                stmt.setInt(4, objeto.getQuantEstq());
                stmt.setDouble(5, objeto.getPreco());
                stmt.setDate (6, (java.sql.Date) objeto.getData_cad());
                
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
                ResultSet res = stmt.executeQuery("SELECT * FROM tb_alunos WHERE id = " + id);
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
}
