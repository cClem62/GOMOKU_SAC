/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

/**
 *
 * @author Clément Cantraine
 */
public class Test {
    public static void main(String[] args)
	{
		Joueur J1 = new Joueur("Antoine","BLANC");
		Joueur J2 = new Joueur("Clement","NOIR");
		Plateau plateau1 = new Plateau(7);
                plateau1.toString();
                plateau1.placerPion(2, 5, "BLANC");
	}
}
