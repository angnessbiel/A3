package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class Connect {

    public static Connection getConnection() {
        try {
            // Carregar driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Carregar configurações externas
            Properties props = new Properties();
            FileInputStream file = new FileInputStream("config.properties");
            props.load(file);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Conectar
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;

        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
