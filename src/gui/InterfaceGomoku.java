/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import jeu.Pion;


/**
 *
 * @author Antonio
 */
public class InterfaceGomoku extends JPanel implements KeyListener, MouseListener 
{
    public static final int posDebutQuadrillage = 35;
    public static final int nb_lignes = 19;

    public static final int posFinQuadrillage = posDebutQuadrillage * nb_lignes;
    
    public InterfaceGomoku()
    {
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setFocusable(true);      
    }
    
    public void paint(Graphics g) 
    {
        super.paint(g);
        creerGrille(g);
    }
    
    private void creerGrille(Graphics g) 
    {
        g.setColor(Color.black);
        
        for (int nbCases = 0; nbCases < nb_lignes * posDebutQuadrillage; nbCases += posDebutQuadrillage) 
        {
            g.drawLine(posDebutQuadrillage + nbCases, posDebutQuadrillage, posDebutQuadrillage + nbCases, nb_lignes*posDebutQuadrillage);
            g.drawLine(posDebutQuadrillage, posDebutQuadrillage + nbCases, nb_lignes*posDebutQuadrillage, posDebutQuadrillage + nbCases);
        }
    }
    

    private static void creerPion(Graphics g, ArrayList<Pion> jeu, String couleur) 
    {
        for (Pion unPion: jeu) 
        {
            if ("blanc".equals(couleur)) 
            {
                g.setColor(Color.white);
            }
            else
            {
                g.setColor(Color.black);
            }
            
            //15 et 30 apres avoir tester les tailles, esthétiquement ça rend bien.
            g.fillOval(unPion.getX() - 15, unPion.getY() - 15, 30, 30);
            
            if ("blanc".equals(couleur))
            {
                g.setColor(Color.BLACK);  
                g.drawOval(unPion.getX() - 15, unPion.getY() - 15, 30, 30);
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) 
    {
        //creerPion(g, jeu, TOOL_TIP_TEXT_KEY);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
