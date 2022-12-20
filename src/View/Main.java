package View;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
          final JFrame mainFrame;
          InvoicePreview t=new InvoicePreview();
          mainFrame = t.getFrame();
          mainFrame.setSize(900, 550);
          mainFrame.setAutoRequestFocus(true);
          mainFrame.setVisible(true);
         mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}