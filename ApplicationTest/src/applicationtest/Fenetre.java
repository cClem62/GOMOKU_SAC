/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationtest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
public JButton play;
public JLabel score;
public JLabel point;
public int time;
public JLabel horloge;
public Timer decompte;
public JLabel temps;
public JPanel affichage;
public JPanel bouton;
public JPanel droite;
public Panneau ball;
public JPanel principal;


public Fenetre(String titre){
super(titre);

//Création composant
play=new JButton("Jouer");
score=new JLabel("Score:");
point=new JLabel("0");
temps=new JLabel("Temps:");
horloge=new JLabel("");
time=120;

affichage=new JPanel(new GridLayout(2,2));
affichage.add(temps);
horloge.setText(""+time);
affichage.add(horloge);
affichage.add(score);
affichage.add(point);


bouton=new JPanel();
bouton.add(play);
droite=new JPanel(new GridLayout(2,1));
droite.add(affichage);
droite.add(bouton);
droite.setBorder(BorderFactory.createLineBorder(Color.black));



ball=new Panneau();
decompte=createTimer();




principal=new JPanel(new BorderLayout());

principal.add(droite,BorderLayout.EAST);

principal.add(ball,BorderLayout.CENTER);
add(principal);




//Bouton pour jouer
play.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){

//On remplit a nouveau la grille et on passe le boolean a true pour la dessiner
ball.remplir();
ball.depart=true;

//On remet le temps à 120 seconde et le label originale
time=120;
horloge.setText(""+time);

//Départ du decompte
decompte.start();

//On dessine la grille
ball.paintComponent(ball.getGraphics());
}
});

}

//Méthode renvoyant un timer prêt à démarrer
private Timer createTimer ()
{
//Création d'une instance de listener
//associée au timer
ActionListener action = new ActionListener ()
{
//Méthode appelée à chaque tic du timer
public void actionPerformed (ActionEvent event)
{
//Décrementation du temps

time=time-1;
horloge.setText(""+time);
}
};

//Création d'un timer
//chaque 1000 millième de seconde
return new Timer (1000, action);
}

}
