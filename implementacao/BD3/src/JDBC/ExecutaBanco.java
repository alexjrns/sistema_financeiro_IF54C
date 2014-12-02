/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import Entidades.Classificacao;
import Entidades.Cliente;
import Entidades.Conta;
import Entidades.Endereco;
import Entidades.Fornecedor;
import Entidades.Lancamento;
import Entidades.Pessoa;
import Entidades.Usuario;
import Entidades.Utilitario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Alex
 */
public class ExecutaBanco {
    private Connection con = Conexao.getConnection();    
    
    public ExecutaBanco(){
        super();
    }
    
    public boolean abreTransacao(){
        String sql = "BEGIN";
        return executaComando(sql);
    }

    public boolean commit(){
        String sql = "COMMIT;";
        return executaComando(sql);
    }

    public boolean rollback(){
        String sql = "ROLLBACK;";
        return executaComando(sql);
    }

    private ResultSet executar(String sql){
        ResultSet resultado = null;
        try{
            PreparedStatement preparador = con.prepareStatement(sql);
            resultado = preparador.executeQuery();        
        } catch(SQLException e){
           System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql); 
        }
        return resultado;
    }    
    
    /* Método genérico que executa um comando no banco(Connection) e retorna um resultSet */
    private ResultSet executaComandoRetorno(String comando){
        try{
            PreparedStatement preparador = con.prepareStatement(comando);
            return preparador.executeQuery();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL: " + e.getMessage() + "\n" + "Comando com erro: " + comando);
            return null;
        }
    }     
    
    /* Método genérico que apenas executa um comando no banco(Connection) e retorna verdadeiro se conseguiu */
    private boolean executaComando(String comando){
        try {
            PreparedStatement preparador = con.prepareStatement(comando);
            preparador.execute();
            preparador.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de execucao de comando: " + e.getMessage() + "\n" + "Comando com erro: " + comando);
            return false;
        }
    }    
    
    public int codAtual(String tabela){
        String sql = "SELECT MAX(cod_"+ tabela +") FROM " + tabela + ";";
        ResultSet resultado = executaComandoRetorno(sql);
        try{
            resultado.next();
            return (resultado.getInt(1) + 1);
        }catch (SQLException e) {
            System.out.println("Erro no comando SQL de obtencao codigo: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
            return 0;
        }
    }
    
    public boolean cadastrar(String tabela, String[][] campos){
        String sql = "INSERT INTO " + tabela + "(";
        for(int i = 0; i < campos.length; i++){
            sql += campos[i][0];
            if(i != (campos.length -1))
                sql += ", ";
        }
        int codg = this.codAtual(tabela);
        sql += ") VALUES (DEFAULT, " + codg + ", ";
        for(int i = 2; i < campos.length; i++){
            sql += "'" + campos[i][1] + "'";
            if(i != (campos.length -1))
                sql += ", ";
        }
        sql += ");";
        return this.executaComando(sql);
    }
    
    public boolean alterar(String tabela, String[][] campos){
        String sql = "UPDATE " + tabela + " SET ";

        /* Varre o Array e adiciona o nome do campo e o valor ao comando SQL*/
        for(int i = 0; i < campos.length; i++){
            sql += campos[i][0];
            sql += " = ";
            sql += "'" + campos[i][1] + "'";
            if(i != (campos.length -1))
                sql += ", ";
        }
        sql += (" WHERE (" + tabela + ".cod_" + tabela + " = " + campos[0][1] + ");"); 
        return executaComando(sql);
    }    
    
    public boolean remover(String tabela, String condicao){
        String sql = "DELETE FROM "+ tabela + " WHERE (" + condicao + ");";
        return executaComando(sql);
    }
    
    public ArrayList<String> buscarTodos(String[] campos, String tabela){
        String sql = "SELECT ";
        for(int i = 0; i < campos.length; i++){
            sql += campos[i];
            if(i != (campos.length -1))
                sql += ", ";			
        }
        sql += " FROM " + tabela;

        ArrayList<String> vet = new ArrayList<>();
        try {
            ResultSet resultado = executaComandoRetorno(sql);
            int cont = 0;
            while(resultado.next()){
                vet.add(resultado.getString(cont));
                cont++;
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
            return null;
        }
        return vet;
    }    

    public Usuario buscarUsuario(int id){
        String sql = "SELECT id_usuario, cod_usuario, des_nome, val_login, val_senha, opt_tesoureiro, opt_desativado FROM usuario WHERE (cod_usuario = ?);";
        Usuario usr = new Usuario();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, id);

            ResultSet resultado = preparador.executeQuery();
            resultado.next();

            usr.setCodUsuario(resultado.getInt("cod_usuario"));
            usr.setNomeUsuario(resultado.getString("des_nome"));
            usr.setLogin(resultado.getString("val_login"));
            usr.setSenha(resultado.getString("val_senha"));
            usr.setTesoureiro(resultado.getString("opt_tesoureiro").equals("Sim"));
            usr.setDesativado(resultado.getString("opt_desativado").equals("Sim"));

            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return usr;
    }
    
    public List<Usuario> buscarTodosUsuarios(){
        String sql = "SELECT id_usuario, cod_usuario, des_nome, val_login, val_senha, opt_tesoureiro, opt_desativado FROM usuario;";
        List<Usuario> lista = new ArrayList<>();
        ResultSet resultado = executar(sql);
        try {
            while(resultado.next()){
                Usuario usr = new Usuario();
                usr.setCodUsuario(resultado.getInt("cod_usuario"));
                usr.setNomeUsuario(resultado.getString("des_nome"));
                usr.setLogin(resultado.getString("val_login"));
                usr.setSenha(resultado.getString("val_senha"));
                usr.setTesoureiro(resultado.getString("opt_tesoureiro").equals("Sim"));
                usr.setDesativado(resultado.getString("opt_desativado").equals("Sim"));
                lista.add(usr);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lista;        
    }
    
    public Usuario autenticar(Usuario usr){
        String sql = "SELECT id_usuario, cod_usuario, des_nome, val_login, val_senha, opt_tesoureiro, opt_desativado FROM usuario WHERE ((val_login = ?) AND (val_senha = ?));";
        try{
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, usr.getLogin());
            preparador.setString(2, Utilitario.md5(usr.getSenha()));
            ResultSet resultado = preparador.executeQuery();
            
            if(resultado.next()){
                int cod = resultado.getInt("cod_usuario");
                String nome = resultado.getString("des_nome");
                String lgn = resultado.getString("val_login");
                String sen = resultado.getString("val_senha");
                boolean tesoureiro = resultado.getString("opt_tesoureiro").equals("Sim");
                boolean desativado = resultado.getString("opt_desativado").equals("Sim");

                return new Usuario(cod, nome, lgn, sen, tesoureiro, desativado);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return null;        
    }    

    public Classificacao buscarClassificacao(int codigo){
        String sql = "SELECT id_classificacao, cod_classificacao, des_classificacao, des_tipooperacao FROM classificacao WHERE (cod_classificacao = ?);";
        Classificacao cla = new Classificacao();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, codigo);

            ResultSet resultado = preparador.executeQuery();
            resultado.next();

            cla.setCodClassificacao(resultado.getInt("cod_classificacao"));
            cla.setDescricao(resultado.getString("des_classificacao"));
            cla.setTipooperacao(resultado.getString("des_tipooperacao"));
            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return cla;
    }    

    public List<Classificacao> buscarTodosClassificacao(){
        String sql = "SELECT id_classificacao, cod_classificacao, des_classificacao, des_tipooperacao FROM classificacao;";
        List<Classificacao> lista = new ArrayList<>();
        ResultSet resultado = executar(sql);
        try {
            while(resultado.next()){
                Classificacao cla = new Classificacao();
                cla.setCodClassificacao(resultado.getInt("cod_classificacao"));
                cla.setDescricao(resultado.getString("des_classificacao"));
                cla.setTipooperacao(resultado.getString("des_tipooperacao"));
                lista.add(cla);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lista;        
    }

    public Conta buscarConta(int codigo){
        String sql = "SELECT id_conta, cod_conta des_conta, val_saldo, val_limitecredito, dat_registro FROM conta WHERE (cod_conta = ?);";
        Conta cnt = new Conta();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, codigo);

            ResultSet resultado = preparador.executeQuery();
            resultado.next();

            cnt.setCodConta(resultado.getInt("cod_conta"));
            cnt.setSaldo(resultado.getDouble("val_saldo"));
            cnt.setLimiteCredito(resultado.getDouble("val_limitecredito"));
            
            java.sql.Date data = new java.sql.Date(resultado.getDate("dat_registro").getTime());
            java.util.Date dtFinal = new java.util.Date(data.getTime()); 
            Calendar cal = Calendar.getInstance();
            cal.setTime(dtFinal);
            cnt.setDataRegistro(cal);

            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return cnt;
    }     
    
    public List<Conta> buscarTodosConta(){
        String sql = "SELECT id_conta, cod_conta des_conta, val_saldo, val_limitecredito, dat_registro FROM conta;";
        List<Conta> lista = new ArrayList<>();
        ResultSet resultado = executar(sql);
        try {
            while(resultado.next()){
                Conta cnt = new Conta();
                cnt.setCodConta(resultado.getInt("cod_conta"));
                cnt.setSaldo(resultado.getDouble("val_saldo"));
                cnt.setLimiteCredito(resultado.getDouble("val_limitecredito"));

                java.sql.Date data = new java.sql.Date(resultado.getDate("dat_registro").getTime());
                java.util.Date dtFinal = new java.util.Date(data.getTime()); 
                Calendar cal = Calendar.getInstance();
                cal.setTime(dtFinal);
                cnt.setDataRegistro(cal);

                lista.add(cnt);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lista;        
    }    

    public Lancamento buscarLancamento(int codigo){
        String sql = "SELECT id_lancamento, cod_lancamento val_numdocumento, dat_lancamento, val_lancamento, val_vinculado, des_origem, fk_conta, fk_classificacao FROM lancamento WHERE (cod_lancamento = ?);";
        Lancamento lnc = new Lancamento();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, codigo);

            ResultSet resultado = preparador.executeQuery();
            resultado.next();

            lnc.setCodLancamento(resultado.getInt("cod_lancamento"));
            lnc.setNumDocumento(resultado.getString("val_numdocumento"));

            java.sql.Date data = new java.sql.Date(resultado.getDate("dat_lancamento").getTime());
            java.util.Date dtFinal = new java.util.Date(data.getTime()); 
            Calendar cal = Calendar.getInstance();
            cal.setTime(dtFinal);
            lnc.setDataLancamento(cal);
            
            lnc.setValor(resultado.getDouble("val_lancamento"));
            lnc.setValorVinculado(resultado.getDouble("val_vinculado"));
            lnc.setOrigem(resultado.getString("des_origem"));
            lnc.setContaBancaria(this.buscarConta(resultado.getInt("fk_conta")));
            lnc.setClassificacao(this.buscarClassificacao(resultado.getInt("fk_classificacao")));

            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lnc;
    }     

    public List<Lancamento> buscarTodosLancamento(){
        String sql = "SELECT id_lancamento, cod_lancamento val_numdocumento, dat_lancamento, val_lancamento, val_vinculado, des_origem, fk_conta, fk_classificacao FROM lancamento;";
        List<Lancamento> lista = new ArrayList<>();
        ResultSet resultado = executar(sql);
        try {
            while(resultado.next()){
                Lancamento lnc = new Lancamento();
                lnc.setCodLancamento(resultado.getInt("cod_lancamento"));
                lnc.setNumDocumento(resultado.getString("val_numdocumento"));

                java.sql.Date data = new java.sql.Date(resultado.getDate("dat_lancamento").getTime());
                java.util.Date dtFinal = new java.util.Date(data.getTime()); 
                Calendar cal = Calendar.getInstance();
                cal.setTime(dtFinal);
                lnc.setDataLancamento(cal);

                lnc.setValor(resultado.getDouble("val_lancamento"));
                lnc.setValorVinculado(resultado.getDouble("val_vinculado"));
                lnc.setOrigem(resultado.getString("des_origem"));
                lnc.setContaBancaria(this.buscarConta(resultado.getInt("fk_conta")));
                lnc.setClassificacao(this.buscarClassificacao(resultado.getInt("fk_classificacao")));

                lista.add(lnc);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lista;        
    }     

    public Endereco buscarEndereco(int codigo){
        String sql = "SELECT id_endereco, cod_endereco, des_logradouro, des_numero, val_cep, des_bairro, des_cidade, des_estado FROM endereco WHERE (cod_endereco = ?);";
        Endereco end = new Endereco();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, codigo);

            ResultSet resultado = preparador.executeQuery();
            resultado.next();

            end.setCodEndereco(resultado.getInt("cod_endereco"));
            end.setNumero(resultado.getString("des_numero"));
            end.setCep(resultado.getString("val_cep"));
            end.setBairro(resultado.getString("des_bairro"));
            end.setCidade(resultado.getString("des_cidade"));
            end.setEstado(resultado.getString("des_estado"));
 
            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return end;
    }      

    public List<Endereco> buscarTodosEndereco(){
        String sql = "SELECT id_endereco, cod_endereco, des_logradouro, des_numero, val_cep, des_bairro, des_cidade, des_estado FROM endereco;";
        List<Endereco> lista = new ArrayList<>();
        ResultSet resultado = executar(sql);
        try {
            while(resultado.next()){
                Endereco end = new Endereco();
                end.setCodEndereco(resultado.getInt("cod_endereco"));
                end.setNumero(resultado.getString("des_numero"));
                end.setCep(resultado.getString("val_cep"));
                end.setBairro(resultado.getString("des_bairro"));
                end.setCidade(resultado.getString("des_cidade"));
                end.setEstado(resultado.getString("des_estado"));

                lista.add(end);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lista;        
    }
    
    public Pessoa buscarPessoa(int codigo){
        String sql = "SELECT id_pessoa, cod_pessoa, des_nome, val_documento, val_telefone, fk_endereco FROM pessoa WHERE (cod_pessoa = ?);";
        Pessoa pes = new Pessoa();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, codigo);

            ResultSet resultado = preparador.executeQuery();
            resultado.next();

            pes.setChave(resultado.getInt("id_pessoa"));
            pes.setCodPessoa(resultado.getInt("cod_pessoa"));
            pes.setNome(resultado.getString("des_numero"));
            pes.setTelefone(resultado.getString("val_telefone"));
            pes.setEndereco(this.buscarEndereco(resultado.getInt("fk_endereco")));

            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return pes;
    }
    
    public List<Pessoa> buscarTodosPessoa(){
        String sql = "SELECT id_pessoa, cod_pessoa, des_nome, val_documento, val_telefone, fk_endereco FROM pessoa;";
        List<Pessoa> lista = new ArrayList<>();
        ResultSet resultado = executar(sql);
        try {
            while(resultado.next()){
                Pessoa pes = new Pessoa();
                pes.setChave(resultado.getInt("id_pessoa"));
                pes.setCodPessoa(resultado.getInt("cod_pessoa"));
                pes.setNome(resultado.getString("des_numero"));
                pes.setTelefone(resultado.getString("val_telefone"));
                pes.setEndereco(this.buscarEndereco(resultado.getInt("fk_endereco")));

                lista.add(pes);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lista;        
    }    

    public Cliente buscarCliente(int codigo){
        String sql = "SELECT id_cliente, cod_cliente, fk_pessoa FROM cliente WHERE (cod_cliente = ?);";
        Cliente cli = new Cliente();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, codigo);

            ResultSet resultado = preparador.executeQuery();
            resultado.next();

            cli.setCodCliente(resultado.getInt("cod_cliente"));
            cli.setPessoa(this.buscarPessoa(resultado.getInt("fk_pessoa")));

            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return cli;
    }    

    public List<Cliente> buscarTodosCliente(){
        String sql = "SELECT id_cliente, cod_cliente, fk_pessoa FROM cliente;";
        List<Cliente> lista = new ArrayList<>();
        ResultSet resultado = executar(sql);
        try {
            while(resultado.next()){
                Cliente cli = new Cliente();
                cli.setCodCliente(resultado.getInt("cod_cliente"));
                cli.setPessoa(this.buscarPessoa(resultado.getInt("fk_pessoa")));

                lista.add(cli);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lista;        
    }
    
    public Fornecedor buscarFornecedor(int codigo){
        String sql = "SELECT id_fornecedor, cod_fornecedor, fk_pessoa FROM fornecedor (cod_fornecedor = ?);";
        Fornecedor frn = new Fornecedor();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, codigo);

            ResultSet resultado = preparador.executeQuery();
            resultado.next();

            frn.setCodFornecedor(resultado.getInt("cod_fornecedor"));
            frn.setPessoa(this.buscarPessoa(resultado.getInt("fk_pessoa")));

            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return frn;
    }    

    public List<Fornecedor> buscarTodosFornecedor(){
        String sql = "SELECT id_fornecedor, cod_fornecedor, fk_pessoa FROM fornecedor;";
        List<Fornecedor> lista = new ArrayList<>();
        ResultSet resultado = executar(sql);
        try {
            while(resultado.next()){
                Fornecedor frn = new Fornecedor();
                frn.setCodFornecedor(resultado.getInt("cod_fornecedor"));
                frn.setPessoa(this.buscarPessoa(resultado.getInt("fk_pessoa")));

                lista.add(frn);
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL de Consulta: " + e.getMessage() + "\n" + "Comando com erro: " + sql);
        }
        return lista;        
    }    
    
}
