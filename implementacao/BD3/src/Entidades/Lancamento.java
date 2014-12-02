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
public class Lancamento {
    private int codLancamento;
    private Conta contaBancaria;    
    private String numDocumento;
    private Calendar dataLancamento;
    private Classificacao classificacao;
    private double valor;
    private double valorVinculado;
    private String origem;

    public Lancamento() {
        super();
    }

    public Lancamento(int codLancamento, Conta contaBancaria, String numDocumento, Calendar dataLancamento, Classificacao classificacao, double valor, double valorVinculado, String origem) {
        this.codLancamento = codLancamento;
        this.contaBancaria = contaBancaria;
        this.numDocumento = numDocumento;
        this.dataLancamento = dataLancamento;
        this.classificacao = classificacao;
        this.valor = valor;
        this.valorVinculado = valorVinculado;
        this.origem = origem;
    }

    public int getCodLancamento() {
        return codLancamento;
    }

    public void setCodLancamento(int codLancamento) {
        this.codLancamento = codLancamento;
    }

    public Conta getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(Conta contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorVinculado() {
        return valorVinculado;
    }

    public void setValorVinculado(double valorVinculado) {
        this.valorVinculado = valorVinculado;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    
}
