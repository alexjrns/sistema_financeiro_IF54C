/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Calendar;


public class Conta {
    private int codConta;
    private String descricao;
    private double saldo;
    private double limiteCredito;
    private Calendar dataRegistro;

    public Conta() {
        super();
    }

    public Conta(int codConta, String descricao, double saldo, double limiteCredito, Calendar dataRegistro) {
        this.codConta = codConta;
        this.descricao = descricao;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
        this.dataRegistro = dataRegistro;
    }

    public int getCodConta() {
        return codConta;
    }

    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Calendar getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Calendar dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    
    
}
