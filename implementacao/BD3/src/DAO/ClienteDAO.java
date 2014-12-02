/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;

import JDBC.ExecutaBanco;
import java.util.List;

/**
 *
 * @author Mamao
 */
public class ClienteDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public ClienteDAO() {
        super();
    }
    
    public boolean cadastrar(Cliente cliente){
        PessoaDAO pesDAO = new PessoaDAO();
        exeBanco.abreTransacao();
        if(pesDAO.cadastrar(cliente.getPessoa())){
            String pessoa = String.valueOf(cliente.getPessoa().getChave());
            String[][] vetCliente = { {"id_cliente", ""}, {"cod_cliente", ""}, {"fk_pessoa", pessoa} };
            if(exeBanco.cadastrar("cliente", vetCliente)){
                return exeBanco.commit();
            } else{
                exeBanco.rollback();
                return false;
            }
        } else return false;
    }
    
    public boolean alterar(Cliente cliente){
        PessoaDAO pesDAO = new PessoaDAO();
        exeBanco.abreTransacao();
        if(pesDAO.alterar(cliente.getPessoa())){
            String pessoa = String.valueOf(cliente.getPessoa().getChave());
            String codCliente = String.valueOf(cliente.getCodCliente());
            String[][] vetCliente = { {"id_cliente", ""}, {"cod_cliente", codCliente}, {"fk_pessoa", pessoa} };
            if(exeBanco.alterar("cliente", vetCliente)){
                return exeBanco.commit();
            } else{
                exeBanco.rollback();
                return false;
            }
        } else return false;
    }
    
    public boolean remover(Cliente cliente){
        String codigo = String.valueOf(cliente.getCodCliente());
        return exeBanco.remover("cliente", ("cliente.cod_cliente = " + codigo));
    }
    
    public Cliente consultar(int codigo){
        return exeBanco.buscarCliente(codigo);
    }

    public List<Cliente> consultarTodos(){
        return exeBanco.buscarTodosCliente();
    }    
}