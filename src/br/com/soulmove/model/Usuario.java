package br.com.soulmove.model;


import java.util.Collection;

public class Usuario {

	private long id;

	private String nome;

	private String email;

	private String senha;

	private String fotoUsuario;

	private int pontuacaoUsuario;

	private int pontuacaoSoul;

	private Collection<Atividade> atividade ;

	private Ranking ranking;

	private Collection<UsuarioAtividade> usuarioAtividade;

	private Collection<UsuarioRecompensa> usuarioRecompensa;

	public void cadastrarAtividade() {

	}

	public void consultarRanking() {

	}

	public void receberRecompensa() {

	}

}
