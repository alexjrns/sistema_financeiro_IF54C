/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;

import JDBC.ExecutaBanco;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Mamao
 */
public class ClienteDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public ClienteDAO() {
        super();
    }
    
    public boolean salvar(Cliente cliente){
        int codg = exeBanco.codAtual("cliente");		
        if((cliente.getCodCliente() != 0) && (cliente.getCodCliente() < codg))
            return alterar(cliente);
        else
            return cadastrar(cliente);
    }       
    
    public boolean cadastrar(Cliente cliente){
        PessoaDAO pesDAO = new PessoaDAO();
        exeBanco.abreTransacao();
        if(pesDAO.cadastrar(cliente.getPessoa())){

            String pessoa = String.valueOf(exeBanco.buscarPessoa(cliente.getPessoa().getCodPessoa()).getChave());
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
            String[][] vetCliente = { {"cod_cliente", codCliente}, {"fk_pessoa", pessoa} };
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
        String codPessoa = String.valueOf(cliente.getPessoa().getCodPessoa());
        exeBanco.abreTransacao();
        if(exeBanco.remover("cliente", ("cliente.cod_cliente = " + codigo))){
            exeBanco.abreTransacao();
            if(exeBanco.remover("pessoa", ("pessoa.cod_pessoa = " + codPessoa))){
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
    
    public Cliente consultar(int codigo){
        return exeBanco.buscarCliente(codigo);
    }
    
    public TableModel consultarTodosTable(){
        return exeBanco.consultarClientes();
    }    

    public List<Cliente> consultarTodos(){
        return exeBanco.buscarTodosCliente();
    }    
}