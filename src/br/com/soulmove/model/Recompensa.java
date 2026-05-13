package br.com.soulmove.model;

import java.util.Collection;

public class Recompensa {

	private long id ;

	private String descricao;

	private int valor;

	private Ranking ranking;

	private Collection<UsuarioRecompensa> usuarioRecompensa;

	public int resgatarRecompensa() {
		return 0;
	}

}
