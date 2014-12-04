/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Fornecedor;
import JDBC.ExecutaBanco;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Mamao
 */
public class FornecedorDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public FornecedorDAO() {
        super();
    }
    
    public boolean salvar(Fornecedor fornecedor){
        int codg = exeBanco.codAtual("fornecedor");		
        if((fornecedor.getCodFornecedor()!= 0) && (fornecedor.getCodFornecedor()< codg))
            return alterar(fornecedor);
        else
            return cadastrar(fornecedor);
    }    

    public boolean cadastrar(Fornecedor fornecedor){
        PessoaDAO pesDAO = new PessoaDAO();
        exeBanco.abreTransacao();
        if(pesDAO.cadastrar(fornecedor.getPessoa())){
            String pessoa = String.valueOf(exeBanco.buscarPessoa(fornecedor.getPessoa().getCodPessoa()).getChave());
            String[][] vetFornecedor = { {"id_fornecedor", ""}, {"cod_fornecedor", ""}, {"fk_pessoa", pessoa} };
            if(exeBanco.cadastrar("fornecedor", vetFornecedor)){
                return exeBanco.commit();
            } else{
                exeBanco.rollback();
                return false;
            }
        } else return false;
    }
    
    public boolean alterar(Fornecedor fornecedor){
        String codigo = String.valueOf(fornecedor.getCodFornecedor());
        String pessoa = String.valueOf(fornecedor.getPessoa().getChave());
        String[][] vetFornecedor = { {"id_fornecedor", ""}, {"cod_fornecedor", codigo}, {"fk_pessoa", pessoa} };
        
        return exeBanco.alterar("fornecedor", vetFornecedor);
    }
    
    public boolean remover(Fornecedor fornecedor){
        String codigo = String.valueOf(fornecedor.getCodFornecedor());
        return exeBanco.remover("fornecedor", ("fornecedor.cod_fornecedor = " + codigo));
    }
    
    public Fornecedor consultar(int codigo){
        return exeBanco.buscarFornecedor(codigo);
    }

    public List<Fornecedor> consultarTodos(){
        return exeBanco.buscarTodosFornecedor();
    }
    
    public TableModel consultarTodosTable(){
        return exeBanco.consultarFornecedores();
    }    
}
