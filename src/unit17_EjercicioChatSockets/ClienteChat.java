package unit17_EjercicioChatSockets;

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
    private JTextField nick;
    private JTextField ip;
    private JButton miboton;
    private JTextArea areaChat;


    public LaminaClienteChat(){
        nick = new JTextField(5);
        add(nick);
        JLabel cliente=new JLabel("-- CHAT -");
        add(cliente);
        ip = new JTextField(8);
        add(ip);
        areaChat = new JTextArea(12, 20);
        add(areaChat);
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

                    EnvioPaqueteDatos datos = new EnvioPaqueteDatos();
                    datos.setNick(nick.getText());
                    datos.setIp(ip.getText());
                    datos.setTextoCliente(campo1.getText());

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(miboton);
    }

    class EnvioPaqueteDatos{

        private String nick;
        private String ip;
        private String textoCliente;


        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getTextoCliente() {
            return textoCliente;
        }

        public void setTextoCliente(String textoCliente) {
            this.textoCliente = textoCliente;
        }
    }
}
