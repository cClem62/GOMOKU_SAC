/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationtest;

import java.awt.Color;
import javax.swing.JFrame;

public class Lancement {
public static void main(String[] args) {
// TODO Auto-generated method stub
Fenetre fenetre = new Fenetre("Jeu du Ballon");
fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
fenetre.setSize(1000,750);
fenetre.setVisible(true);
fenetre.setBackground(Color.ORANGE);
// connexion = new Connexion();
}
}