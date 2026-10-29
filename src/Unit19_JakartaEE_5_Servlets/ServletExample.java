package Unit19_JakartaEE_5_Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Date;

@WebServlet("/ServletExample")
public class ServletExample extends HttpServlet {

  @Serial
  private static final long serialVersionUID = 1L;

  public ServletExample() {
    super();
  }


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter objSalida = response.getWriter();

    objSalida.println("<html><body>");
    objSalida.println("<h1 style='text-align:center;'>Bienvenido a mi Servlet</h1>");
    objSalida.println("");
    objSalida.println("");
    objSalida.println("Fecha y hora actual: " + new Date());
    objSalida.println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }


}
