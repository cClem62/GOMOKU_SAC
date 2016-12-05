/** Package de l'interface Gomoku **/
package gui;

/** les imports necessaires au bon fonctionnement de l'application **/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/** La classe de l'interface du plateau de jeu **/
public class InterfacePlateau extends JFrame
{
    public InterfacePlateau()
    {

        
        
           //Le titre de notre JFrame
        this.setTitle("Gomoku");
        //La taille de notre JFrame
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        //Permet la fermeture de l'application lors de le clic sur la 'croix' de fermeture
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //Empeche le changement de taille de notre JFrame
        this.setResizable(false);     
        //Instanciation d'un objet JPanel
        JPanel plateau = new JPanel();
        JPanel score = new JPanel();
        
        plateau.add(new JLabel(new ImageIcon("images/GOMO.png")));
       
        //Définition de sa couleur de fond
        plateau.setBackground(Color.ORANGE);
        score.setBackground(Color.WHITE);
        
        score.add(new JTextArea("Score de Joueur 1 :")); 
        score.add(new JTextArea("Score de Joueur 2 :")); 
        //Definition de la taille
        plateau.setBounds(100, 40, 70, 40);
 
        this.add(plateau, BorderLayout.WEST) ;
        this.add(score, BorderLayout.EAST);
        //On affiche notre JFrame
        this.setVisible(true); 
    }
}