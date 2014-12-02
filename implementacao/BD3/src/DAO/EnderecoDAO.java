/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Endereco;
import JDBC.ExecutaBanco;
import java.util.List;

/**
 *
 * @author Mamao
 */
public class EnderecoDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public EnderecoDAO() {
        super();
    }
    
    public boolean cadastrar(Endereco endereco){
        String logradouro = endereco.getLogradouro();
        String numero = endereco.getNumero();
        String cep = endereco.getCep();
        String bairro = endereco.getBairro();
        String cidade = endereco.getCidade();
        String estado = endereco.getEstado();

        String[][] vetEndereco = { {"id_endereco", ""}, {"cod_endereco", ""}, {"des_logradouro", logradouro}, {"des_numero", numero}, 
            {"val_cep", cep}, {"des_bairro", bairro}, {"des_cidade", cidade}, {"des_estado", estado} };

        return exeBanco.cadastrar("endereco", vetEndereco);
    }
    
    public boolean alterar(Endereco endereco){
        String codigo = String.valueOf(endereco.getCodEndereco());
        String logradouro = endereco.getLogradouro();
        String numero = endereco.getNumero();
        String cep = endereco.getCep();
        String bairro = endereco.getBairro();
        String cidade = endereco.getCidade();
        String estado = endereco.getEstado();

        String[][] vetEndereco = { {"id_endereco", ""}, {"cod_endereco", codigo}, {"des_logradouro", logradouro}, {"des_numero", numero}, 
            {"val_cep", cep}, {"des_bairro", bairro}, {"des_cidade", cidade}, {"des_estado", estado} };

        return exeBanco.alterar("endereco", vetEndereco);        
    }
    
    public boolean remover(Endereco endereco){
        String codigo = String.valueOf(endereco.getCodEndereco());
        return exeBanco.remover("endereco", ("endereco.cod_endereco = " + codigo));
    }
    
    public Endereco consultar(int codigo){
        return exeBanco.buscarEndereco(codigo);
    }
    
    public List<Endereco> consultarTodos(){
        return exeBanco.buscarTodosEndereco();
    }    
}
