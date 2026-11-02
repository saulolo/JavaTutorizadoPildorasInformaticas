package Unit20_SwingAvanzado.jTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class JTableExample extends JFrame {

  // =========================================================================
  // ATRIBUTOS / COMPONENTES DE LA INTERFAZ
  // =========================================================================
  private JPanel contentPane;
  private JTable jTablaPlanetas;
  private JScrollPane barraScroll;
  private JButton btnImprimir;

  // MODELO DE DATOS Y CREACIÓN DE LAS COLUMNAS Y FILAS
  private String[] nombresColumnas = {"Nombre", "Radio", "Lunas", "Gaseoso"};
  private Object[][] datosFilas = {
      {"Mercurio", 2440, 0, false},
      {"Venus", 6052, 0, false},
      {"Tierra", 6378, 1, false},
      {"Marte", 3397, 2, false},
      {"Júpiter", 71492, 16, true},
      {"Saturno", 60268, 18, true},
      {"Urano", 25559, 17, true},
      {"Neptuno", 24766, 8, true},
      {"Plutón", 1137, 1, false},
  };

  // =========================================================================
  // CONSTRUCTOR: CONFIGURACIÓN DEL MARCO Y MONTAJE
  // =========================================================================
  public JTableExample() {
    // 1. PROPIEDADES BÁSICAS DE LA VENTANA (JFrame)
    setTitle("");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 400);
    setLocationRelativeTo(null);

    // Panel Principal
    contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout());
    contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    setContentPane(contentPane);
    setLayout(new BorderLayout());

    // 2. CONSTRUCCIÓN DE COMPONENTES
    jTablaPlanetas = new JTable(datosFilas, nombresColumnas);
    barraScroll = new JScrollPane(jTablaPlanetas);
    btnImprimir = new JButton("Imprimir Tabla");

    // 3. ENSAMBLAJE FINAL EN EL MARCO (JFrame)
    contentPane.add(barraScroll, BorderLayout.CENTER);
    contentPane.add(btnImprimir, BorderLayout.SOUTH);

    // 4. REGISTRO DE EVENTOS (Llamada a los métodos)
    //---- Imprime la tabla ----
    imprimir();


  }


  // =========================================================================
  // GESTIÓN DE EVENTOS Y CONTROLADORES (Listeners)
  // =========================================================================
  private void imprimir() {
    btnImprimir.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        try {
          jTablaPlanetas.print();
          System.out.println("Imprimiendo");
        } catch (PrinterException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }


  // =========================================================================
  // PUNTO DE ENTRADA (Main Thread-Safe)
  // =========================================================================
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JTableExample ventana = new JTableExample();
      ventana.setVisible(true);
    });
  }

}
