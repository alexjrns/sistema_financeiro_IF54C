/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Pessoa;
import JDBC.ExecutaBanco;
import java.util.List;

/**
 *
 * @author Mamao
 */
public class PessoaDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    private EnderecoDAO endDAO = new EnderecoDAO();
    public PessoaDAO() {
        super();
    }

    public boolean cadastrar(Pessoa pessoa){
        exeBanco.abreTransacao();
        if(endDAO.cadastrar(pessoa.getEndereco())){
            String nome = pessoa.getNome();
            String documento = pessoa.getDocumento();
            String telefone = pessoa.getTelefone();
            String codEndereco = String.valueOf(exeBanco.buscarEndereco(pessoa.getEndereco().getCodEndereco()).getChave());

            String[][] vetPessoa = { {"id_pessoa", ""}, {"cod_pessoa", ""}, {"des_nome", nome}, {"val_documento", documento}, {"val_telefone", telefone}, {"fk_endereco", codEndereco} };
            if(exeBanco.cadastrar("pessoa", vetPessoa)){
                return exeBanco.commit();
            } else{
                exeBanco.rollback();
                return false;
            }
        } else return false;        
    }

    public boolean alterar(Pessoa pessoa){
        exeBanco.abreTransacao();
        if(endDAO.cadastrar(pessoa.getEndereco())){
            String nome = pessoa.getNome();
            String documento = pessoa.getDocumento();
            String telefone = pessoa.getTelefone();
            String codEndereco = String.valueOf(exeBanco.buscarEndereco(pessoa.getEndereco().getCodEndereco()).getChave());
            System.out.println("Endereco chave: " + String.valueOf(exeBanco.buscarEndereco(pessoa.getEndereco().getCodEndereco()).getChave()));

            String[][] vetPessoa = { {"id_pessoa", ""}, {"cod_pessoa", ""}, {"des_nome", nome}, {"val_documento", documento}, {"des_telefone", telefone}, {"fk_endereco", codEndereco} };
            if(exeBanco.cadastrar("pessoa", vetPessoa)){
                return exeBanco.commit();
            } else{
                exeBanco.rollback();
                return false;
            }
        } else return false;
    }

    public boolean remover(Pessoa pessoa){
        String codigo = String.valueOf(pessoa.getCodPessoa());
        String codEndereco = String.valueOf(pessoa.getEndereco().getCodEndereco());
        exeBanco.abreTransacao();
        if(exeBanco.remover("pessoa", ("pessoa.cod_pessoa = " + codigo))){
            exeBanco.abreTransacao();
            if(exeBanco.remover("endereco", ("endereco.cod_endereco = " + codEndereco))){
                exeBanco.commit();
                return exeBanco.commit();
            }else{
                exeBanco.rollback();
                exeBanco.rollback();
                return false;
            }
        }else{
            exeBanco.rollback();
            return false;
        }
    }
    
    public Pessoa consultar(int codigo){
        return exeBanco.buscarPessoa(codigo);
    }
    
    public List<Pessoa> consultarTodos(){
        return exeBanco.buscarTodosPessoa();
    }
}
