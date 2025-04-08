package unit17_EjercicioChatSockets;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {


    public static void main(String[] args) {

        MarcoServidorChat mimarco=new MarcoServidorChat();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoServidorChat extends JFrame implements Runnable{

    private JTextArea areatexto;


    @Override
    public void run() {
        //System.out.println("Estoy a la escucha");

        try {
            //Puerto a la escucha
            ServerSocket miServidor = new ServerSocket(9999);

            String nick;
            String ip;
            String mensaje;

            LaminaClienteChat.EnvioPaqueteDatos paqueteRecibido;

            while (true) {

                //Acepta todas las conexiones que viajan por el socket
                Socket miSocket = miServidor.accept();
                ObjectInputStream flujoDatosEntrada = new ObjectInputStream(miSocket.getInputStream());
                paqueteRecibido = (LaminaClienteChat.EnvioPaqueteDatos) flujoDatosEntrada.readObject();
                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getTextoCliente();
                areatexto.append("\n" + "nick" + " : " +  nick + " Mensaje: "+  mensaje + "IP: " + ip);
                Socket reenvioDestinatario = new Socket(ip, 9090);
                ObjectOutputStream paqueteReenvio = new ObjectOutputStream(reenvioDestinatario.getOutputStream());
                paqueteReenvio.writeObject(paqueteRecibido);
                reenvioDestinatario.close();
                miSocket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor de la clase {@code MarcoServidorChat}. Este método inicializa la interfaz gráfica del servidor de chat
     * y lanza un hilo para escuchar conexiones entrantes.
     * <p>
     * El constructor realiza las siguientes acciones:
     * <ol>
     *   <li>Configura las dimensiones y la posición de la ventana utilizando el método {@link #setBounds(int, int, int, int)}.
     *       La ventana se coloca en la posición (1200, 300) en la pantalla y tiene un tamaño de 280x350 píxeles.</li>
     *   <li>Crea un panel ({@link JPanel}) que actuará como contenedor principal para los componentes de la interfaz gráfica.</li>
     *   <li>Establece un diseño de tipo {@link BorderLayout} para el panel, lo que permite organizar los componentes en áreas
     *       específicas (norte, sur, este, oeste y centro).</li>
     *   <li>Crea un área de texto ({@link JTextArea}) que se utilizará para mostrar los mensajes recibidos de los clientes.</li>
     *   <li>Añade el área de texto al centro del panel utilizando {@link BorderLayout#CENTER}.</li>
     *   <li>Añade el panel a la ventana principal utilizando el método {@link #add(Component)}.</li>
     *   <li>Hace visible la ventana llamando al método {@link #setVisible(boolean)} con el valor {@code true}.</li>
     *   <li>Crea un hilo ({@link Thread}) que ejecutará la lógica del servidor (implementada en el método {@link #run()} de esta clase).</li>
     *   <li>Inicia el hilo llamando al método {@link Thread#start()}, lo que permite que el servidor comience a escuchar conexiones entrantes.</li>
     * </ol>
     * </p>
     * <p>
     * Este constructor asume que la clase actual implementa la interfaz {@link Runnable}, ya que se pasa {@code this} al constructor
     * de {@link Thread}.
     * </p>
     *
     * @see JPanel
     * @see BorderLayout
     * @see JTextArea
     * @see Thread
     * @see Runnable
     */
    public MarcoServidorChat() {

        setBounds(1200,300,280,350);
        JPanel milamina= new JPanel();
        milamina.setLayout(new BorderLayout());
        areatexto=new JTextArea();
        milamina.add(areatexto,BorderLayout.CENTER);
        add(milamina);
        setVisible(true);

        Thread miHilo = new Thread(this);
        miHilo.start();
    }
}
