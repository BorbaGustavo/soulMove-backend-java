import java.util.Collection;

public class Atividade  {

	private long id;

	private String nomeAtividade;

	private String descricao;

	private String validacao;

	private int pontucao;

	private Usuario usuario;

	private Missao missao;

	private TipoAtividade tipoAtividade;

	private TiposAtividade tiposAtividade;

	private Collection<UsuarioAtividade> usuarioAtividade;

	public void validaAtividade() {

	}

	public int calcularPontuacao() {
		return 0;
	}

}
