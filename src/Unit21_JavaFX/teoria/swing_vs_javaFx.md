### 📊 Tabla Comparativa: Java Swing vs. JavaFX

| Criterio | Java Swing | JavaFX (El estándar moderno) |
| :--- | :--- | :--- |
| **Año de lanzamiento** | 1998 (Maduro / Legado). | 2008 / Rediseñado en 2014 con Java 8. |
| **Filosofía de Arquitectura** | Todo mezclado en código Java (o XMLs propietarios). | **Separación total (MVC real):**<br>• Vista: FXML (tipo HTML/XML)<br>• Estilos: CSS puro<br>• Lógica: Controladores Java |
| **Estilos visuales (CSS)** | Complejo (*Look and Feel* antiguo o librerías externas como FlatLaf). | **Nativo con CSS**: Cambias colores, bordes y fuentes igual que en una página web (`.button { -fx-background-color: blue; }`). |
| **Rendimiento / Gráficos** | Renderizado por CPU (dibujado por software píxel a píxel). | **Aceleración por Hardware (GPU)**: Usa DirectX / OpenGL. Soporta animaciones fluidas a 60 FPS y efectos 3D. |
| **Herramienta de Diseño Visual** | Muy limitada en IDEs modernos (descontinuada o vía plugins). | **Scene Builder** (Herramienta visual oficial, moderna, independiente y ultra potente de arrastrar y soltar). |
| **Propiedades y Reactividad** | Manual con eventos (*PropertyChangeListeners*, `getValueIsAdjusting()`). | **Data Binding y Observables**: Si cambias una variable en Java, la interfaz gráfica se actualiza sola automáticamente sin escribir listeners. |
| **Multimedia y Web** | Prácticamente nulo o muy difícil. | Soporte nativo para audio, video (MP4) y motor web completo integrado (**WebView** basado en WebKit/Chrome). |
| **Inclusión en el JDK** | Viene integrado dentro del JDK estándar (`javax.swing.*`). | **Modular (OpenJFX)**: Desde Java 11 ya no viene dentro del JDK, se gestiona como dependencia de Maven/Gradle o SDK externo. |
| **Jerarquía y Metáfora** | Marco (`JFrame`) ➔ Panel (`JPanel`) ➔ Componente (`JButton`). | **Metáfora de Teatro:**<br>Stage (Escenario/Ventana) ➔ Scene (Escena/Contenedor) ➔ Nodes (Nodos/Controles). |
| **Curva de aprendizaje** | Baja al principio, pero difícil de escalar y hacer que se vea bonita. | Media (aprender FXML y Scene Builder), pero mucho más fácil de mantener a nivel profesional. |