<%-- 
    Document   : index
    Created on : 12/10/2011, 08:54:24
    Author     : guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:include page="listausuarios.jsp">
            <jsp:param name="name" value="value"/>
        </jsp:include>
    </body>
</html>
