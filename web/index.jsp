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
        <jsp:include page="login.jsp">
            <jsp:param name="name" value="value"/>
        </jsp:include>
        <!--<script src="http://www.java.com/js/deployJava.js"></script>
        <script> 
            var attributes = { code:'applet.TestApplet',  width:300, height:300} ; 
            var parameters = {jnlp_href: 'TestJnlp.jnlp'} ; 
            deployJava.runApplet(attributes, parameters, '1.6'); 
        </script>-->
        <%--<jsp:include page="/listausuarios">
            <jsp:param name="name" value="value"/>
        </jsp:include>--%>
        <a href="appletdev.jsp" >Current Applet</a>
    </body>
</html>
