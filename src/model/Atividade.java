package model;

public class Atividade {
    private Long id;
    private String TipoAtividade;
    private double distanciaKm;
    private int pontuacao;
    private boolean validada;


    public Atividade(Long id, String tipo, double distanciaKm, int pontuacao, boolean validada) {
        this.id = id;
        this.TipoAtividade = tipo;
        this.distanciaKm = distanciaKm;
        this.pontuacao = pontuacao;
        this.validada = validada;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return TipoAtividade;
    }

    public void setTipo(String tipo) {
        this.TipoAtividade = tipo;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isValidada() {
        return validada;
    }

    public void setValidada(boolean validada) {
        this.validada = validada;
    }
}
