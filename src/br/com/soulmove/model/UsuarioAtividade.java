package br.com.soulmove.model;
import java.time.LocalDate;
public class UsuarioAtividade {
	private long id;
	private LocalDate dataAtividade;
	private int pontuacaoRecebida;
	private Usuario usuario;
	private Atividade atividade;

	public UsuarioAtividade(long id, LocalDate dataAtividade, Usuario usuario, Atividade atividade) {
		this.id = id;
		this.dataAtividade = dataAtividade;
		this.usuario = usuario;
		this.atividade = atividade;
		this.pontuacaoRecebida = atividade.calcularPontuacao();
	}

	public boolean validarRegistroAtividade() { return atividade.validarAtividade(); }
	public long getId() { return id; }
	public LocalDate getDataAtividade() { return dataAtividade; }
	public int getPontuacaoRecebida() { return pontuacaoRecebida; }
	public Usuario getUsuario() { return usuario; }
	public Atividade getAtividade() { return atividade; }
}
