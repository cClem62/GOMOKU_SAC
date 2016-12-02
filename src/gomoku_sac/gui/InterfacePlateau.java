/** Package de l'interface Gomoku **/
package gomoku_sac.gui;

/** les imports necessaires au bon fonctionnement de l'application **/
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** La classe de l'interface du plateau de jeu **/
public class InterfacePlateau extends JFrame
{
    //Image du jeu Gomoku
    private final JLabel image;
    public InterfacePlateau()
    {
        //Le titre de notre JFrame
        this.setTitle("Gomoku");
        //La taille de notre JFrame
        this.setSize(325, 327);
        this.setLocationRelativeTo(null);
        //Permet la fermeture de l'application lors de le clic sur la 'croix' de fermeture
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //Empeche le changement de taille de notre JFrame
        this.setResizable(false);     
        //Instanciation d'un objet JPanel
        JPanel plateau = new JPanel();
        //Définition de sa couleur de fond
        plateau.setBackground(Color.ORANGE);
        //Definition de l'image
        image = new JLabel(new ImageIcon("images/GOMO.png"));
        //Ajout de l'image sur notre panel
        plateau.add(image);
        
        //On prévient notre JFrame que notre JPanel sera son content 'panel'
        this.setContentPane(plateau);  
        
        //On affiche notre JFrame
        this.setVisible(true);       
    }
}