package br.com.atividadeintegradora.model;

public class Pessoa {
    private String nome;
    private String nomeSocial;
    private String genero;
    private float renda;

    public Pessoa(String nome, String nomeSocial, String genero, float renda) {
        this.nome = nome;
        this.nomeSocial = nomeSocial;
        this.genero = genero;
        this.renda = renda;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        this.renda = renda;
    }
}
