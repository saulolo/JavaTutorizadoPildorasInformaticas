<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de usuario</title>
</head>
<body>
<%
    String name = request.getParameter("nombre");
    String lastname = request.getParameter("apellido");
    String username = request.getParameter("usuario");
    String password = request.getParameter("contra");
    String country = request.getParameter("pais");
    String technology = request.getParameter("tecnologias");

    // Validar que los parámetros existan
    if (name == null || lastname == null || username == null || password == null || country == null || technology == null) {
        out.println("Faltan datos en el formulario.");

    } else {
        try {
            Class.forName("org.postgresql.Driver");
            Connection miConnection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/proyecto_web_jsp_PildorasDB", "postgres", "1234");

            //Comprobar si existe un usuario
            String user = "SELECT * FROM USUARIOS WHERE usuario=?";
            PreparedStatement statement = miConnection.prepareStatement(user);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                out.print("⚠ El usuario ya existe.");
            } else {

                String insSql = "INSERT INTO USUARIOS(nombre, apellido, usuario, contrasena, pais, tecnologia) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = miConnection.prepareStatement(insSql);
                pst.setString(1, name);
                pst.setString(2, lastname);
                pst.setString(3, username);
                pst.setString(4, password);
                pst.setString(5, country);
                pst.setString(6, technology);

                int filas = pst.executeUpdate();
                if (filas > 0) {
                    out.println("✅ Usuario registrado con éxito!");
                } else {
                    out.println("❌ No se pudo registrar el usuario.");
                }

                pst.close();
                miConnection.close();

            }


        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
%>
</body>
</html>