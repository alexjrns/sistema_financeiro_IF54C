/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entidades.Classificacao;
import JDBC.ExecutaBanco;
import java.util.List;

/**
 *
 * @author Alex
 */
public class ClassificacaoDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    public ClassificacaoDAO(){
        super();
    }

    public boolean cadastrar(Classificacao classificacao){
        String descricao = classificacao.getDescricao();
        String tipoOperacao = classificacao.getTipooperacao();

        String[][] vet = { {"id_classificacao", ""}, {"cod_classificacao", ""}, {"des_classificacao", descricao}, {"des_tipooperacao", tipoOperacao} };
        return exeBanco.cadastrar("classificacao", vet);        
    }

    public boolean alterar(Classificacao classificacao){
        String codigo = String.valueOf(classificacao.getCodClassificacao());
        String descricao = classificacao.getDescricao();
        String tipoOperacao = classificacao.getTipooperacao();

        String[][] vet = { {"id_classificacao", ""}, {"cod_classificacao", codigo}, {"des_classificacao", descricao}, {"des_tipooperacao", tipoOperacao} };
        return exeBanco.alterar("classificacao", vet);
    }

    public boolean remover(Classificacao classificacao){
        String codigo = String.valueOf(classificacao.getCodClassificacao());
        return exeBanco.remover("classificacao", ("cod_classificacao = " + codigo));
    }
    
    public Classificacao consultar(int codigo){
        return exeBanco.buscarClassificacao(codigo);
    }
    
    public List<Classificacao> consultarTodos(){
        return exeBanco.buscarTodosClassificacao();
    }    
}
