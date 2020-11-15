/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Conexao;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String numeroCartao;
    
    
    
    public boolean salvar(){
       String sql = "insert into cliente(cpf,email,nome, numeroCartao)";
                  sql += "values(?,?,?,?)";
       Connection con = Conexao.conectar();
       
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, this.cpf);
           stm.setString(2, this.email);
           stm.setString(3, this.nome);
           stm.setString(4, this.numeroCartao);
           
           stm.execute();           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
           return false;
       }        
       return true;
   }

    public boolean alterar(){
       Connection con = Conexao.conectar();
       String sql = "update cliente set ";
              sql +="nome = ?,";
              sql +="email = ?,";
              sql +="numeroCartao = ?";
              sql +=" where cpf = ?";
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, this.nome);
           stm.setString(2, this.email);
           stm.setString(3, this.numeroCartao);
           stm.setString(4, this.cpf);
           
           stm.execute();           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
           return false;
       }        
       return true;
   } 
    
    
    public Cliente consultar(String pCpf){
      Connection con = Conexao.conectar();
      String sql = "select cpf, nome, email, numeroCartao"
                 + " from cliente where cpf = ?";
      Cliente cliente = null;
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, pCpf);
           ResultSet rs = stm.executeQuery();
           if(rs.next()){
             cliente = new Cliente();
             cliente.setCpf(pCpf);
             cliente.setNome(rs.getString("nome"));
             cliente.setEmail(rs.getString("email"));
             cliente.setNumeroCartao(rs.getString("numeroCartao"));            
           }
           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
       }      
     return cliente;  
   }  

    public List<Cliente> consultar(){
      Connection con = Conexao.conectar();
      String sql = "select cpf, nome, email, numeroCartao from cliente";
      Cliente cliente = null;
      List<Cliente> lista = new ArrayList<>();
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
             cliente = new Cliente();
             cliente.setCpf(rs.getString("cpf"));
             cliente.setNome(rs.getString("nome"));
             cliente.setEmail(rs.getString("email"));
             cliente.setNumeroCartao(rs.getString("numeroCartao")); 
             
             lista.add(cliente);
           }
           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
       }      
     return lista;  
   }  
    
    public boolean excluir(){
       Connection con = Conexao.conectar();
       String sql = "delete from cliente ";
              sql +=" where cpf = ?";
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, this.cpf);
           stm.execute();           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
           return false;
       }        
       return true;
   }
  
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
   
}
