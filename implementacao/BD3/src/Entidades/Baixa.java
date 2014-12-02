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
public class Baixa {
    private int codBaixa;
    private Calendar dataBaixa;
    private double desconto;
    private double juros;
    private Titulo titulo;
    private Lancamento lancamento;

    public Baixa() {
    }

    public Baixa(int codBaixa, Calendar dataBaixa, double desconto, double juros, Titulo titulo, Lancamento lancamento) {
        this.codBaixa = codBaixa;
        this.dataBaixa = dataBaixa;
        this.desconto = desconto;
        this.juros = juros;
        this.titulo = titulo;
        this.lancamento = lancamento;
    }

    public int getCodBaixa() {
        return codBaixa;
    }

    public void setCodBaixa(int codBaixa) {
        this.codBaixa = codBaixa;
    }

    public Calendar getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Calendar dataBaixa) {
        this.dataBaixa = dataBaixa;
    }    
    
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }    
    
    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }    
}
