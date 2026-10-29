<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Recibe petición</title>
</head>
<body>

<%
    //Leer la información que viene del formulario
    String ciudadSeleccionada = request.getParameter("ciudad_favorita");

    //Crear la cookie y gurdar la información del formulario
    Cookie miCookie = new Cookie("seleccionVuelos.ciudadFavorita", ciudadSeleccionada);

    //Establecer la vida de la cookie
    miCookie.setMaxAge(365 * 24 * 60 * 60); //Establecimos de duración un año

    //Guardar/Enviar la cookie al ordenador del usuario
    response.addCookie(miCookie);

%>

Ver vuelos: <a href="AerolineaVuelos.jsp">Click aqui</a>


</body>
</html>  