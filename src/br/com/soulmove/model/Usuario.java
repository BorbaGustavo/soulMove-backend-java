package br.com.soulmove.model;
import java.util.ArrayList;
import java.util.List;
public class Usuario {
	private long id;
	private String nome;
	private String email;
	private String senha;
	private String fotoUsuario;
	private int pontuacaoUsuario;
	private int pontuacaoSoul;
	private Ranking ranking;
	private List<UsuarioAtividade> usuarioAtividade;
	private List<UsuarioRecompensa> usuarioRecompensa;

	public Usuario(long id, String nome, String email, String senha) {
		this.id = id; this.nome = nome; this.email = email; this.senha = senha;
		this.pontuacaoUsuario = 0; this.pontuacaoSoul = 0;
		this.usuarioAtividade = new ArrayList<>();
		this.usuarioRecompensa = new ArrayList<>();
	}

	public void adicionarPontos(int pontos) { if (pontos > 0) this.pontuacaoUsuario += pontos; }
	public void cadastrarAtividade(UsuarioAtividade atividade) { this.usuarioAtividade.add(atividade); }
	public void receberRecompensa(UsuarioRecompensa recompensa) { this.usuarioRecompensa.add(recompensa); }

	public long getId() { return id; }
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getSenha() { return senha; }
	public int getPontuacaoUsuario() { return pontuacaoUsuario; }
	public String getFotoUsuario() { return fotoUsuario; }
	public Ranking getRanking() { return ranking; }
	public int getPontuacaoSoul() { return pontuacaoSoul; }
	public List<UsuarioAtividade> getUsuarioAtividade() { return usuarioAtividade; }
	public List<UsuarioRecompensa> getUsuarioRecompensa() { return usuarioRecompensa; }
	public void setFotoUsuario(String fotoUsuario) { this.fotoUsuario = fotoUsuario; }
	public void setRanking(Ranking ranking) { this.ranking = ranking; }
}
