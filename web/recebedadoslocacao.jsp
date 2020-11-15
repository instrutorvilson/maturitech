<%-- 
    Document   : recebedadoslocacao
    Created on : 11 de nov de 2020, 08:31:12
    Author     : entra21
--%>

<%@page import="java.sql.Date"%>
<%@page import="modelos.Locacao"%>
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
          String cpfcliente = request.getParameter("cpfcliente");
          String dataretirada = request.getParameter("dataretirada");
          
         Locacao locacao = new Locacao();
         locacao.setIdcarro(Integer.parseInt(idcarro));
         locacao.setCpfcliente(cpfcliente);
         locacao.setData(Date.valueOf(dataretirada));
         locacao.setDataretirada(Date.valueOf(dataretirada));
         
         if(locacao.salvar()){
             out.write("Locação registrada com sucesso");
         }

        %>
    </body>
</html>
