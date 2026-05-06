package model;

import java.time.LocalDate;

public class RegistroAtividade {
    private Long id;
    private Usuario usuario;
    private Atividade atividade;
    private LocalDate data;

    public RegistroAtividade(Long id, Usuario usuario, Atividade atividade, LocalDate data) {
        this.id = id;
        this.usuario = usuario;
        this.atividade = atividade;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
