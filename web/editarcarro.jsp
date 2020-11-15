<%-- 
    Document   : editarcarro
    Created on : 6 de nov de 2020, 08:36:18
    Author     : entra21
--%>

<%@page import="modelos.Carro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar carros</title>
    </head>
    <body>
        <h1>Ediçâo de carros</h1>
        <hr />
        <%
          String idcarro = request.getParameter("idcarro");
          Carro c = new Carro();
          if (idcarro != null){
              c = c.consultar(Integer.parseInt(idcarro));
          }    
        %>
        <form action="recebeeditacarro.jsp" method="POST">
            <label> Id Carro </label>
            <input type="text" name="idcarro" 
                   readonly="true"
                   value="<%out.write(""+c.getId());%>"/>
            <br />
            <label>Placa</label>
            <input type="text" name="placa" 
                   value="<%out.write(c.getPlaca());%>" />
            <br />
            <label>Marca</label>
            <input type="text" name="marca" 
                   value="<%out.write(c.getMarca());%>" />
            <br />
            <label>Modelo</label>
            <input type="text" name="modelo" 
                   value="<%out.write(c.getModelo());%>" />
            
            <br />
            <label>KM</label>
            <input type="text" name="km" 
                   value="<%out.write(""+c.getKm());%>" />
            <br />
            <input type="checkbox" 
                   name="arcondicionado" 
                   checked="<%
                          if (c.isArcondicionado()){
                            out.write("True");
                          }
                       %>" >Ar condicionado?  </input> 
            <br />
            <input type="checkbox" 
                   name="direcaohidraulica" 
                   checked="<%
                          if (c.isDirecaoHidraulico()){
                            out.write("True");
                          }
                       %>"
                     >Direçaõ hidraulica? </input> 
            <hr />
            <input type="submit" value="Alterar" />
        </form>
    </body>
</html>
