
package modelos;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import utils.Conexao;

public class Carro {
   private int id; 
   private String placa;
   private String marca;
   private String modelo;
   private int km;
   private boolean arcondicionado;
   private boolean direcaoHidraulico;

   public boolean salvar(){
       String sql = "insert into carro(placa,marca,modelo,";
              sql +="km,arcondicionado,direcaoHidraulico)";
              sql += "values(?,?,?,?,?,?)";
       Connection con = Conexao.conectar();
       
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, this.placa);
           stm.setString(2, this.marca);
           stm.setString(3, this.modelo);
           stm.setInt(4, this.km);
           stm.setBoolean(5, this.arcondicionado);
           stm.setBoolean(6, this.direcaoHidraulico);
           stm.execute();           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
           return false;
       }        
       return true;
   }
   
   public boolean alterar(){
       Connection con = Conexao.conectar();
       String sql = "update carro set ";
              sql +="placa = ?,";
              sql +="marca = ?,";
              sql +="modelo = ?,";
              sql +="km = ?,";
              sql +="arcondicionado = ?,";
              sql +="direcaoHidraulico = ? ";
              sql +=" where id = ?";
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, this.placa);
           stm.setString(2, this.marca);
           stm.setString(3, this.modelo);
           stm.setInt(4, this.km);
           stm.setBoolean(5, this.arcondicionado);
           stm.setBoolean(6, this.direcaoHidraulico);
           stm.setInt(7, this.id);
           stm.execute();           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
           return false;
       }        
       return true;
   }
   
   public boolean excluir(){
       Connection con = Conexao.conectar();
       String sql = "delete from carro ";
              sql +=" where id = ?";
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setInt(1, this.id);
           stm.execute();           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
           return false;
       }        
       return true;
   }
   
   public Carro consultar(int id){
      Connection con = Conexao.conectar();
      String sql = "select id, placa, marca, modelo, km,"
              + " arcondicionado, direcaoHidraulico"
              + " from carro where id = ?";
      Carro carro = null;
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setInt(1, id);
           ResultSet rs = stm.executeQuery();
           if(rs.next()){
             carro = new Carro();
             carro.setId(id);
             carro.setPlaca(rs.getString("placa"));
             carro.setMarca(rs.getString("marca"));
             carro.setModelo(rs.getString("modelo"));
             carro.setKm(rs.getInt("km"));
             carro.setArcondicionado(rs.getBoolean("arcondicionado"));
             carro.setDirecaoHidraulico(rs.getBoolean("direcaoHidraulico"));
           }
           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
       }      
     return carro;  
   }
  
   public Carro consultar(String pPlaca){
      Connection con = Conexao.conectar();
      String sql = "select id, placa, marca, modelo, km,"
              + " arcondicionado, direcaoHidraulico"
              + " from carro where placa = ?";
      Carro carro = null;
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, pPlaca);
           ResultSet rs = stm.executeQuery();
           if(rs.next()){
             carro = new Carro();
             carro.setId(id);
             carro.setPlaca(rs.getString("placa"));
             carro.setMarca(rs.getString("marca"));
             carro.setModelo(rs.getString("modelo"));
             carro.setKm(rs.getInt("km"));
             carro.setArcondicionado(rs.getBoolean("arcondicionado"));
             carro.setDirecaoHidraulico(rs.getBoolean("direcaoHidraulico"));
           }
           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
       }      
     return carro;  
   }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", km=" + km + ", arcondicionado=" + arcondicionado + ", direcaoHidraulico=" + direcaoHidraulico + '}';
    }
   
   public List<Carro> consultar(){
      List<Carro> lista = new ArrayList<>();
      
      Connection con = Conexao.conectar();
      String sql = "select id, placa, marca, modelo, km,"
              + " arcondicionado, direcaoHidraulico"
              + " from carro";
      
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           
           while(rs.next()){
             Carro carro = new Carro();
             carro.setId(rs.getInt("id"));
             carro.setPlaca(rs.getString("placa"));
             carro.setMarca(rs.getString("marca"));
             carro.setModelo(rs.getString("modelo"));
             carro.setKm(rs.getInt("km"));
             carro.setArcondicionado(rs.getBoolean("arcondicionado"));
             carro.setDirecaoHidraulico(rs.getBoolean("direcaoHidraulico"));
             
             lista.add(carro);
           }
           
       } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
       }      
       return lista;
   }
   
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public void setArcondicionado(boolean arcondicionado) {
        this.arcondicionado = arcondicionado;
    }

    public boolean isDirecaoHidraulico() {
        return direcaoHidraulico;
    }

    public void setDirecaoHidraulico(boolean direcaoHidraulico) {
        this.direcaoHidraulico = direcaoHidraulico;
    }
}
