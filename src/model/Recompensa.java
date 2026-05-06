package model;

public class Recompensa {
    private Long id;
    private String descricao;
    private int custoPontos;

    public Recompensa(String descricao, Long id, int custoPontos) {
        this.descricao = descricao;
        this.id = id;
        this.custoPontos = custoPontos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCustoPontos() {
        return custoPontos;
    }

    public void setCustoPontos(int custoPontos) {
        this.custoPontos = custoPontos;
    }
}
