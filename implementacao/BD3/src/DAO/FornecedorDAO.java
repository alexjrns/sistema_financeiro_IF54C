/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Fornecedor;
import JDBC.ExecutaBanco;

/**
 *
 * @author Mamao
 */
public class FornecedorDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public FornecedorDAO() {
        super();
    }
    
    public boolean cadastrar(Fornecedor fornecedor){
        PessoaDAO pessoa = new PessoaDAO();
                
        String[][] vetFornecedor = { {"id_fornecedor", ""}, {"cod_fornecedor", ""}, {"fk_pessoa", ""} };
        
        pessoa.cadastrar(fornecedor.getPessoa());

        return exeBanco.cadastrar("fornecedor", vetFornecedor);
    }
}
