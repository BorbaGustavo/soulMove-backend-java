package br.com.soulmove.service;

import br.com.soulmove.model.Recompensa;
import br.com.soulmove.model.Usuario;
import br.com.soulmove.model.UsuarioRecompensa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecompensaService {

    // Lista de recompensas disponíveis na plataforma
    private List<Recompensa> recompensasDisponiveis = new ArrayList<>();
    private long proximoIdResgate = 1;

    public RecompensaService() {
        // Recompensas pré-cadastradas na plataforma
        recompensasDisponiveis.add(new Recompensa(1L, "100% Desconto na fatura de energia", 500));
        recompensasDisponiveis.add(new Recompensa(2L, "25% Desconto de  na fatura de energia", 150));
    }

    // Tenta resgatar uma recompensa para o usuario
    public UsuarioRecompensa resgatarRecompensa(Usuario usuario, Recompensa recompensa) {
        if (!recompensa.podeReceberRecompensa(usuario.getPontuacaoUsuario())) {
            System.out.println("\n Pontos insuficientes para resgatar: " + recompensa.getDescricao());
            System.out.println("   Necessário: " + recompensa.getValor() + " pts | "
                    + "Você tem: " + usuario.getPontuacaoUsuario() + " pts");
            return null;
        }

        UsuarioRecompensa resgate = new UsuarioRecompensa(
                proximoIdResgate++,
                LocalDate.now(),
                usuario,
                recompensa
        );

        usuario.receberRecompensa(resgate);

        System.out.println("\n Recompensa resgatada com sucesso!");
        System.out.println("   " + recompensa.getDescricao());
        System.out.println("   Data: " + LocalDate.now());

        return resgate;
    }

    // Exibe todas as recompensas disponíveis e se o usuario pode resgatar
    public void exibirRecompensasDisponiveis(Usuario usuario) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("|              RECOMPENSAS DISPONÍVEIS                  |");
        System.out.println("---------------------------------------------------------");
        System.out.printf("  Seus pontos: " + usuario.getPontuacaoUsuario());
        System.out.println("\n---------------------------------------------------------");

        for (Recompensa r : recompensasDisponiveis) {

            String status =
                    r.podeReceberRecompensa(usuario.getPontuacaoUsuario())
                            ? "DISPONÍVEL"
                            : "INDISPONÍVEL - Necessário: "
                            + r.getValor()
                            + " pts";

            System.out.printf(
                    "%-30s %s%n",
                    r.getDescricao(),
                    status
            );
        }

        System.out.println(
                "----------------------------------------------------------"
        );
    }

    // Exibe o historico de recompensas do usuario
    public void exibirHistoricoRecompensas(Usuario usuario) {
        System.out.println("\n--- Histórico de recompensas de " + usuario.getNome() + " ---");
        if (usuario.getUsuarioRecompensa().isEmpty()) {
            System.out.println("  Nenhuma recompensa resgatada ainda.");
        } else {
            for (UsuarioRecompensa ur : usuario.getUsuarioRecompensa()) {
                System.out.println(ur.getRecompensa().getDescricao()
                        + "Resgatada em: " + ur.getDataRecebimento());
            }
        }
    }

    public List<Recompensa> getRecompensasDisponiveis() {
        return recompensasDisponiveis;
    }
}
