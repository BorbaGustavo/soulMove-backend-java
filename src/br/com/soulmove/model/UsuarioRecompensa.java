package br.com.soulmove.model;
import java.time.LocalDate;
public class UsuarioRecompensa {
	private long id;
	private LocalDate dataRecebimento;
	private Usuario usuario;
	private Recompensa recompensa;

	public UsuarioRecompensa(long id, LocalDate dataRecebimento, Usuario usuario, Recompensa recompensa) {
		this.id = id;
		this.dataRecebimento = dataRecebimento;
		this.usuario = usuario;
		this.recompensa = recompensa;
	}

	public long getId() { return id; }
	public LocalDate getDataRecebimento() { return dataRecebimento; }
	public Usuario getUsuario() { return usuario; }
	public Recompensa getRecompensa() { return recompensa; }
}
