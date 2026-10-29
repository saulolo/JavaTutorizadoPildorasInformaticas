package Unit19_JakartaEE_5_Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet{

  @Serial
  private static final long serialVersionUID = 1L;

  public ServletRegistro() {
    super();
  }


  //Si el formulario lo envio con el métod get, utilizo el doGet
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter salida = response.getWriter();

    salida.println("<html><body>");
    salida.println("Nombre introducido: " + request.getParameter("nombre"));
    salida.println("Apellido introducido: " + request.getParameter("apellido"));
    salida.println("</body></html>");

  }

  //Si el formulario lo envio con el métod post, utilizo el doGet
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*    response.setContentType("text/html;charset=UTF-8");
    PrintWriter salida = response.getWriter();

    salida.println("<html><body>");
    salida.println("Nombre introducido: " + request.getParameter("nombre"));
    salida.println("Apellido introducido: " + request.getParameter("apellido"));
    salida.println("</body></html>");*/

  }

}
