package Model;

import java.util.*;
import DAO.ProdutoDAO;
import java.sql.SQLException;

public class Produto {

private int id;
private String nome;
private String descricao;
private int quantEstq;
private double preco;
private Date data_cad;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, int quantEstq, double preco, Date data_cad) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantEstq = quantEstq;
        this.preco = preco;
        this.data_cad = data_cad;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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


    /*
    
        ABAIXO OS M�TODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    
     */
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        //return AlunoDAO.MinhaLista;
        return dao.getMinhaLista();
    }

    // Cadastra novo aluno
//    public boolean InsertAlunoBD(String curso, int fase, String nome, int idade) {
    public boolean InsertProdutoBD(String curso, int fase, String nome, int idade) throws SQLException {
        int id = this.maiorID() + 1;
        Produto objeto = new Produto(curso, fase, id, nome, idade);
//        AlunoDAO.MinhaLista.add(objeto);
        dao.InsertAlunoBD(objeto);
        return true;

    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteProdutoBD(int id) {
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.remove(indice);
        dao.DeleteAlunoBD(id);
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateProdutoBD(String curso, int fase, int id, String nome, int idade) {
        Produto objeto = new Produto(curso, fase, id, nome, idade);
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.set(indice, objeto);
        dao.UpdateProdutoBD(objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
//    private int procuraIndice(int id) {
//        int indice = -1;
//        for (int i = 0; i < AlunoDAO.MinhaLista.size(); i++) {
//            if (AlunoDAO.MinhaLista.get(i).getId() == id) {
//                indice = i;
//            }
//        }
//        return indice;
//    }

    // carrega dados de um aluno espec�fico pelo seu ID
    public Produto carregaProduto(int id) {
//        int indice = this.procuraIndice(id);
//        return AlunoDAO.MinhaLista.get(indice);
        dao.carregaProduto(id);
        return null;
    }
    
    // retorna o maior ID da nossa base de dados
        public int maiorID() throws SQLException{
//    public int maiorID(){
//        return AlunoDAO.maiorID();
        return dao.maiorID();
    }   
}
