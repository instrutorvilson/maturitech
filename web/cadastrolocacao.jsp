<%-- 
    Document   : cadastrolocacao
    Created on : 11 de nov de 2020, 08:11:40
    Author     : entra21
--%>

<%@page import="modelos.Cliente"%>
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
        <h1>Cadastro Locação</h1>
        <hr />
        <%
          Carro carro = new Carro();
          List<Carro> carros = carro.consultar();
          
          Cliente cliente = new Cliente();
          List<Cliente> clientes = cliente.consultar();

        %>  
        
        <form action="recebedadoslocacao.jsp" method="POST">
           <label>Selecione o carro para locação </label>
            <select name="idcarro">
                <% for(Carro c: carros){ %>
                   <option value="<%out.write(""+c.getId());%>">
                       <% out.write(c.getPlaca() + " - " + c.getModelo()); %>
                   </option>
                <%}%>
            </select> 
            <br />
            <label>Selecione o cliente para locação </label>
            <select name="cpfcliente">
                <%for(Cliente c: clientes){%>
                    <option value="<%out.write(c.getCpf());%>">
                        <% out.write(c.getNome() + "-"+c.getCpf()); %>
                    </option>
                <%}%>
            </select>
            <br />
            <label>Informe a data</label>
            <input type="date" name="dataretirada" />
            <hr />
            <input type="submit" value="Salvar" /> 
        </form>        
    </body>
</html>
