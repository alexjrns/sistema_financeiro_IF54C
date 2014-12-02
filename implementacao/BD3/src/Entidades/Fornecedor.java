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
public class Fornecedor {
    private int codFornecedor;
    private Pessoa pessoa;

    public Fornecedor() {
        super();
    }

    public Fornecedor(int codFornecedor, Pessoa pessoa) {
        this.codFornecedor = codFornecedor;
        this.pessoa = pessoa;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }   
}
