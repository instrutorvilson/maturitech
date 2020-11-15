<%-- 
    Document   : recebeDadosCarro
    Created on : 30 de out de 2020, 09:08:39
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
        <h1>Locacar</h1>
        <%
          //recebe os valores da tela HTML  
          String placa = request.getParameter("placa");
          String marca = request.getParameter("marca");
          String modelo = request.getParameter("modelo");
          String km = request.getParameter("km");
          String arcondicionado = request.getParameter("arcondicionado");
          String direcaohidraulico = request.getParameter("direcaohidraulica");
          
          //instancia o carro
          Carro carro = new Carro();
          carro.setPlaca(placa);
          carro.setModelo(modelo);
          carro.setMarca(marca);
          
          if(!km.equals(""))
             carro.setKm(Integer.parseInt(km));            
         
          if (arcondicionado != null)
             carro.setArcondicionado(true);
          
          if(direcaohidraulico != null)
            carro.setDirecaoHidraulico(true);
          
          if(carro.salvar()){
              out.write("Carro salvo com sucesso");
          }
          else
          {
              out.write("Problemas ao salvar carro");
          }
          
        %>
    </body>
</html>
