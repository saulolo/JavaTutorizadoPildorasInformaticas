package unit19_JakartaEE_1_MVC;

public class MVC_Teoria {

    public static void main(String[] args) {


        System.out.println("-------------- MVC --------------");
        /*MVC: Model Vista Controlador
        * Esta patrón de diseño de aplicaciones se utiliza masivamente en el diseño de aplicaciones del lado del servidor.
        * */

        /*
                    ------------------------------------------------------
                    |              FUNCIONAMIENTO DEL PATRÓN MVC         |
                    ------------------------------------------------------
                                         +---------+
                                         |  Modelo |
                                         |   (BD)  |
                                         +---------+
                                              ▲
                                              |  RESPUESTA
                                              |
                                         +---------+
                                         |  Vista  |
                                         +---------+
                                              ▲
                             OBSERVACIÓN      |        USO
                             / FEEDBACK       |         ▲
                                            Usuario
                                              |
                                              ▼
                                       +-------------+
                                       | Controlador |
                                       +-------------+
                                              |
                                              ▼
                                           EVENTOS /
                                          CONEXIÓN DB
                    ------------------------------------------------------
                    DESCRIPCIÓN:
                    - El usuario interactúa con la Vista.
                    - La Vista envía eventos al Controlador.
                    - El Controlador procesa la lógica y consulta o manipula el Modelo.
                    - El Modelo responde con los datos al Controlador.
                    - La Vista se actualiza con los datos recibidos.
                    ------------------------------------------------------
                    */

    }

}
