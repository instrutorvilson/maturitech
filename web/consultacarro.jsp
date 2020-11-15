<%-- 
    Document   : consultacarro
    Created on : 30 de out de 2020, 08:35:53
    Author     : entra21
--%>

<%@page import="java.util.List"%>
<%@page import="modelos.Carro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consulta carro</h1>
        <hr />
        <%
          Carro carro = new Carro();
          List<Carro> carros = carro.consultar();
        %>
        <table>
            <thead>
              <th>Id</th>
              <th>Placa</th>
              <th>Marca</th>
              <th>Modelo</th>
              <th>Km</th>
              <th>Tem Ar condicionado?</th>
              <th>Tem direçaõ hidráulica</th>
              <th> Editar </th>
              <th> Excluir </th>
            </thead>
            <tbody>
                <% for(Carro c : carros) {%>
                   <tr>
                       <td><% out.write(""+c.getId()); %></td>
                        <td><% out.write(c.getPlaca()); %></td>
                        <td><% out.write(c.getMarca()); %></td>
                        <td><% out.write(c.getModelo()); %></td>
                        <td><% out.write(""+c.getKm()); %></td>

                        <% if(c.isArcondicionado()){%>
                            <td>sim</td>
                        <%}else{%>        
                             <td>Não</td>
                        <%}%>
                        <!-- Valida direção hidraulica-->
                         <%
                           if(c.isDirecaoHidraulico()){
                              out.write("<td>Sim</td>");
                           }
                           else{
                             out.write("<td>Não</td>");  
                           }                       
                         %>  
                         <td><%out.write("<a href=editarcarro.jsp?idcarro="+c.getId()+">Editar</a>");%></td> 
                         <td><%out.write("<a href=excluircarro.jsp?idcarro="+c.getId()+">Excluir</a>");%></td>                         
                   </tr> 
                   
                <%}%>
            </tbody>
        </table>
    </body>
</html>
