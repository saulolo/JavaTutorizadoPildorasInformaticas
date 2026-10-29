<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Supermercado</title>
    <style type="text/css">
        .titcentrado {
            text-align: center;
        }
    </style>
</head>


<body bgcolor="#99CC66">
<h1 class="titcentrado">Carro de la compra (supuesto)</h1>
<form name="Formulario_Compra" action="supermercado.jsp">

    <p>Artículos a comprar:</p>
    <p>
        <label>
            <input type="checkbox" name="articulos" value="agua ">
            Agua </label>
        <br>
        <label>
            <input type="checkbox" name="articulos" value="leche">
            Leche </label>
        <br>
        <label>
            <input type="checkbox" name="articulos" value="pan">
            Pan </label>
        <br>
        <label>
            <input type="checkbox" name="articulos" value="mazanas">
            Manzanas </label>
        <br>
        <label>
            <input type="checkbox" name="articulos" value="carne">
            Carne </label>
        <br>
        <label>
            <input type="checkbox" name="articulos" value="pescado">
            Pescado </label>
    </p>
    <p>
        <input type="submit" name="button" id="button" value="Enviar">
        <br>
    </p>
</form>

<h3>Carro de la compra virtual</h3>

<ul>

<%
    ArrayList<String> listaAlimentos = (ArrayList<String>) session.getAttribute("misAlimentos");

    if (listaAlimentos == null) {
      listaAlimentos = new ArrayList<>();
      session.setAttribute("misAlimentos", listaAlimentos);
    }

    String[] alimentos = request.getParameterValues("articulos");

    if (alimentos != null) {
        for (String alimento : alimentos) {
            listaAlimentos.add(alimento);
        }
    }

    for (String alimento : listaAlimentos) {
        out.print("<li>" + alimento + "</li>");
    }

%>
</ul>

</body>
</html>