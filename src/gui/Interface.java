package gui;

import static gui.InterfaceGomoku.nb_lignes;
import javax.swing.JFrame;

/**
 *
 * @author Antonio
 * interface qui regroupe le plateau Gomoku (plateau + gomoku)
 */
public class Interface extends JFrame
{
    
   public Interface()
   {
       //JFrame f = new JFrame();
       this.setTitle("Gomoku");
        
       InterfaceGomoku gomoku = new InterfaceGomoku();
       this.add(gomoku);
       int size = gomoku.nb_lignes + InterfaceGomoku.marge;
       this.setSize(size +6, size +28);
       this.setLocationRelativeTo(null);
       this.setResizable(false);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //gomoku.nb_lignes = 15;
       this.setVisible(true);     
   }
}
