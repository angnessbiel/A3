


package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/seubanco";
    private static final String USER = "postgres";
    private static final String PASS = "sua_senha";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}

    
