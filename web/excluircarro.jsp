<%-- 
    Document   : excluircarro
    Created on : 9 de nov de 2020, 09:37:56
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
        
        <h1>Hello World!</h1>
        <%
          String idcarro = request.getParameter("idcarro");
          Carro c = new Carro();
          if (idcarro != null){
              c = c.consultar(Integer.parseInt(idcarro));
              if(c.excluir()){
              out.write("Carro excluído com sucesso");
          }
          else
          {
              out.write("Problemas ao excluir carro");
          }
          }          
        %>
        <hr />
       <a href="consultacarro.jsp">Consulta carros</a> 
              
    </body>
</html>
