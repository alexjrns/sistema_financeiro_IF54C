/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Mamao
 */
public class Classificacao {
    private int codClassificacao;
    private String descricao;
    private String tipooperacao;

    public Classificacao() {
        super();
    }

    public Classificacao(int codClassificacao, String descricao, String tipooperacao) {
        super();
        this.codClassificacao = codClassificacao;
        this.descricao = descricao;
        this.tipooperacao = tipooperacao;
    }

    public int getCodClassificacao() {
        return codClassificacao;
    }

    public void setCodClassificacao(int codClassificacao) {
        this.codClassificacao = codClassificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipooperacao() {
        return tipooperacao;
    }

    public void setTipooperacao(String tipooperacao) {
        this.tipooperacao = tipooperacao;
    }
    
}
