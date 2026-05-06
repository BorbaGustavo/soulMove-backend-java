//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import model.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Objeto usuario instanciado
        Usuario user1 = new Usuario(1L, "Gustavo", "gus@email.com", 0);
        Usuario user2 = new Usuario(2L, "Ana", "ana@email.com", 100);
        Usuario user3 = new Usuario(3L, "Otoniel", "oto@email.com", 250);
        Usuario user4 = new Usuario(4L, "Felipe", "felps@email.com", 50);
        Usuario user5 = new Usuario(5L, "Alexandre", "ale@email.com", 0);

        //criando atividades para test
        Atividade atividadeCaminhada = new Atividade(1L, TipoAtividade.CAMINHADA, 10,0,false);
        Atividade atividadeBike = new Atividade(2L, TipoAtividade.BIKE, 10,0,false);
        Atividade atividadeTransPublico = new Atividade(3L, TipoAtividade.TRANSPORTE_PUBLICO, 10,0,false);

        //Registrar atividade
        RegistroAtividadeService registroService = new RegistroAtividadeService();

        // Mostrar pontuação
        System.out.println("Pontuação:");
        System.out.println(user1.getNome() + ": " + user1.getPontuacaoTotal());
        System.out.println(user2.getNome() + ": " + user2.getPontuacaoTotal());

        // Ranking
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);
        usuarios.add(user5);

        System.out.println("\nRanking:");
        for (Usuario u : usuarios) {
            System.out.println(u.getNome() + " - " + u.getPontuacaoTotal());
        }

        Scanner entrada = new Scanner(System.in);
        long novoId = usuarios.size() + 1;

        System.out.println("=== SOULMOVE ===");

        // Criar usuário nonvo
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite seu email: ");
        String email = entrada.nextLine();

        Usuario newuser = new Usuario(novoId, nome, email, 0);
        usuarios.add(newuser);


        boolean rodando = true;

        while (rodando) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Registrar atividade");
            System.out.println("2 - Ver pontuação");
            System.out.println("3 - Ver ranking");
            System.out.println("0 - Sair");


            int opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nEscolha atividade:");
                    System.out.println("1 - Caminhada");
                    System.out.println("2 - Bike");
                    System.out.println("3 - Transporte Público");

                    int tipoEscolhido = entrada.nextInt();

                    TipoAtividade tipo = null;

                    switch (tipoEscolhido) {
                        case 1: tipo = TipoAtividade.CAMINHADA; break;
                        case 2: tipo = TipoAtividade.BIKE; break;
                        case 3: tipo = TipoAtividade.TRANSPORTE_PUBLICO; break;
                        default:
                            System.out.println("Opção inválida!");
                            continue;
                    }

                    System.out.print("Digite a distância (km): ");
                    double km = entrada.nextDouble();

                    Atividade atividade = new Atividade(1L, tipo, km, 0, false);

                    System.out.println("Atividade registrada!");
                    break;

                case 2:
                    System.out.println("\nPontuação atual: " + newuser.getPontuacaoTotal());
                    break;

                case 3:
                    System.out.println("\nRanking:");
                    for (Usuario u : usuarios) {
                        System.out.println(u.getNome() + " - " + u.getPontuacaoTotal());
                    }
                    break;

                case 0:
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        entrada.close();
        System.out.println("Encerrando...");
    }



    }

