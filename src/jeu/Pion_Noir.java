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
public class Pion_Noir extends Pion{
	private static final String couleur = "NOIR";
	public Pion_Noir (String couleur, int x, int y){
		super(x, y);

	}

	public String getCouleur(){
		return couleur;
	}

}
