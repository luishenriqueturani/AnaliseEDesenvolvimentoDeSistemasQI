package model;

public class Clientes {

    //ATRIBUTOS
    private String nome, documento, dataCadastro;
    private double creditoLimite, creditoUsado, consumoUsado;

    //CONSTRUTOR
    public Clientes(final String nome, final String documento, final String dataCadastro, final double creditoLimite) {
        this.nome = nome;
        this.documento = documento;
        this.dataCadastro = dataCadastro;
        this.creditoLimite = creditoLimite;
        this.consumoUsado = 0;
        this.creditoUsado = 0;
    }

    //ASSESSORES
    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getDocumento() {
        return documento;
    }

    protected void setDocumento(String documento) {
        this.documento = documento;
    }

    protected String getDataCadastro() {
        return dataCadastro;
    }

    protected void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    protected double getCreditoLimite() {
        return creditoLimite;
    }

    protected void setCreditoLimite(double creditoLimite) {
        this.creditoLimite = creditoLimite;
    }

    protected double getCreditoUsado() {
        return this.creditoUsado;
    }

    protected void setCreditoUsado(final double creditoUsado) {
        this.creditoUsado = creditoUsado;
    }

    protected double getConsumoUsado() {
        return this.consumoUsado;
    }

    protected void setConsumoUsado(final double consumoUsado) {
        this.consumoUsado = consumoUsado;
    }
}
