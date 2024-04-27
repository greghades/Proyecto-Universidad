/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ComponenteBean;

import java.awt.Color;
import static javax.swing.SwingConstants.CENTER;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
/**
 *
 * @author usuario
 */
public class BotonBean extends JButton implements Serializable{
public BotonBean(){
        setText("< Volver");
        setOpaque(true);
      
        setBackground(Color.white);
        setForeground(Color.getHSBColor(203, 65, 86));
        setVerticalAlignment(CENTER);
        setHorizontalAlignment(CENTER);
        setHorizontalTextPosition(TRAILING);
        setSize(63,25);
        
} 
                                                         }
