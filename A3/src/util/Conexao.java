package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://blackzssj-1696.jxf.gcp-southamerica-east1.cockroachlabs.cloud:26257/invex_a3?sslmode=require";
    private static final String USER = "jean";
    private static final String PASS = "jAXTJ4CowRPCpB5HmpxZdA";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}
