package br.com.atividadeintegradora.model;

public class Generos {
    private long id;
    private String termo;

    public Generos(long id, String termo) {
        this.id = id;
        this.termo = termo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }
}
