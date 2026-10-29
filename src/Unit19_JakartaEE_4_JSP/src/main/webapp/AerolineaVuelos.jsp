<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Aerolinea</title>
</head>
<body>

<%
    String ciudadFavorita = "Aún no se ha seleccionado la ciudad.";
    //Lee la cookie de la petición hecha desde el navegador
    Cookie[] cookies = request.getCookies();

    //Buscar la cookie de la ciudad favorita
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("seleccionVuelos.ciudadFavorita".equals(cookie.getName())) {
              ciudadFavorita = cookie.getValue();
              break;
            }
        }
    }

%>

<p>Vuelos a: <%= ciudadFavorita %></p>

</body>
</html>