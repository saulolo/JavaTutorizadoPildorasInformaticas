package Unit21_JavaFX.firstProyect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class JavaFxExample extends Application {

  // =========================================================================
  // 1. ATRIBUTOS / CONTROLES DE LA INTERFAZ (Los "Actores")
  // =========================================================================
  private Button button;


  // =========================================================================
  // 2. CICLO DE VIDA: START (El Montaje de la Obra)
  // =========================================================================
  @Override
  public void start(Stage primaryStage) {

    // A. Construcción del Layout Raíz (BorderPane: Top, Bottom, Left, Right, Center) y su escena
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 500, 400);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

    // C. Configuración del Escenario (La "Ventana")
    primaryStage.setTitle("JavaFxExample");
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
    primaryStage.show();


    // D. Inicialización de Controles
    inicializarControles();

    // E. Registro de Eventos
    iniciarEventos();
  }


  // =========================================================================
  // 3. MÉTODOS AUXILIARES: CONSTRUCCIÓN VISUAL
  // =========================================================================
  private void inicializarControles() {
    // Instanciar los controles definidos en los atributos
  }


  // =========================================================================
  // 4. GESTIÓN DE EVENTOS Y CONTROLADORES (Listeners)
  // =========================================================================
  private void iniciarEventos() {
    // btnAccion.setOnAction(e -> metodoLogica());
  }


  // =========================================================================
  // 5. LÓGICA DE NEGOCIO / ACCIONES
  // =========================================================================


  // =========================================================================
  // 6. PUNTO DE ENTRADA (Lanzador de JavaFX)
  // =========================================================================
  public static void main(String[] args) {
    launch(args); // Arranca el hilo de JavaFX (JavaFX Application Thread)
  }
}

/*
 * =========================================================================
 * 🎭 METÁFORA DEL TEATRO (Arquitectura JavaFX):
 * 1. STAGE (Escenario) ──► La Ventana física del SO (primaryStage).
 * 2. SCENE (Escena)    ──► El lienzo que contiene los elementos (ancho x alto).
 * 3. ROOT  (Panel)     ──► El Layout contenedor (VBox, HBox, BorderPane).
 * 4. NODES (Actores)   ──► Los controles interactivos (Button, Label).
 *
 * 📌 Resumen de Buenas Prácticas JavaFX a Recordar:
 * ✅ Separar la instanciación de controles de los eventos (setOnAction).
 * ✅ Usar VBox/HBox/BorderPane en lugar de posicionamiento X/Y (Pane básico).
 * ✅ Toda modificación visual debe ocurrir en el "JavaFX Application Thread".
 * ✅ Para tareas pesadas, usar javafx.concurrent.Task en lugar de SwingWorker.
 * =========================================================================
 */