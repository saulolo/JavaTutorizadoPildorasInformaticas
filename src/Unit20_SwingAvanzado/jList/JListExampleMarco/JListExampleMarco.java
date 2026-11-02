package Unit20_SwingAvanzado.jList.JListExampleMarco;

//import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

/**
 * Ventana gráfica que demuestra el uso del componente {@link JList}.
 * Implementa una arquitectura modular separando construcción de interfaz,
 * gestión de eventos y lógica de negocio.
 *
 * @author Saulolo
 */
public class JListExampleMarco extends JFrame {

  // =========================================================================
  // ATRIBUTOS / COMPONENTES DE LA INTERFAZ
  // =========================================================================
  private JPanel laminaLista;
  private JPanel laminaLabel;
  private JList<String> listaMeses;
  private JLabel rotuloMeses;
  private JScrollPane barraScroll;


  // =========================================================================
  // CONSTRUCTOR: CONFIGURACIÓN DEL MARCO Y MONTAJE
  // =========================================================================
  /**
   * Inicializa las propiedades de la ventana, crea los componentes,
   * enlaza los controladores de eventos y ensambla los contenedores.
   */
  public JListExampleMarco() {

    // 1. PROPIEDADES BÁSICAS DE LA VENTANA (JFrame)
    setTitle("Lista de meses");
    setBounds(500, 300, 550, 300);
    setLayout(new BorderLayout());

    // 2. MODELO DE DATOS Y CREACIÓN DE LA LISTA (JList)
    String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre"
    , "Octubre", "Noviembre", "Diciembre"};

    listaMeses = new JList<>(meses);
    listaMeses.setVisibleRowCount(4);
    barraScroll = new JScrollPane(listaMeses);

    // 3. CONSTRUCCIÓN DE CONTENEDORES (Paneles y Etiquetas)
    laminaLista = new JPanel();
    laminaLista.add(barraScroll);

    // Panel Inferior: Contiene el texto con el resultado
    laminaLabel = new JPanel();
    rotuloMeses = new JLabel("Mes seleccionado: ");
    laminaLabel.add(rotuloMeses);

    // 4. REGISTRO DE EVENTOS (Llamada al métod centralizado)
    iniciarEventos();

    // 5. ENSAMBLAJE FINAL EN EL MARCO (JFrame)
    add(laminaLista, BorderLayout.NORTH);
    add(laminaLabel, BorderLayout.SOUTH);
  }

  // =========================================================================
  // GESTIÓN DE EVENTOS Y CONTROLADORES (Listeners)
  // =========================================================================

  /**
   * Centraliza el registro de todos los escuchadores de eventos
   * de los componentes interactivos de la ventana.
   */
  private void iniciarEventos() {

    // Evento de selección para el JList de meses
    listaMeses.addListSelectionListener(new  ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        // getValueIsAdjusting evita que el evento se dispare dos veces al hacer clic
        if (!e.getValueIsAdjusting()) {
          actualizarTextoMeses();
        }
      }
    });
    // En el futuro, aquí registrarías otros eventos de forma ordenada:
    // botonAceptar.addActionListener(e -> accionBoton());
    // campoTexto.addKeyListener(...);
  }


  // =========================================================================
  // LÓGICA DE NEGOCIO / MÉTODOS AUXILIARES
  // =========================================================================

  /**
   * Lee la lista de elementos seleccionados actualmente en el {@link JList}
   * y actualiza el contenido del {@link JLabel} informativo.
   */
  private void actualizarTextoMeses() {
    List<String> elementos = listaMeses.getSelectedValuesList();

    StringBuilder textoSeleccionado = new StringBuilder("Mes seleccionado: ");
    for (String elemento : elementos) {
      textoSeleccionado.append(elemento).append(", ");
    }

    rotuloMeses.setText(textoSeleccionado.toString());
  }


  // =========================================================================
  // PUNTO DE ENTRADA (Main Thread-Safe)
  // =========================================================================
  /**
   * Punto de inicio de la aplicación.
   * Lanza la interfaz gráfica de forma segura dentro del Event Dispatch Thread (EDT).
   *
   * @param args Argumentos de la línea de comandos (no utilizados).
   */
  public static void main(String[] args) {

    // 1. ACTIVAR EL TEMA MODERNO (Debe ir ANTES de crear cualquier componente visual)
/*    try {
      FlatDarkLaf.setup(); // O usa FlatLightLaf.setup() si prefieres tema claro
    } catch (Exception ex) {
      System.err.println("Fallo al inicializar Look and Feel moderno.");
    }*/

    // Buena práctica Swing: ejecutar la GUI en el hilo Event Dispatch Thread (EDT)
    SwingUtilities.invokeLater(() -> {
      JListExampleMarco miFrame = new JListExampleMarco();
      miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      miFrame.setVisible(true);
    });
  }

  /*
  * 1. MODELO MENTAL  ──>  2. ATRIBUTOS  ──>  3. CONSTRUCTOR  ──>  4. EVENTOS  ──>  5. LÓGICA  ──>  6. LANZAMIENTO (EDT)
   (Diseño/Layout)       (Componentes)       (Ensamblaje)        (Listeners)      (Acciones)      (main Thread-Safe)
  *
  *
  * 📌 Resumen de Buenas Prácticas a Recordar:
✅ Usa siempre SwingUtilities.invokeLater en el main.
✅ Separa la creación visual de la lógica de los clics.
✅ Usa nombres descriptivos para los componentes (btnGuardar, txtNombre, tablaUsuarios).
❌ Evita usar setLayout(null) (posicionamiento absoluto), ya que rompe la aplicación en pantallas con distintas resoluciones o sistemas operativos.
  * */
}
