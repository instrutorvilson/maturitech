<%-- 
    Document   : consultalocacao
    Created on : 15/11/2020, 12:42:52
    Author     : User
--%>

<%@page import="java.util.List"%>
<%@page import="modelos.Locacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           Locacao locacao = new Locacao();
           List<Locacao> locacoes = locacao.consultar();
        %>
        <h1>Consulta locações</h1>
        <hr />
        <table>
            <thead>
               <th>id</th>
               <th>Carro</th>
               <th>Cliente</th>
               <th>Data</th>
               <th>Data retirada</th>
               <th>Data devolução</th>
            </thead>
            <tbody>
               <% for(Locacao lo : locacoes){ %> 
               <tr>
                   <td><%out.write(""+lo.getId());%></td>
                   <td><%out.write(""+lo.getIdcarro());%></td>
                   <td><%out.write(lo.getCpfcliente());%></td>
                   <td><%out.write(String.valueOf(lo.getData()));%></td>
                   <td><%out.write(String.valueOf(lo.getDataretirada()));%></td>
                   <td><%out.write(String.valueOf(lo.getDatadevolucao()));%></td>
               </tr>
               <%}%>
            </tbody>    
        </table>
    </body>
</html>
