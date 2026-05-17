package br.com.soulmove.service;
import br.com.soulmove.model.Atividade;
import br.com.soulmove.model.Usuario;
import br.com.soulmove.model.UsuarioAtividade;
import java.time.LocalDate;
public class AtividadeService {
    private long proximoId = 1;

    public UsuarioAtividade registrarAtividade(Usuario usuario, Atividade atividade) {
        if (!atividade.validarAtividade()) {
            System.out.println("Atividade inválida.");
            return null;
        }
        UsuarioAtividade usuarioAtividade = new UsuarioAtividade(proximoId++, LocalDate.now(), usuario, atividade);
        usuario.adicionarPontos(usuarioAtividade.getPontuacaoRecebida());
        usuario.cadastrarAtividade(usuarioAtividade);
        return usuarioAtividade;
    }
}
