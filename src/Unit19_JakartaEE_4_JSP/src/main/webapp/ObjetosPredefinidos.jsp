<%--
  Created by IntelliJ IDEA.
  User: SaulHernandoEcheverr
  Date: 29/07/2025
  Time: 7:54 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ejemplo de Objetos Predefinidos</title>
</head>
<body>

<h1>Objetos JSP Predefinidos</h1>
<br>
Petición Datos del Navegador:
<%=request.getHeader("user-agent")%>
<br>
Petición Idioma del Usuario:
<%=request.getLocale()%>

</body>
</html>
