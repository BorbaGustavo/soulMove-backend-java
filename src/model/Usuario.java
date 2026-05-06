package model;

public class Usuario {
    private long id;
    private String nome;
    private String email;
    private int pontuacaoTotal;

    public Usuario(long id, String nome, String email, int pontuacaoTotal) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pontuacaoTotal = pontuacaoTotal;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }
}



