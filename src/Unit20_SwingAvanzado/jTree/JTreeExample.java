package Unit20_SwingAvanzado.jTree;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Ventana gráfica que demuestra el uso del componente {@link JTree}.
 * Implementa una arquitectura modular separando construcción de interfaz,
 * gestión de eventos y lógica de negocio.
 *
 * @author Saulolo
 */
public class JTreeExample extends JFrame {

  // =========================================================================
  // ATRIBUTOS / COMPONENTES DE LA INTERFAZ
  // =========================================================================
  private JPanel panelPrincipal;
  private JTree arbolGeografico;
  private JScrollPane barraScroll;



  // =========================================================================
  // CONSTRUCTOR: CONFIGURACIÓN DEL MARCO Y MONTAJE
  // =========================================================================
  public JTreeExample() {

    // 1. PROPIEDADES BÁSICAS DE LA VENTANA (JFrame)
    setTitle("Arbol Geografico");
    panelPrincipal = new JPanel();
    panelPrincipal.setLayout(new BorderLayout());
    panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    setContentPane(panelPrincipal);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450, 300);
    setLocationRelativeTo(null);

    // 2. MODELO DE ARBOLES
    DefaultMutableTreeNode nRaiz = construirNodosGeograficos();

    // 3. CONSTRUCCIÓN DE COMPONENTES
    // Nodo raiz
    arbolGeografico = new JTree(nRaiz);
    barraScroll = new JScrollPane(arbolGeografico);

    // 4. ENSAMBLAJE FINAL EN EL MARCO (JFrame)
    panelPrincipal.add(barraScroll, BorderLayout.CENTER);

  }


  // =========================================================================
  // GESTIÓN DE EVENTOS Y CONTROLADORES (Listeners)
  // =========================================================================




  // =========================================================================
  // LÓGICA DE NEGOCIO / MÉTODOS AUXILIARES
  // =========================================================================
  /**
   * Construye y estructura la jerarquía de nodos del árbol.
   * Desacopla la lógica de datos para mantener el constructor limpio.
   *
   * @return Nodo raíz con toda la información geográfica cargada.
   */
  private DefaultMutableTreeNode construirNodosGeograficos() {
    DefaultMutableTreeNode nRaiz = new DefaultMutableTreeNode("Mundo");

    // ------------- Colombia -------------
    DefaultMutableTreeNode nPaisColombia = new DefaultMutableTreeNode("Colombia");
    nRaiz.add(nPaisColombia);
    DefaultMutableTreeNode rAndina = new DefaultMutableTreeNode("Andina");
    DefaultMutableTreeNode rCaribe = new DefaultMutableTreeNode("Caribe");
    nPaisColombia.add(rAndina);
    nPaisColombia.add(rCaribe);

    DefaultMutableTreeNode dGuajira = new DefaultMutableTreeNode("Guajira");
    rCaribe.add(dGuajira);

    // ------------- España -------------
    DefaultMutableTreeNode nPaisEspania = new DefaultMutableTreeNode("España");
    nRaiz.add(nPaisEspania);
    DefaultMutableTreeNode rAutonoma = new DefaultMutableTreeNode("Autónomas");
    DefaultMutableTreeNode rGalicia = new DefaultMutableTreeNode("Galicia");
    DefaultMutableTreeNode rMadrid = new DefaultMutableTreeNode("Madrid");
    nPaisEspania.add(rAutonoma);
    nPaisEspania.add(rGalicia);
    nPaisEspania.add(rMadrid);

    return nRaiz;
  }


  // =========================================================================
  // PUNTO DE ENTRADA (Main Thread-Safe)
  // =========================================================================
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JTreeExample jTreeExample = new JTreeExample();
      jTreeExample.setVisible(true);
    });

  }


}
