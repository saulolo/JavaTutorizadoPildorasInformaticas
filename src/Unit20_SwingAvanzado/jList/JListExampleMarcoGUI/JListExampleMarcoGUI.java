package Unit20_SwingAvanzado.jList.JListExampleMarcoGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class JListExampleMarcoGUI {


  private JPanel panel1;
  private JLabel rotuloMeses;
  private JScrollPane barraScroll;
  private JPanel laminaLista;
  private JList listaMeses;
  private JPanel laminaLabel;


  public JListExampleMarcoGUI() {
    listaMeses.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          actualizarTextoMeses();
        }
      }
    });
  }


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


  /**
   * Punto de inicio de la aplicación.
   * Lanza la interfaz gráfica de forma segura dentro del Event Dispatch Thread (EDT).
   *
   * @param args Argumentos de la línea de comandos (no utilizados).
   */
  public static void main(String[] args) {
      JFrame frame = new JFrame("");
      frame.setContentPane(new JListExampleMarcoGUI().panel1);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 300);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
  }


}
