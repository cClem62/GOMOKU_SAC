package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jeu.Pion;

public class InterfaceGomoku extends JPanel implements KeyListener, MouseListener 
{
    /**
     * constantes pour définir la taille de la grille et du pion et aussi pour permettre de faire le Morpion
     */
    public static final int marge = 35;
    public static final int nb_lignes = 15;
    public static final int diametre_pion = 30;
    public static final  int fin_marge = marge * nb_lignes;

    /**
     * variables de la classe 
     */
    private Pion positionPion;
    private ArrayList<Pion> jeuJoueurUn;
    private ArrayList<Pion> jeuJoueurDeux;
    private boolean tourJoueurUn;
    private boolean joueurUnGagne;
    private boolean joueurDeuxGagne;

    /**
     * constructeur de l'interface 
     */
    public InterfaceGomoku() 
    {
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setFocusable(true);
        positionPion = new Pion();
        jeuJoueurUn = new ArrayList<Pion>();
        jeuJoueurDeux = new ArrayList<Pion>();
        tourJoueurUn = true;
        joueurUnGagne = false;
        joueurDeuxGagne = false;
    }

    /**
     * 
     * #paint. 
     * recréer la grille et les pions à chaques modifications.
     * @param g 
     */
    public void paint(Graphics g) 
    {
        super.paint(g);
        creerGrille(g);
        dessinerPions(g);
    }

    /**
     * créer la grille de jeu
     */
    private void creerGrille(Graphics g) 
    {
        //couleur des lignes du grillages
        g.setColor(Color.black);
        //créer les lignes qui forment le jeu (toujours avec la marge pour aligner le pion sur les lignes)
        for (int i = 0; i < nb_lignes * marge; i += marge) 
        {
            g.drawLine(marge + i, marge, marge + i, nb_lignes * marge);
            g.drawLine(marge, marge + i, nb_lignes * marge, marge + i);
        }
    }

    /**
     * Dessine les pions des joueurs
     */
    private void dessinerPions(Graphics g) 
    {
        //créer les pions des deux joueurs.
        creerPions(g, jeuJoueurUn, Color.WHITE);
        creerPions(g, jeuJoueurDeux, Color.BLACK);
    }

    /**
     * créer des pions selon leur emplacement.
     */
    private static void creerPions(Graphics g, ArrayList<Pion> emplacements, Color couleur) 
    {
        for (Pion unPion: emplacements) 
        {
            //definir la couleur du pion
            g.setColor(couleur);
            //créer un oval complet(fill) donc le pion à l'emplacement.
            g.fillOval(unPion.getX() - diametre_pion/2, unPion.getY() - diametre_pion/2, diametre_pion, diametre_pion);
            //test si c'est la couleur du joueurUn pour la visibilité 
            if (couleur != Color.BLACK) 
            {
                //et j'ajoute un contour noir aux pions blanc (c'est un plus) avec drawOval.
                g.setColor(Color.BLACK);
                g.drawOval(unPion.getX() - diametre_pion/2, unPion.getY() - diametre_pion/2, diametre_pion, diametre_pion);
            }
        }
    }

    /**
     * Test si un joueur gagne.
     */
    private void verifierVictoire() 
    {
        ArrayList<Pion> emplacements = dernierMouvements();

        //check les côtés utilisés d'un emplacement.
        ArrayList<Pion> listePionsACote = positionPion.getLesPionsAdjacents();
        
        for (Pion unPionACote : listePionsACote) 
        {
            if (emplacements.contains(unPionACote)) 
            {
                int i = listePionsACote.indexOf(unPionACote);
                int direction = Pion.directions[i];
                boolean siJeuFinit = verifieCaseACote(emplacements, unPionACote, direction, 3);
                if (siJeuFinit) 
                {
                    joueurGagne();
                }
            }
        }
    }

    /**
     *  Valide le vainqueur.
     */
    private void joueurGagne() 
    {
        if (!tourJoueurUn) 
        {
            joueurUnGagne = true;
        } 
        else 
        {
            joueurDeuxGagne = true;
        }
    }

    /**
     * verifie si la case à coter est prise ou non.
     * 
     */
    private static boolean verifieCaseACote(ArrayList<Pion> emplacements, Pion position, int direction, int valeur) 
    {
        //je créer mon pion et test s'il y a un pion dans toutes les directions à coter.
        Pion pionTest = position.getPionAdjacent(direction);
        while (emplacements.contains(pionTest) && valeur > 0) 
        {
            //ref à la classe Pion.
            pionTest = pionTest.getPionAdjacent(direction);
            valeur--;
        }
        if (valeur == 0) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    /**
     * liste des derniers mouvements.
     */
    private ArrayList<Pion> dernierMouvements() 
    {
        if (!tourJoueurUn) 
        {
            return jeuJoueurUn;
        } 
        else 
        {
            return jeuJoueurDeux;
        }
    }

    /**
     * Emplacement du pion lors du clic et mise à jour de l'affichage.
     */
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if (!joueurUnGagne && !joueurDeuxGagne) 
        {
            //ref : classe pion
            Pion localisationPion = Pion.convertirLesPixels(e.getX(), e.getY());
            if (tourJoueurUn) 
            {
                //check du clic s'il est valide
                if (!jeuJoueurUn.contains(localisationPion) && !jeuJoueurDeux.contains(localisationPion)) 
                {
                    //oui, on ajoute le pion
                    jeuJoueurUn.add(localisationPion);
                    tourJoueurUn = false;
                }
            } 
            else //tour j2
            {
                if (!jeuJoueurDeux.contains(localisationPion) && !jeuJoueurUn.contains(localisationPion))
                {
                    jeuJoueurDeux.add(localisationPion);
                    tourJoueurUn = true;
                }
            }
            positionPion = localisationPion;
            verifierVictoire();
        }
        this.repaint();
        checkVictoire();
    }

    /**
     * check si un joueur est victorieux lors du clic.
     */
    private void checkVictoire() 
    {
        String messageVictoire = null;
        if (joueurUnGagne) 
        {
            messageVictoire = "Victoire du joueur 1.";
        }
        else if (joueurDeuxGagne) 
        {
            messageVictoire = "Victoire du joueur 2.";
        }

        if (joueurUnGagne || joueurDeuxGagne) 
        {
            JOptionPane.showMessageDialog(null, messageVictoire, "Gomoku", JOptionPane.PLAIN_MESSAGE);
            recommencer();
            this.repaint();
        }
    }

    /**
     * si on veut recommencer le jeu.
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        //touche pour recommencer à VK_ENTER (donc entrer).
        if (e.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            recommencer();
            this.repaint();
        }
    }

    /**
     * restauration des variables à défaut
     */
    private void recommencer() 
    {
        positionPion.setXY(0, 0);
        jeuJoueurUn.clear();
        jeuJoueurDeux.clear();
        tourJoueurUn = true;
        joueurUnGagne = false;
        joueurDeuxGagne = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

}