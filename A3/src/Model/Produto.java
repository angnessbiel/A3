package Model;

import java.util.*;
import DAO.ProdutoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Produto {

    private int id;
    private String nome;
    private String desc;
    private int quantEstq;
    private double preco;
    private Date data_cad;

    // INSTÂNCIA DO DAO (correção)
    @SuppressWarnings("FieldMayBeFinal")
    private ProdutoDAO dao = new ProdutoDAO();

    public Produto() {
    }

    public Produto(int id, String nome, String desc, int quantEstq, double preco, Date data_cad) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.quantEstq = quantEstq;
        this.preco = preco;
        this.data_cad = data_cad;
    }

    // GETTERS E SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String descricao) {
        this.desc = descricao;
    }

    public int getQuantEstq() {
        return quantEstq;
    }

    public void setQuantEstq(int quantEstq) {
        this.quantEstq = quantEstq;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getData_cad() {
        return data_cad;
    }

    public void setData_cad(Date data_cad) {
        this.data_cad = data_cad;
    }

    // MÉTODOS DE BANCO DE DADOS
    @SuppressWarnings("FieldMayBeFinal")
    private List<Produto> minhaLista = new ArrayList<>();

    public List<Produto> getMinhaLista() {
        return minhaLista;
    }

    public boolean InsertProduto(String nome, String desc, int quantEstq, double preco, String data_cad) {
        try {
            // Converte a data (String) para Date
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date data = formato.parse(data_cad);

            // Chama o método existente que envia para o DAO
            return InsertProdutoBD(nome, desc, quantEstq, preco, data);

        } catch (ParseException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            return false;
        }
    }

    public boolean UpdateProdutoBD(int id, String desc, String nome, int quantEstq, double preco, String data_cad) {
        try {
            // Converte a data (String) para Date
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date data = formato.parse(data_cad);

            // Chama o método existente que envia para o DAO
            return UpdateProdutoBD(id, nome, desc, quantEstq, preco, data);

        } catch (ParseException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
            return false;
        }
    }

    private boolean InsertProdutoBD(String nome, String desc, int quantEstq, double preco, Date data) {
    try {
        Produto p = new Produto();
        p.setNome(nome);
        p.setDesc(desc);
        p.setQuantEstq(quantEstq);
        p.setPreco(preco);
        p.setData_cad(data);

        dao.InsertProdutoBD(p); // CHAMA O DAO DE VERDADE

        return true;

    } catch (SQLException e) {
        System.out.println("Erro ao inserir no BD: " + e.getMessage());
        return false;
    }
}

    private boolean UpdateProdutoBD(int id, String nome, String desc, int quantEstq, double preco, Date data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean DeleteProdutoBD(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
