<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    String username = request.getParameter("usuario");
    String password = request.getParameter("contra");

    // Validar que los parámetros existan
    if (username == null || password == null) {
        out.println("<h2>Faltan datos en el login.</h2>");
    } else {

        Connection miConnection = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.postgresql.Driver");
            miConnection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/proyecto_web_jsp_PildorasDB", "postgres", "1234");

            String selSql = "SELECT * FROM USUARIOS WHERE USUARIO=? AND CONTRASENA=?";
            pst = miConnection.prepareStatement(selSql);

            pst.setString(1, username);
            pst.setString(2, password);

            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                out.println("<h2 style='color:green;'>✅ Login Correcto!</h2>");
                out.println("<p>Bienvenido, " + resultSet.getString("nombre") + "!</p>");
            } else {
                out.println("<h2 style='color:red;'>⛔ Login Incorrecto!</h2>");
                out.println("<p>Usuario o contraseña incorrectos.</p>");
            }

        } catch (Exception e) {
            out.println("<h2 style='color:red;'>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace();
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException ignore) {
            }
            if (pst != null) try {
                pst.close();
            } catch (SQLException ignore) {
            }
            if (miConnection != null) try {
                miConnection.close();
            } catch (SQLException ignore) {
            }
        }
    }
%>
</body>
</html>