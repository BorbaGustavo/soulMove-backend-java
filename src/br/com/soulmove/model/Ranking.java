package br.com.soulmove.model;
public class Ranking {
	private long id;
	private int posicao;
	private int pontuacaoTotal;
	private Usuario usuario;

	public Ranking(long id, int posicao, int pontuacaoTotal, Usuario usuario) {
		this.id = id;
		this.posicao = posicao;
		this.pontuacaoTotal = pontuacaoTotal;
		this.usuario = usuario;
	}

	public void atualizarRanking(int novaPontuacao) { this.pontuacaoTotal = novaPontuacao; }
	public long getId() { return id; }
	public int getPosicao() { return posicao; }
	public Usuario getUsuario() { return usuario; }
	public int getPontuacaoTotal() { return pontuacaoTotal; }
	public void setPosicao(int posicao) { if (posicao >= 0) this.posicao = posicao; }
}
