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
    
    private int taille_max;
    
    public GamePlay(Joueur J1, Joueur J2, String couleur1, String couleur2, int taille){
        this.J1 = J1;
        this.J2 = J2;
        this.couleur_Joueur_1 = couleur1;
        this.couleur_Joueur_2 = couleur2;
        this.taille_max = taille;
        plateau1 = new Plateau(taille);
    }
    
    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.println(plateau1); // Affichage du tableau avant la pose du premier pion.
        
        while (joueur1 == false || joueur2 == false || pion_restant == 0){ // Vérifie si un joueur à gagné ou s'il ne reste plus de pion
            System.out.println(J1.getNom() + ", dans quel colonne voulez-vous placer votre pion ?");
            int x = sc.nextInt();
            System.out.println(J1.getNom() + ", dans quel ligne voulez-vous placer votre pion ?");
            int y = sc.nextInt();
            if (x < 0 | y < 0 | x > taille_max-1 | y > taille_max-1){
                System.out.print("la ligne et la colonne doivent être comprises entre 0 et ");
                System.out.println(taille_max-1);
            }
            while (plateau1.placerPion(x, y, "BLANC") == false){
                while (x < 0 | y < 0 | x > taille_max-1 | y > taille_max-1){
                    System.out.println(J1.getNom() + ", dans quel colonne voulez-vous placer votre pion ?");
                    x = sc.nextInt();
                    System.out.println(J1.getNom() + ", dans quel ligne voulez-vous placer votre pion ?");
                    y = sc.nextInt();
                    if (x < 0 | y < 0 | x > taille_max-1 | y > taille_max-1){
                        System.out.print("la ligne et la colonne doivent être comprises entre 0 et ");
                        System.out.println(taille_max-1);
                    }
                }
            }
            System.out.println(plateau1); //Affichage du plateau après la pose d'un pion blanc.
            
            if (joueur1 == false){
                System.out.println(J2.getNom() + ", dans quel colonne voulez-vous placer votre pion ?");
                x = sc.nextInt();
                System.out.println(J2.getNom() + ", dans quel ligne voulez-vous placer votre pion ?");
                y = sc.nextInt();
                if (x < 0 | y < 0 | x > taille_max-1 | y > taille_max-1){
                    System.out.print("la ligne et la colonne doivent être comprises entre 0 et ");
                    System.out.println(taille_max-1);
                }

                while (plateau1.placerPion(x, y, "NOIR") == false){
                    while (x < 0 | y < 0 | x > taille_max-1 | y > taille_max-1){
                        System.out.println(J2.getNom() + ", dans quel colonne voulez-vous placer votre pion ?");
                        x = sc.nextInt();
                        System.out.println(J2.getNom() + ", dans quel ligne voulez-vous placer votre pion ?");
                        y = sc.nextInt();
                        if (x < 0 | y < 0 | x > taille_max-1 | y > taille_max-1){
                            System.out.print("la ligne et la colonne doivent être comprises entre 0 et ");
                            System.out.println(taille_max-1);
                        }
                    }
                }
                System.out.println(plateau1);
            }
            
        }
    }
    
}