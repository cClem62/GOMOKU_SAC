/** Package de l'interface Gomoku **/
package gui;

/** les imports necessaires au bon fonctionnement de l'application **/
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
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
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        //Permet la fermeture de l'application lors de le clic sur la 'croix' de fermeture
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //Empeche le changement de taille de notre JFrame
        //this.setResizable(false);     
        //Instanciation d'un objet JPanel
       // JPanel score = new JPanel();
       
        //Définition de sa couleur de fond
       // score.setBackground(Color.WHITE);
        
        //score.add(new JTextArea("Score de Joueur 1 :")); 
        //score.add(new JTextArea("Score de Joueur 2 :")); 
        
        Interface gomo = new Interface();
        InterfaceUtilisateur u = new InterfaceUtilisateur();
        
        this.add(gomo, BorderLayout.WEST) ;
        this.add(u, BorderLayout.EAST);
        
        //On affiche notre JFrame
        this.setVisible(true); 
    }
}