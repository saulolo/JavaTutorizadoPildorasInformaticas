<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.function" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Usuarios</title>
</head>
<body>

<c:set var="datosPersona" value="Maria, López, Perú, Java, 1900"/>

<c:set var="arrayPersonas" value="${fn:split(datosPersona, ',')}"/>

<input type="text" value="${arrayPersonas[0]}">
<input type="text" value="${arrayPersonas[1]}">
<input type="text" value="${arrayPersonas[2]}">
<input type="text" value="${arrayPersonas[3]}">
<input type="text" value="${arrayPersonas[4]}">

</body>
</html>