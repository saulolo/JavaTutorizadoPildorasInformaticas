<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    String[] empleados = {"Saul", "Felipe", "Alejandra", "Leidy"};
    pageContext.setAttribute("misEmpleados", empleados);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>JSP Tags - Core</title>
</head>

<body>

<%--JSP Tags--%>
<%--Foreach--%>
<c:forEach var="empleado" items="${misEmpleados}">
    ${empleado}<br>
</c:forEach>


</body>
</html>