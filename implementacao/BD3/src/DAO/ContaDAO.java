/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Conta;
import JDBC.ExecutaBanco;
import java.util.List;

public class ContaDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public ContaDAO(){
        super();
    }
    
    public boolean cadastrar(Conta conta){
	String descricao = conta.getDescricao();
        String saldo = String.valueOf(conta.getSaldo());
        String limiteCredito = String.valueOf(conta.getLimiteCredito());
        java.sql.Date dtaRegistro = new java.sql.Date(conta.getDataRegistro().getTimeInMillis());
        String dataRegistro = String.valueOf(dtaRegistro);

        String[][] vetConta = { {"id_conta", ""}, {"cod_conta", ""}, {"des_conta", descricao}, {"val_saldo", saldo}, {"val_limitecredito", limiteCredito} , {"dat_registro", dataRegistro} };
        return exeBanco.cadastrar("conta", vetConta);
    }
    
    public boolean alterar(Conta conta){
	String codigo = String.valueOf(conta.getCodConta());
        String descricao = conta.getDescricao();
        String saldo = String.valueOf(conta.getSaldo());
        String limiteCredito = String.valueOf(conta.getLimiteCredito());
        java.sql.Date dtaRegistro = new java.sql.Date(conta.getDataRegistro().getTimeInMillis());
        String dataRegistro = String.valueOf(dtaRegistro);

        String[][] vetConta = { {"id_conta", ""}, {"cod_conta", codigo}, {"des_conta", descricao}, {"val_saldo", saldo}, {"val_limitecredito", limiteCredito} , {"dat_registro", dataRegistro} };
        return exeBanco.alterar("conta", vetConta);
    }
    
    public boolean remover(Conta conta){
        String codigo = String.valueOf(conta.getCodConta());
        return exeBanco.remover("conta", ("conta.cod_conta = " + codigo));
    }
    
    public Conta consultar(int codigo){
        return exeBanco.buscarConta(codigo);
    }
    
    public List<Conta> consultarTodos(){
        return exeBanco.buscarTodosConta();
    }    
}
