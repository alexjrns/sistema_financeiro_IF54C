/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Titulo;
import JDBC.ExecutaBanco;


public class TituloDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public TituloDAO(){
        super();
    }
    
    public boolean cadastrar(Titulo titulo){
        String identificacao = titulo.getIdentificacao();
        java.sql.Date dtaEmissao = new java.sql.Date(titulo.getEmissao().getTimeInMillis());
        String dataEmissao = String.valueOf(dtaEmissao);
        java.sql.Date dtaVencimento = new java.sql.Date(titulo.getVencimento().getTimeInMillis());
        String dataVencimento = String.valueOf(dtaVencimento);
        String valorTitulo = String.valueOf(titulo.getValorTitulo());
        String observacao = titulo.getObservacao();
        String tipo = titulo.getTipo();
        String classificacao = String.valueOf(titulo.getClassificacao().getCodClassificacao());
        String pessoa = String.valueOf(titulo.getPessoa().getCodPessoa());
        
        String[][] vet = { {"id_titulos", ""}, {"cod_titulos", ""}, {"des_identicacao", identificacao}, {"dat_emissao", dataEmissao} , {"dat_vencimento", dataVencimento}, {"val_titulo", valorTitulo}, {"des_observacao", observacao}, {"opt_tipo", tipo}, {"fk_classificacao", classificacao}, {"fk_pessoa", pessoa} };
        return exeBanco.cadastrar("titulos", vet);
    }
}
