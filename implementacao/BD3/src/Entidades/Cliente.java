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
public class Cliente {
    private int codCliente;
    private Pessoa pessoa;

    public Cliente() {
    }

    public Cliente(int codCliente, Pessoa pessoa) {
        this.codCliente = codCliente;
        this.pessoa = pessoa;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
