package model;

public class Validacao {
    private Long id;
    private Atividade atividade;
    private boolean aprovada;
    private String evidencia;

    public Validacao(Atividade atividade, Long id, boolean aprovada, String evidencia) {
        this.atividade = atividade;
        this.id = id;
        this.aprovada = aprovada;
        this.evidencia = evidencia;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }
}
