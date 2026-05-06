package service;

import model.Atividade;

import static model.TipoAtividade.BIKE;
import static model.TipoAtividade.CAMINHADA;
import static model.TipoAtividade.TRANSPORTE_PUBLICO;

public class PontuacaoService {
    public int calcularPontuacao(Atividade atividade){

        int pontos =0;

        switch (atividade.getTipo()){
            case CAMINHADA:
                pontos = (int) (atividade.getDistanciaKm()*5);
                break;

            case BIKE:
                pontos = (int) (atividade.getDistanciaKm()*8);
                break;

            case TRANSPORTE_PUBLICO:
                pontos = 30;
                break;


        }

        //regra dos ponto : limite progressivo para evitar abuso de pontos
        if (pontos > 100){
            pontos = 100+ (pontos - 100)/4;

        }

        return pontos;
    }
}