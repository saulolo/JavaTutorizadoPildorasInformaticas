<%--
  Created by IntelliJ IDEA.
  User: SaulHernandoEcheverr
  Date: 31/07/2025
  Time: 7:03 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Datos de Usuario</h1>
Nombre del Usuario <%=request.getParameter("user_name")%>
<br>
<br>
Apellido del Usuario <%=request.getParameter("user_lastname")%>
<br>
<br>
Email del Usuario <%=request.getParameter("user_email")%>
</body>
</html>
