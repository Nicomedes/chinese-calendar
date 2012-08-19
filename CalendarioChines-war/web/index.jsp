<%-- 
    Document   : index
    Created on : 14/08/2012, 18:59:43
    Author     : 30980364
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
    </head>
    <body>       
        <form action="processa.jsp" method="post">
            Nome:<input type="text" name="nome"/></br>
            Data de Nascimento: <input type="text" name="dataNasc"/></br>
            <input type="submit" value="OK">
        </form>
    
    </body>
</html>
