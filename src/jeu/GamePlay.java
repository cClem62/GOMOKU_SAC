/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeu;

import java.util.Scanner;

/**
 *
 * @author sylva
 */
public class GamePlay {
    private Joueur J1;
    private Joueur J2;
    private String couleur_Joueur_1;
    private String couleur_Joueur_2;
    private int pion_restant = 10;
    
    // Determine si un joueur à gagné (TRUE)
    private boolean joueur1 = false;
    private boolean joueur2 = false;
    private Plateau plateau1;
    
    private static int taille_max;
    private int nombre_cases;
    
    private static int pion_align_pour_gagner = 5;
    
    public GamePlay(Joueur J1, Joueur J2, String couleur1, String couleur2, int taille){
        this.J1 = J1;
        this.J2 = J2;
        this.couleur_Joueur_1 = couleur1;
        this.couleur_Joueur_2 = couleur2;
        this.taille_max = taille;
        plateau1 = new Plateau(taille);
        
    }
    
    public void start(){
        System.out.println(plateau1); // Affichage du tableau avant la pose du premier pion.
        int x;
        int y;
        while (joueur1 == false && joueur2 == false && pion_restant != 0){ // Vérifie si un joueur à gagné ou s'il ne reste plus de pion
            x = choisirX(J1);
            y = choisirY(J1);
            while (plateau1.placerPionPossible(x, y, "BLANC") == false){
                x = choisirX(J1);
                y = choisirY(J1);
            }
            plateau1.placerPion(x, y, "BLANC");
            if (plateau1.victoire("BLANC")){
                joueur1 = true;
            }
            System.out.println(plateau1); //Affichage du plateau après la pose d'un pion blanc.

            if (joueur1 == false){
                x = choisirX(J2);
                y = choisirY(J2);
                while (plateau1.placerPionPossible(x, y, "NOIR") == false){
                x = choisirX(J2);
                y = choisirY(J2);
            }
            System.out.println("Joueur 2(1) : " + joueur2); // COMMENT
            plateau1.placerPion(x, y, "NOIR");
            if (plateau1.victoire("NOIR")){
                joueur2 = true;
            }
            System.out.println("Joueur 2(2) : " + joueur2); // COMMENT
            System.out.println(plateau1); //Affichage du plateau après la pose d'un pion Noir.
            }
        }
        if(joueur1){
            System.out.println(J1.getNom() +", à gagné");
        }
        else if(joueur2){
            System.out.println(J2.getNom() +", à gagné");
        }
        else{
            System.out.println("Egalité, toutes les cases sont prises");
        }
    }
    
    public int choisirX(Joueur j){
        int x = -1;
        Scanner sc = new Scanner(System.in);
        while (x < 0 | x > taille_max-1){
            System.out.println(j.getNom() + ", dans quel colonne voulez-vous placer votre pion ?");
            x = sc.nextInt();
            if (x < 0 | x > taille_max-1){
                System.out.print("La colonne doivent être comprises entre 0 et ");
                System.out.println(taille_max-1);
            }
        }
        return x;
    }
    public int choisirY(Joueur j){
        int y = -1;
        Scanner sc = new Scanner(System.in);
        while (y < 0 | y > taille_max-1){
            System.out.println(j.getNom() + ", dans quel ligne voulez-vous placer votre pion ?");
            y = sc.nextInt();
            if (y < 0 | y > taille_max-1){
                System.out.print("La ligne doivent être comprises entre 0 et ");
                System.out.println(taille_max-1);
            }
        }
        return y;
    }
    public static int getTailleMax(){
        return taille_max;
    }
    
    public static int getPionAAligner(){
        return pion_align_pour_gagner;
    }
}