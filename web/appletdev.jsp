<%-- 
    Document   : appletdev
    Created on : 21/10/2011, 00:12:45
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
        <h1>Current Applet</h1>
        <jsp:plugin type="applet"  archive="TestApplet.jar" code="applet.TestApplet" name="testApplet">
            <jsp:fallback>Unable to load </jsp:fallback>
        </jsp:plugin>
    <applet code="applet.TestApplet" archive="TestApplet.jar"></applet>
    </body>
</html>
