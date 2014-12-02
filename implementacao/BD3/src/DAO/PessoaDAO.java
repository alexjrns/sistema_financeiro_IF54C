/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Pessoa;
import JDBC.ExecutaBanco;

/**
 *
 * @author Mamao
 */
public class PessoaDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();

    public PessoaDAO() {
        super();
    }

    public boolean cadastrar(Pessoa pessoa){
        EnderecoDAO endDAO = new EnderecoDAO();
        exeBanco.abreTransacao();
        if(endDAO.cadastrar(pessoa.getEndereco())){
            String nome = pessoa.getNome();
            String documento = pessoa.getDocumento();
            String telefone = pessoa.getTelefone();
            String endereco = String.valueOf(pessoa.getEndereco().getChave());
            String[][] vetPessoa = { {"id_pessoa", ""}, {"cod_pessoa", ""}, {"des_nome", nome}, {"val_documento", documento}, {"des_telefone", telefone}, {"fk_endereco", endereco} };
            if(exeBanco.cadastrar("pessoa", vetPessoa)){
                return exeBanco.commit();
            } else{
                exeBanco.rollback();
                return false;
            }
        } else return false;        
    }

    public boolean alterar(Pessoa pessoa){
        return false;
    }
}
