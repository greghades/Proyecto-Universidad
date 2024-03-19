/*
 Ernesto Contreras
28245373

Albani barragán
28268078

Luis Carrillo
27539960

Gregori Yepez 
28047103

Yaslin Vreugdenhil.
29561929
 */
package util;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class PantallaCompleta {

    public void setPantallaCompleta(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = new Insets(100, 200, 100, 200);
        Dimension adjustedSize = new Dimension(
                screenSize.width - insets.left - insets.right,
                screenSize.height - insets.top - insets.bottom
        );
        frame.getContentPane().setPreferredSize(adjustedSize);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
