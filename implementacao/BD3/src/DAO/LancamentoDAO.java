/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Lancamento;
import JDBC.ExecutaBanco;
import java.util.List;

/**
 *
 * @author Mamao
 */
public class LancamentoDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public LancamentoDAO() {
        super();
    }
    
    public boolean cadastrar(Lancamento lancamento){
        String numDocumento = lancamento.getNumDocumento();
        java.sql.Date dtaLancamento = new java.sql.Date(lancamento.getDataLancamento().getTimeInMillis());
        String dataLancamento = String.valueOf(dtaLancamento);
        String valor = String.valueOf(lancamento.getValor());
        String valorVinculado = String.valueOf(lancamento.getValorVinculado());
        String origem = lancamento.getOrigem();

        String classificacao = String.valueOf(lancamento.getClassificacao().getCodClassificacao());
        String conta = String.valueOf(lancamento.getContaBancaria().getCodConta());

        String[][] vetLancamento = { {"id_lancamento", ""}, {"val_numdocumento", numDocumento}, {"dat_lancamento", dataLancamento}, {"val_lancamento", valor}, {"val_vinculado", valorVinculado}, {"des_origem", origem}, {"fk_conta", conta}, {"fk_classificacao", classificacao} };
        return exeBanco.cadastrar("lancamento", vetLancamento);
    }
    
    public boolean alterar(Lancamento lancamento){
        String numDocumento = lancamento.getNumDocumento();
        java.sql.Date dtaLancamento = new java.sql.Date(lancamento.getDataLancamento().getTimeInMillis());
        String dataLancamento = String.valueOf(dtaLancamento);
        String valor = String.valueOf(lancamento.getValor());
        String valorVinculado = String.valueOf(lancamento.getValorVinculado());
        String origem = lancamento.getOrigem();

        String classificacao = String.valueOf(lancamento.getClassificacao().getCodClassificacao());
        String conta = String.valueOf(lancamento.getContaBancaria().getCodConta());

        String[][] vetLancamento = { {"id_lancamento", ""}, {"val_numdocumento", numDocumento}, {"dat_lancamento", dataLancamento}, {"val_lancamento", valor}, {"val_vinculado", valorVinculado}, {"des_origem", origem}, {"fk_conta", conta}, {"fk_classificacao", classificacao} };
        return exeBanco.alterar("lancamento", vetLancamento);
    }    
    
    public boolean remover(Lancamento lancamento){
        String codigo = String.valueOf(lancamento.getCodLancamento());
        return exeBanco.remover("lancamento", ("lancamento.cod_lancamento = " + codigo));
    }
    
    public Lancamento consultar(int codigo){
        return exeBanco.buscarLancamento(codigo);
    }
    
    public List<Lancamento> consultarTodos(){
        return exeBanco.buscarTodosLancamento();
    }    
}
