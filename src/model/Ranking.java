package model;

import java.util.List;

public class Ranking {
    private List<Usuario> usuarios;

    public Ranking() {
    }

    public Ranking(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
