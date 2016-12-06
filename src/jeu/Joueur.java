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
public class Joueur 
{
	private String nom;
	private int pions_restant;
	private String couleur;

	public Joueur (String nom, String couleur)
	{
		this.nom = nom;
		this.couleur = couleur;
	}

	public String getNom()
	{
		return nom;
	}

	public String getCouleur()
	{
		return couleur;
	}
        
	public int getPionsRestant()
	{
		return pions_restant;
	}
        
}
