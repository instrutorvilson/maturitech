/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;
import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author entra21
 */
public class Locacao {
  private int id;
  private Date datadevolucao;
  private int idcarro;
  private String cpfcliente;
  private Date dataretirada;
  private Date data;  

  public ResultSet consultarInner(){
      Connection con = Conexao.conectar();
      ResultSet rs = null;
      String sql = "select lo.id, lo.idcarro, ca.placa,"+
                 "ca.modelo,lo.cpfcliente,cli.nome, lo.data," +
                "lo.dataretirada, lo.datadevolucao " +
                "from locacao lo, cliente cli, carro ca " +
                "where lo.idcarro = ca.id " +
                "and lo.cpfcliente = cli.cpf";
      try {
          PreparedStatement stm = con.prepareStatement(sql);
          rs = stm.executeQuery();                 
      } catch (SQLException ex) {
         // 
      }
      return rs;
  }
  
  public List<Locacao> consultar(){
      List<Locacao> lista = new ArrayList<>();
      Connection con = Conexao.conectar();
      String sql = "select id, cpfcliente,idcarro,data, dataretirada, datadevolucao";
              sql += " from locacao ";     
              
      try {
          PreparedStatement stm = con.prepareStatement(sql);
          ResultSet rs = stm.executeQuery();
          while(rs.next()){
             Locacao lo = new Locacao();
             lo.setId(rs.getInt("id"));
             lo.setIdcarro(rs.getInt("idcarro"));
             lo.setCpfcliente(rs.getString("cpfcliente"));
             lo.setData(rs.getDate("data"));
             lo.setDataretirada(rs.getDate("dataretirada"));
             lo.setDatadevolucao(rs.getDate("datadevolucao"));
             lista.add(lo);
          }
      } catch (SQLException ex) {
          System.out.println("Erro: " + ex.getMessage());
      }     
      return lista;
  }
    public boolean salvar(){
        Connection con = Conexao.conectar();
        String sql = "insert into locacao(idcarro,cpfcliente,dataretirada,data)";
               sql += "values(?,?,?,?)";
      try {
          PreparedStatement stm = con.prepareStatement(sql);
          stm.setInt(1, this.idcarro);
          stm.setString(2, this.cpfcliente);
          stm.setDate(3, this.dataretirada);
          stm.setDate(4, this.data);
          
          stm.execute();
      } catch (SQLException ex) {
          System.out.println("Erro: " + ex.getMessage());
      }
        return true;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(Date datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    public int getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(int idcarro) {
        this.idcarro = idcarro;
    }

  
    public Date getDataretirada() {
        return dataretirada;
    }

    public void setDataretirada(Date dataretirada) {
        this.dataretirada = dataretirada;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }
 
}
