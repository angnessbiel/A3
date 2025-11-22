package DAO;

public class TesteConexao {
    public static void main(String[] args) {

        if (Connect.getConnection() != null) {
            System.out.println("Conectado com sucesso ao banco!");
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}
