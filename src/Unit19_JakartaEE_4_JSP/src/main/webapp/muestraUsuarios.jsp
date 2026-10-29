<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="org.education.usuarios.Usuario" %>

<%
    ArrayList<Usuario> datosUsuarios = new ArrayList<>();

    Class.forName("org.postgresql.Driver");

    try {
        Connection miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto_web_jsp_PildorasDB", "postgres", "1234");

        Statement miSt = miConexion.createStatement();

        String miSQL = "SELECT * FROM USUARIOS";

        ResultSet miRs = miSt.executeQuery(miSQL);

        while (miRs.next()) {
            datosUsuarios.add(new Usuario(miRs.getString(2), miRs.getString(3), miRs.getString(4), miRs.getString(6), miRs.getInt(8)));
        }

        miRs.close();
        miConexion.close();

    } catch (Exception e) {
        out.print("Ha ocurrido un error en la conexíon con la Base de Datos.");

    }

    pageContext.setAttribute("losUsuarios", datosUsuarios);
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Usuarios</title>

    <table>
        <tr style="font-weight: bold">
            <td>Nombre</td>
            <td>Apellido</td>
            <td>Usuario</td>
            <td>País</td>
            <td>Localización</td>
            <td>Salario</td>
        </tr>
        <c:forEach var="usuTemp" items="${losUsuarios}">

            <tr>
                <td>${usuTemp.nombre}</td>
                <td>${usuTemp.apellido}</td>
                <td>${usuTemp.usuario}</td>
                <td>${usuTemp.pais}</td>
                <td><c:if test="${usuTemp.pais.equals('España') }">Nacional</c:if>
                    <c:if test="${!usuTemp.pais.equals('España')}">Internacional</c:if>
                </td>
                <td><c:chose>
                    <c:when test="${usuTemp.salario > 2000}">Salario Alto</c:when>
                    <c:when test="${usuTemp.salario > 1500}">Salario Medio</c:when>
                    <c:otherwise>Salario Bajo</c:otherwise>

                </c:chose>
                </td>
            </tr>
        </c:forEach>
    </table>

</head>
<body>
<h1>Usuarios</h1>

</body>
</html>