package model;

public class Missao {
    private Long id;
    private String titulo;
    private String descricao;
    private int recompensa;
    private boolean ativa;


    // Cosntrutor
    public Missao(Long id, String titulo, String descricao, int recompensa, boolean ativa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.recompensa = recompensa;
        this.ativa = ativa;
    }


     // Gets e Sets
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
