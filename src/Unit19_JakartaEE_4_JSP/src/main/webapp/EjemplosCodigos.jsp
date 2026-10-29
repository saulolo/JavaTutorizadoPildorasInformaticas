<%@ page import="javax.swing.*" %>
<%@ page import="org.education.operacionesAritmeticas.OperacionesMatematicas" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ejemplo de Códigos </title>
</head>
<body>


<h1>Expresiones</h1>
Convirtiendo a mayúsculas:  <%= new String("Saul Echeverri").toUpperCase()%>
<br>
La suma de 6 + 2 es: <%= 6 + 2 %>
<br>
30 es mayor que 300: <%= 300 > 30%>

<h1>Scriptlets</h1>
<%
    for (int i = 0; i < 10; i++) {
        out.println("Vuelta de bucle nro: " + i + "<br>");
    }
    ;
%>

<h1>Declaraciones</h1>
<h2>Ejemplo 1 </h2>
<%!int number = 3;%>
<%
    if (number > 0) out.println("Es positivo.");
    else out.println("Es negativo.");
%>

<br>

<h2>Ejemplo 2</h2>
La suma es: <%= OperacionesMatematicas.suma(2, 4) %>
<br>
<%
    out.println("la resta de los números ingresados es: " + OperacionesMatematicas.resta(2, 4));
    out.println("la multiplicación de los números ingresados es: " + OperacionesMatematicas.multiplicacion(2, 4));
    OperacionesMatematicas.division(2, 4);
%>


</body>
</html>