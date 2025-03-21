package unit16_Sockets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Cliente que envia la petición
 */
public class ClienteChat {


    public static void main(String[] args) {

        MarcoClienteChat mimarco=new MarcoClienteChat();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//Marco
class MarcoClienteChat extends JFrame{

    /**
     * Constructor de la clase {@code MarcoClienteChat}. Inicializa la interfaz gráfica del cliente de chat.
     * <p>
     * Este método realiza las siguientes acciones:
     * <ol>
     *   <li>Configura las dimensiones y la posición de la ventana utilizando el método {@link #setBounds(int, int, int, int)}.
     *       La ventana se coloca en la posición (600, 300) en la pantalla y tiene un tamaño de 280x350 píxeles.</li>
     *   <li>Crea una instancia de la clase {@link LaminaClienteChat}, que representa el panel principal de la interfaz gráfica.</li>
     *   <li>Añade el panel a la ventana principal utilizando el método {@link #add(java.awt.Component)}.</li>
     *   <li>Hace visible la ventana llamando al método {@link #setVisible(boolean)} con el valor {@code true}.</li>
     * </ol>
     * </p>
     */
    public MarcoClienteChat(){

        setBounds(600,300,280,350);
        LaminaClienteChat milamina=new LaminaClienteChat();
        add(milamina);
        setVisible(true);
    }
}


//Panel
class LaminaClienteChat extends JPanel {

    private JTextField campo1;
    private JButton miboton;

    /**
     * Constructor de la clase {@code LaminaClienteChat}. Inicializa los componentes de la interfaz gráfica del cliente
     * y configura el comportamiento del botón "Enviar" para enviar mensajes al servidor.
     * <p>
     * Este método realiza las siguientes acciones:
     * <ol>
     *   <li>Crea una etiqueta ({@link JLabel}) con el texto "CLIENTE" y la añade al panel.</li>
     *   <li>Crea un campo de texto ({@link JTextField}) con un ancho de 20 columnas para que el usuario ingrese mensajes
     *       y lo añade al panel.</li>
     *   <li>Crea un botón ({@link JButton}) con el texto "Enviar" y le asigna un {@link ActionListener} para manejar
     *       el evento de clic. Cuando el botón es presionado:
     *       <ul>
     *         <li>Se crea un {@link Socket} para conectarse al servidor en la dirección IP "100.96.12.32" y el puerto 9999.</li>
     *         <li>Se crea un flujo de salida de datos ({@link DataOutputStream}) para enviar el texto ingresado en el campo
     *             de texto al servidor.</li>
     *         <li>Se envía el texto utilizando el método {@link DataOutputStream#writeUTF(String)}.</li>
     *         <li>Se cierra el flujo de salida para liberar recursos.</li>
     *       </ul>
     *   </li>
     *   <li>Añade el botón al panel.</li>
     * </ol>
     * </p>
     * <p>
     * Si ocurre una excepción de tipo {@link IOException} durante el proceso de envío del mensaje, se imprime la traza
     * de la excepción en la consola.
     * </p>
     */
    public LaminaClienteChat(){
        JLabel cliente=new JLabel("CLIENTE");
        add(cliente);
        campo1=new JTextField(20);
        add(campo1);
        //Boton con su respectivo listener
        miboton=new JButton("Enviar");

        miboton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(campo1.getText());

                try {
                    //Creación del socket (canal del flujo de datos)
                    Socket miSocket = new Socket("100.96.12.32", 9999);

                    //Creacion del flujo de datos y le decimos que debe de ir por el Socket miSocket.
                    DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());

                    //Información que va en el flujo, en este caso el texto que introducimos.
                    flujoSalida.writeUTF(campo1.getText());

                    //Cerramos el flujo para no consumir datos.
                    flujoSalida.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(miboton);
    }
}
