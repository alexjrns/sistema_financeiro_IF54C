/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Calendar;

/**
 *
 * @author Mamao
 */
public class Titulo {
    private int codTitulo;
    private String identificacao;
    private Calendar emissao;
    private Calendar vencimento;
    private double valorTitulo;
    private String observacao;
    private String tipo;
    private Classificacao classificacao;
    private Pessoa pessoa;

    public Titulo() {
        super();
    }

    public Titulo(int codTitulo, String identificacao, Calendar emissao, Calendar vencimento, double valorTitulo, String observacao, String tipo, Classificacao classificacao, Pessoa pessoa) {
        super();
        this.codTitulo = codTitulo;
        this.identificacao = identificacao;
        this.emissao = emissao;
        this.vencimento = vencimento;
        this.valorTitulo = valorTitulo;
        this.observacao = observacao;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.pessoa = pessoa;
    }

    public int getCodTitulo() {
        return codTitulo;
    }

    public void setCodTitulo(int codTitulo) {
        this.codTitulo = codTitulo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Calendar getEmissao() {
        return emissao;
    }

    public void setEmissao(Calendar emissao) {
        this.emissao = emissao;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public double getValorTitulo() {
        return valorTitulo;
    }

    public void setValorTitulo(double valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
