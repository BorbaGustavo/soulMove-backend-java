package br.com.soulmove.service;

import br.com.soulmove.model.Ranking;
import br.com.soulmove.model.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankingService {

    // Lista em memória simulando o banco de dados
    private List<Ranking> rankings = new ArrayList<>();
    private long proximoId = 1;

    // Registra ou atualiza o ranking de um usuario
    public Ranking atualizarRanking(Usuario usuario) {
        // Verifica se o usuario ja tem um ranking
        Ranking rankingExistente = buscarPorUsuario(usuario);

        if (rankingExistente != null) {
            // Atualiza pontuacao
            rankingExistente.atualizarRanking(usuario.getPontuacaoUsuario());
        } else {
            // Cria novo registro de ranking
            rankingExistente = new Ranking(
                    proximoId++,
                    0, // posicao sera recalculada
                    usuario.getPontuacaoUsuario(),
                    usuario
            );
            rankings.add(rankingExistente);
            usuario.setRanking(rankingExistente);
        }

        // Recalcula todas as posicoes
        recalcularPosicoes();

        return rankingExistente;
    }

    // Recalcula as posicoes de todos os usuarios por pontuacao (maior = 1o lugar)
    private void recalcularPosicoes() {
        rankings.sort(Comparator.comparingInt(Ranking::getPontuacaoTotal).reversed());
        for (int i = 0; i < rankings.size(); i++) {
            rankings.get(i).setPosicao(i + 1);
        }
    }

    // Busca o ranking de um usuario especifico
    public Ranking buscarPorUsuario(Usuario usuario) {
        for (Ranking r : rankings) {
            if (r.getUsuario().getId() == usuario.getId()) {
                return r;
            }
        }
        return null;
    }

    // Retorna o ranking completo ordenado
    public List<Ranking> obterRankingCompleto() {
        recalcularPosicoes();
        return new ArrayList<>(rankings);
    }

    public void exibirRanking() {

        List<Ranking> lista = obterRankingCompleto();

        System.out.println("\n================================================");
        System.out.println("                RANKING GERAL");
        System.out.println("================================================");

        if (lista.isEmpty()) {

            System.out.println("Nenhum usuário no ranking.");

        } else {

            for (Ranking r : lista) {

                String destaque =
                        switch (r.getPosicao()) {
                            case 1 -> "[TOP 1]";
                            case 2 -> "[TOP 2]";
                            case 3 -> "[TOP 3]";
                            default -> "       ";
                        };

                System.out.printf(
                        "%-8s %2d° | %-20s | %4d pts%n",
                        destaque,
                        r.getPosicao(),
                        r.getUsuario().getNome(),
                        r.getPontuacaoTotal()
                );
            }
        }

        System.out.println("================================================");
    }
}

