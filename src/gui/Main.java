package gui;

import java.util.Scanner;
import jeu.GamePlay;
import jeu.Joueur;
import jeu.Plateau;

public class Main 
{
    public static void main(String[] args) 
    //{
        //InterfaceAccueil a = new InterfaceAccueil();
        //InterfacePlateau fenetre = new InterfacePlateau();
        //InterfaceUtilisateur joueur = new InterfaceUtilisateur();
    //}
            
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est le pseudo du joueur 1 :");
        String joueur1 = sc.nextLine();
        System.out.println("Quel est le pseudo du joueur 2 :");
        String joueur2 = sc.nextLine();
        System.out.println(joueur1 + ", vous êtes les blancs");
        System.out.println(joueur2 + ", vous êtes les noirs");
        Joueur J1 = new Joueur(joueur1, "BLANC");
        Joueur J2 = new Joueur(joueur2, "NOIR");
        
        GamePlay game1 = new GamePlay(J1, J2, "BLANC", "NOIR", 7);
        game1.start();
        
        System.out.println("finis");
    }
}