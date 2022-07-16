package org.example;

public class Alunos {
    private String nome;
    private int id;
    private String email;
    private int ciclo;

    public Alunos( int id, String nome, String email, int ciclo) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.ciclo = ciclo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }
}
