package model;

public class ClienteC extends Clientes{

    //CONSTRUTOR, COMO HERDA CLIENTES, O CONSTRUTOR POSSUI OS ATRIBUTOS DE CLIENTES
    public ClienteC(final String nome, final String documento, final String dataCadastro) {
        super(nome, documento, dataCadastro, 1000);
    }

    //NÃO POSSUI NENHUM ATRIBUTO NEM CLASSE ASSESSORA PRÓPRIA, USA APENAS AS DE CLIENTES
}
