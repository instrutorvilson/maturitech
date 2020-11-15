<%-- 
    Document   : recebeeditacarro
    Created on : 6 de nov de 2020, 09:36:20
    Author     : entra21
--%>

<%@page import="modelos.Carro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carro editado</h1>
        <hr />
        <%
        //recebe os valores da tela HTML  
          String idcarro = request.getParameter("idcarro");
          String placa = request.getParameter("placa");
          String marca = request.getParameter("marca");
          String modelo = request.getParameter("modelo");
          String km = request.getParameter("km");
          String arcondicionado = request.getParameter("arcondicionado");
          String direcaohidraulico = request.getParameter("direcaohidraulica");
          
          //instancia o carro
          Carro carro = new Carro();
          carro.setId(Integer.parseInt(idcarro));
          carro.setPlaca(placa);
          carro.setModelo(modelo);
          carro.setMarca(marca);
          
          if(!km.equals(""))
             carro.setKm(Integer.parseInt(km));            
         
          if (arcondicionado != null)
             carro.setArcondicionado(true);
          
          if(direcaohidraulico != null)
            carro.setDirecaoHidraulico(true);
          
          if(carro.alterar()){
              out.write("Carro alterado com sucesso");
          }
          else
          {
              out.write("Problemas ao salvar carro");
          }
          
        %>        
       <hr />
       <a href="consultacarro.jsp">Consulta carros</a> 
        
    </body>
</html>
