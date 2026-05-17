package br.com.soulmove.model;
public class Recompensa {
	private long id;
	private String descricao;
	private int valor;

	public Recompensa(long id, String descricao, int valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public boolean podeReceberRecompensa(int pontoUsuario) { return pontoUsuario >= valor; }
	public long getId() { return id; }
	public String getDescricao() { return descricao; }
	public int getValor() { return valor; }
}
