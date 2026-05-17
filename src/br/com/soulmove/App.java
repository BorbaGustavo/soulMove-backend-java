package br.com.soulmove;

import br.com.soulmove.model.*;
import br.com.soulmove.service.AtividadeService;
import br.com.soulmove.service.RankingService;
import br.com.soulmove.service.RecompensaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {



    // Services
    static AtividadeService atividadeService = new AtividadeService();
    static RankingService rankingService = new RankingService();
    static RecompensaService recompensaService = new RecompensaService();

    static Scanner scanner = new Scanner(System.in);

    //Users para test

    static Usuario usuario1 =
            new Usuario(1L, "Ana Mendes", "ana@email.com", "senha123");

    static Usuario usuario2 =
            new Usuario(2L, "Felipe Passos", "felipe@email.com", "senha456");

    static Usuario usuario3 =
            new Usuario(3L, "Alexandre Santos", "ale@email.com", "senha789");

    static  Usuario usuario4 =
            new Usuario(4L, "Gustavo Borba", "gust@gmail.com","gust12345");

    static Usuario usuario5 =
            new Usuario(5L, "Otoniel mendes", "oto@email.com", "senha67890");

    //Atividades para test

    static Atividade reciclagem =
            new Atividade(
                    1L,
                    "Reciclagem",
                    "Separação correta de resíduos recicláveis",
                    "Foto da separação dos resíduos",
                    50,
                    TiposAtividade.RECICLAGEM
            );

    static Atividade transporte =
            new Atividade(
                    2L,
                    "Transporte Público",
                    "Uso de ônibus, metrô ou trem",
                    "Foto do bilhete",
                    35,
                    TiposAtividade.TRANSPORTE_PUBLICO
            );

    static Atividade caminhada =
            new Atividade(
                    3L,
                    "Trajeto a Pé",
                    "Realizar trajeto caminhando",
                    "Registro do percurso",
                    20,
                    TiposAtividade.TRAJETO_CAMINHADA
            );

    static Atividade bike =
            new Atividade(
                    4L,
                    "Trajeto de Bike",
                    "Realizar trajeto de bicicleta",
                    "Registro do percurso",
                    25,
                    TiposAtividade.TRAJETO_BIKE
            );

    static Atividade reducaoEnergia =
            new Atividade(
                    5L,
                    "Redução de Energia",
                    "Reduzir consumo de energia elétrica",
                    "Foto da conta de luz",
                    50,
                    TiposAtividade.REDUCAO_ENERGIA
            );


    public static void main(String[] args) {

        imprimirBanner();


        boolean executando = true;

        while (executando) {

            exibirMenuPrincipal();

            int opcao = lerOpcao(0, 4);

            switch (opcao) {
                // depois que descobri que pode usar -> no SS case
                case 1 -> menuRegistrarAtividade();

                case 2 -> menuPerfilUsuario();

                case 3 -> rankingService.exibirRanking();

                case 4 -> menuRecompensas();

                case 0 -> executando = false;
            }
        }

        System.out.println("\nObrigado por utilizar o SoulMove!");
        scanner.close();
    }

    // chamar o menu
    static void exibirMenuPrincipal() {

        System.out.println("\n======================================");
        System.out.println("              SOULMOVE");
        System.out.println("======================================");
        System.out.println("1 - Registrar atividade");
        System.out.println("2 - Ver perfil");
        System.out.println("3 - Ver ranking");
        System.out.println("4 - Recompensas");
        System.out.println("0 - Sair");
        System.out.println("======================================");
        System.out.print("Escolha uma opção: ");
    }

    // registro atividade

    static void menuRegistrarAtividade() {

        Usuario usuario = selecionarUsuario();

        List<Atividade> atividades = List.of(
                reciclagem,
                transporte,
                caminhada,
                bike,
                reducaoEnergia
        );

        System.out.println("\nATIVIDADES DISPONÍVEIS");

        for (int i = 0; i < atividades.size(); i++) {

            Atividade atividade = atividades.get(i);

            System.out.printf(
                    "%d - %s (+%d pts)%n",
                    i + 1,
                    atividade.getNomeAtividade(),
                    atividade.getPontucao()
            );
        }

        System.out.print("Escolha uma atividade: ");

        int opcao = lerOpcao(1, atividades.size());

        Atividade atividadeSelecionada = atividades.get(opcao - 1);

        System.out.println("\nValidando atividade...");
        System.out.println("Comprovante: "
                + atividadeSelecionada.getValidacao());

        UsuarioAtividade registro =
                atividadeService.registrarAtividade(
                        usuario,
                        atividadeSelecionada
                );

        if (registro != null) {

            rankingService.atualizarRanking(usuario);

            System.out.println("\nAtividade registrada com sucesso!");
            System.out.println("Atividade: "
                    + registro.getAtividade().getNomeAtividade());

            System.out.println("Pontos recebidos: +"
                    + registro.getPontuacaoRecebida());

            System.out.println("Pontuação total: "
                    + usuario.getPontuacaoUsuario());

            System.out.println("Posição ranking: "
                    + usuario.getRanking().getPosicao() + "°");
        }
    }

    // mostrar info do usuario

    static void menuPerfilUsuario() {

        Usuario usuario = selecionarUsuario();

        System.out.println("\n======================================");
        System.out.println("PERFIL DO USUÁRIO");
        System.out.println("======================================");

        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Pontuação: "
                + usuario.getPontuacaoUsuario());

        if (usuario.getRanking() != null) {

            System.out.println("Posição Ranking: "
                    + usuario.getRanking().getPosicao() + "°");
        }

        System.out.println("Atividades registradas: "
                + usuario.getUsuarioAtividade().size());

        System.out.println("Recompensas resgatadas: "
                + usuario.getUsuarioRecompensa().size());

        if (!usuario.getUsuarioAtividade().isEmpty()) {

            System.out.println("\nHISTÓRICO DE ATIVIDADES");

            for (UsuarioAtividade atividade
                    : usuario.getUsuarioAtividade()) {

                System.out.printf(
                        "- %s | +%d pts | %s%n",
                        atividade.getAtividade().getNomeAtividade(),
                        atividade.getPontuacaoRecebida(),
                        atividade.getDataAtividade()
                );
            }
        }
    }

    // recompensa

    static void menuRecompensas() {

        Usuario usuario = selecionarUsuario();

        recompensaService.exibirRecompensasDisponiveis(usuario);

        List<Recompensa> recompensas =
                recompensaService.getRecompensasDisponiveis();

        System.out.println("\n0 - Voltar");

        for (int i = 0; i < recompensas.size(); i++) {

            System.out.println(
                    (i + 1)
                            + " - "
                            + recompensas.get(i).getDescricao()
            );
        }

        System.out.print("Escolha: ");

        int opcao = lerOpcao(0, recompensas.size());

        if (opcao > 0) {

            recompensaService.resgatarRecompensa(
                    usuario,
                    recompensas.get(opcao - 1)
            );
        }
    }


    static Usuario selecionarUsuario() {

        System.out.println("\nSELECIONE UM USUÁRIO");

        System.out.println("1 - "
                + usuario1.getNome()
                + " (" + usuario1.getPontuacaoUsuario() + " pts)");

        System.out.println("2 - "
                + usuario2.getNome()
                + " (" + usuario2.getPontuacaoUsuario() + " pts)");

        System.out.println("3 - "
                + usuario3.getNome()
                + " (" + usuario3.getPontuacaoUsuario() + " pts)");
        System.out.println("4 - "
                + usuario4.getNome()
                + " (" + usuario4.getPontuacaoUsuario() + " pts)");
        System.out.println("5 - "
                + usuario5.getNome()
                + " (" + usuario5.getPontuacaoUsuario() + " pts)");

        System.out.print("Escolha: ");

        int opcao = lerOpcao(1, 5);

        return switch (opcao) {

            case 1 -> usuario1;
            case 2 -> usuario2;
            case 3 -> usuario3;
            case 4 -> usuario4;
            default -> usuario5;
        };
    }

    static int lerOpcao(int min, int max) {

        while (true) {

            try {

                int valor =
                        Integer.parseInt(scanner.nextLine());

                if (valor >= min && valor <= max) {
                    return valor;
                }

                System.out.printf(
                        "Digite um valor entre %d e %d: ",
                        min,
                        max
                );

            } catch (NumberFormatException e) {

                System.out.print("Entrada inválida: ");
            }
        }
    }

    static void imprimirBanner() {

        System.out.println("""
                 _____             _ __  ___
                / ___/____  __  __/ /  |/  /___ _   _____
                \\__ \\/ __ \\/ / / / / /|_/ / __ \\ | / / _ \\
               ___/ / /_/ / /_/ / / /  / / /_/ / |/ /  __/
              /____/\\____/\\__,_/_/_/  /_/\\____/|___/\\___/

                 Sustentabilidade com gamificação
                """);

        System.out.println("Data: " + LocalDate.now());
        System.out.println("Versão MVP 1.0\n");
    }
}