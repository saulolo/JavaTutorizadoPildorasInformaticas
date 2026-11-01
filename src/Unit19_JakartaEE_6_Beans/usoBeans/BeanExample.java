package Unit19_JakartaEE_6_Beans.usoBeans;

//import com.toedter.calendar.JCalendar;
import javax.swing.*;

public class BeanExample {

  private JTextField textField1;
  private JPanel panel1;
  private JButton hacerClicButton;
  //private JCalendar jCalendar1;

  private void createUIComponents() {
    //jCalendar1 = new JCalendar();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Mi Formulario con Bean");
    frame.setContentPane(new BeanExample().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}