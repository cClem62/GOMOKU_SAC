/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeu;

/**
 *
 * @author sylva
 */
public class Pion {
	private int x;
	private int y;
        private String couleur;
	public Pion (int x, int y, String couleur){
		this.x = x;
                this.y = y;
                this.couleur = couleur;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
        
        public String getCouleur(){
            return couleur;
        }
        
        public char getLettre(){
            char car = '0';
            if (couleur == "BLANC"){
                car = 'B';
            }
            if (couleur == "NOIR"){
                car = 'N';
            }
            return car;
        }
}