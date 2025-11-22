package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class Connect {

    public static Connection getConnection() {
        try {
            // Carregar driver
            Class.forName("org.postgresql.Driver");

            // Carregar configurações externas
            Properties props = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
            props.load(file);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Conectar
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
