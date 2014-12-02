/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import Entidades.Utilitario;
import JDBC.ExecutaBanco;
import java.util.List;

/**
 *
 * @author Alex
 */
public class UsuarioDAO {
    private ExecutaBanco exeBanco = new ExecutaBanco();
    
    public UsuarioDAO(){
        super();
    }
    
    public Usuario autenticar(Usuario usuario){
        return exeBanco.autenticar(usuario);        
    }
    
    public boolean cadastrar(Usuario usuario){
	String nome = usuario.getNomeUsuario();
        String login = usuario.getLogin();
        String senha = Utilitario.md5(usuario.getSenha());
        String tesoureiro = usuario.isTesoureiro() ? "Sim" : "Nao";
        String desativado = usuario.isDesativado()? "Sim" : "Nao";
        String[][] vet = { {"id_usuario", ""}, {"cod_usuario", ""}, {"des_nome", nome}, {"val_login", login} , {"val_senha", senha}, {"opt_tesoureiro", tesoureiro}, {"opt_desativado", desativado} };
        return exeBanco.cadastrar("usuario", vet);
    }
    
    public boolean alterar(Usuario usuario){
        String codigo = String.valueOf(usuario.getCodUsuario());
        String nome = usuario.getNomeUsuario();
        String login = usuario.getLogin();
        String senha = Utilitario.md5(usuario.getSenha());
        String tesoureiro = usuario.isTesoureiro() ? "Sim" : "Nao";
        String desativado = usuario.isDesativado()? "Sim" : "Nao";
        String[][] vet = { {"id_usuario", ""}, {"cod_usuario", codigo}, {"des_nome", nome}, {"val_login", login} , {"val_senha", senha}, {"opt_tesoureiro", tesoureiro}, {"opt_desativado", desativado} };
        return exeBanco.alterar("usuario", vet);
    }

    public boolean remover(Usuario usuario){
        String codigo = String.valueOf(usuario.getCodUsuario());
        return exeBanco.remover("usuario", ("usuario.cod_usuario = " + codigo));
    }

    public Usuario consultar(int codigo){
        return exeBanco.buscarUsuario(codigo);
    }

    public List<Usuario> consultarTodos(){
        return exeBanco.buscarTodosUsuarios();
    }
}
