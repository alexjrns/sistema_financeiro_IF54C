/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Mamao
 */
public class Usuario {
    private int codUsuario;
    private String nomeUsuario;
    private String login;
    private String senha;
    private boolean tesoureiro;
    private boolean desativado;

    public Usuario() {
    }

    public Usuario(int codUsuario, String nomeUsuario, String login, String senha, boolean tesoureiro, boolean desativado) {
        this.codUsuario = codUsuario;
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.tesoureiro = tesoureiro;
        this.desativado = desativado;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isTesoureiro() {
        return tesoureiro;
    }

    public void setTesoureiro(boolean tesoureiro) {
        this.tesoureiro = tesoureiro;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }
}
