<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : listausuarios
    Created on : 12/10/2011, 13:37:55
    Author     : guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Lista de Usuários</title>
    </head>
    <body>-->
    <c:forEach var="user" items="${loggedUsers}">
        <tr>
            <td>${user}</td>
        </tr>
    </c:forEach>
    <!--</body>
</html>-->
