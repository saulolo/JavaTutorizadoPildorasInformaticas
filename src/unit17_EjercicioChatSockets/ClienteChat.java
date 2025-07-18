package unit17_EjercicioChatSockets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Cliente que envia la petición
 */
public class ClienteChat implements Serializable {

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
        estableceConexionServidor();
    }

    void estableceConexionServidor() {
        try {
            Socket miSocket = new Socket("100.96.12.32", 9999);
            LaminaClienteChat.EnvioPaqueteDatos datos = new LaminaClienteChat.EnvioPaqueteDatos();
            datos.setTextoCliente("Online");
            ObjectOutputStream flujoSalidaPaquete = new ObjectOutputStream(miSocket.getOutputStream());
            flujoSalidaPaquete.writeObject(datos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//Panel
class LaminaClienteChat extends JPanel implements Runnable{

    private JTextField campo1;
    private JLabel nick;
    private JComboBox ip;
    private JButton miboton;
    private JTextArea areaChat;


    public LaminaClienteChat(){

        Thread miHilo = new Thread(this);
        miHilo.start();

        nick = new JLabel();
        nick.setText(JOptionPane.showInputDialog("Nick:"));
        add(nick);
        JLabel cliente=new JLabel("-- Online -> -");
        add(cliente);
        ip = new JComboBox();
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
                    datos.setIp(ip.getSelectedItem().toString());
                    datos.setTextoCliente(campo1.getText());

                    ObjectOutputStream flujoSalidaPaquete = new ObjectOutputStream(miSocket.getOutputStream());
                    flujoSalidaPaquete.writeObject(datos);
                    miSocket.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(miboton);
    }

    @Override
    public void run() {
        try {
            ServerSocket escuchaCliente = new ServerSocket(9090);
            Socket cliente;
            EnvioPaqueteDatos paqueteRecibido;
            while (true) {
                cliente = escuchaCliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido = (EnvioPaqueteDatos)flujoEntrada.readObject();
                if (paqueteRecibido.getTextoCliente().equals(" online")) {
                    //areaChat.append("\n" + paqueteRecibido.getIPs());
                    ArrayList<String> IpsJCombo = new ArrayList<>();
                    IpsJCombo = paqueteRecibido.getIPs();
                    ip.removeAllItems();
                    for (String ips : IpsJCombo) {
                        ip.addItem(ips);
                    }
                } else {
                    areaChat.append("\n" +  paqueteRecibido.getNick() + ": "+  paqueteRecibido.getTextoCliente());
                }
                cliente.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class EnvioPaqueteDatos implements Serializable{

        private String nick;
        private String ip;
        private String textoCliente;
        private ArrayList<String> IPs;

        public ArrayList<String> getIPs() {
            return IPs;
        }

        public void setIPs(ArrayList<String> IPs) {
            this.IPs = IPs;
        }

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
