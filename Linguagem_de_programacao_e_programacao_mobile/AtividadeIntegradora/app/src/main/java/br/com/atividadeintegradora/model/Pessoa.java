package br.com.atividadeintegradora.model;

public class Pessoa {
    private long id;
    private String nome;
    private String nomeSocial;
    private String genero;
    private float renda;
    private String pai;
    private String mae;

    public Pessoa(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(long id, String nome, String nomeSocial, String genero, float renda) {
        this.id = id;
        this.nome = nome;
        this.nomeSocial = nomeSocial;
        this.genero = genero;
        this.renda = renda;
    }

    public Pessoa(String nome, String nomeSocial, String genero, float renda, String pai, String mae) {
        this.nome = nome;
        this.nomeSocial = nomeSocial;
        this.genero = genero;
        this.renda = renda;
        this.pai = pai;
        this.mae = mae;
    }

    public Pessoa(long id, String nome, String nomeSocial, String genero, float renda, String pai, String mae) {
        this.id = id;
        this.nome = nome;
        this.nomeSocial = nomeSocial;
        this.genero = genero;
        this.renda = renda;
        this.pai = pai;
        this.mae = mae;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", genero='" + genero + '\'' +
                ", renda=" + renda +
                ", pai='" + pai + '\'' +
                ", mae='" + mae + '\'' +
                '}';
    }
}
