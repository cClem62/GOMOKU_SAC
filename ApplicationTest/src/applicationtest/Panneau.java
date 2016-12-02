/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationtest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
public class Panneau extends JPanel{
public Image[] tab=new Image[3];
public Image[][] grille;
public File a;
public File b;
public BufferedImage rouge;
public BufferedImage noir;
public int x;
public int y;
int px=0;
int py=0;
boolean depart=false;

//Constructeur du panneau

public Panneau(){
this.setBorder(BorderFactory.createLineBorder(Color.black));
x=17;
y=14;
grille=new Image[x][y];
try{
a=new File("img/bleu.png");
b=new File("img/noir.png");

//Chargement des images
rouge=ImageIO.read(a);
noir=ImageIO.read(b);

//Remplissage du tableau
tab[0]=rouge;
tab[1]=noir;
tab[2]=rouge;
this.remplir();




}catch(Exception e){
System.out.println("fichier introuvable");
}
}


//Methode pour remplir la grille
public void remplir(){

for(int i=0;i<this.x;i++){
for(int v=0;v<this.y;v++){
int random = (int)(Math.random() * (3-0)) + 0;
grille[i][v]=tab[random];
if(grille[i][v]==rouge){
System.out.println("rouge");
}else{
System.out.println("noir");
}
}
}
}

public double getAbsc(){
return(x);

}

public double getOrdo(){
return(y);
}



//Paint component
public void paintComponent(Graphics g){

if(depart==true){
for(int i=0;i<17;i++){
for(int v=0;v<14;v++){

//Dessine la grille de ballon
g.drawImage(grille[i][v],px,py,this);
px=px+50;
if(px>=x*50){
px=0;
py=py+50;
if(py>=y*50){
py=0;
}
}
repaint();
validate();
}
}
}

}
}