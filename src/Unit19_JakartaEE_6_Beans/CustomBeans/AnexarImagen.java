package Unit19_JakartaEE_6_Beans.CustomBeans;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AnexarImagen extends JLabel {

  private File imagen = null;

  public AnexarImagen() {
    setBorder(BorderFactory.createEtchedBorder());
  }

  public Dimension getPreferredSize() {
    return new Dimension(600, 400);
  }

  public String getImagen() {
    if (imagen == null) return null;
    else return imagen.getPath();
  }

  public void setImagen(String rutaImagen) {
    try {
      imagen = new  File(rutaImagen);
      setIcon(new ImageIcon(ImageIO.read(imagen)));

    } catch (Exception e) {
      imagen = null;
      setIcon(null);
    }
  }

}
