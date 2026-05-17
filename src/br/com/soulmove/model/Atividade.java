package br.com.soulmove.model;
public class Atividade {
        private long id;
        private String nomeAtividade;
        private String descricao;
        private String validacao;
        private int pontuacao;
        private TiposAtividade tipoAtividade;

        public Atividade(long id, String nomeAtividade, String descricao, String validacao, int pontuacao, TiposAtividade tipoAtividade) {
                this.id = id;
                this.nomeAtividade = nomeAtividade;
                this.descricao = descricao;
                this.validacao = validacao;
                this.pontuacao = pontuacao;
                this.tipoAtividade = tipoAtividade;
        }

        public boolean validarAtividade() { return true; }
        public int calcularPontuacao() { return this.pontuacao; }

        public long getId() { return id; }
        public String getNomeAtividade() { return nomeAtividade; }
        public String getDescricao() { return descricao; }
        public String getValidacao() { return validacao; }
        public int getPontucao() { return pontuacao; }
        public TiposAtividade getTipoAtividade() { return tipoAtividade; }
}
