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
public class Plateau {


	private Pion[][] tableau;
        private boolean premier_pion = true;
	
	public Plateau (int taille){
            tableau = new Pion [taille][taille];
	}
        
        public boolean placerPion(int x, int y, String couleur){
            boolean possible = false;
            // Si c'est le premier pion, le pose sans condition
            if (premier_pion == true){
                if (couleur == "BLANC"){
                    tableau[x][y] = new Pion(x,y, "BLANC");
                    System.out.println("Création d'un pion blanc");
                    possible = true;
                }
                if (couleur == "NOIR"){
                    tableau[x][y] = new Pion(x,y, "NOIR");
                    System.out.println("Création d'un pion noir");
                    possible = true;
                }
                premier_pion = false;
               
            }
            // Sinon véirfie que la case ne soit pas occupé et qu'il y a un bien un pion mitoyen  à celui que l'ont veut poser
            else{
                if (placement_possible(x,y)){
                    if (couleur == "BLANC"){
                        tableau[x][y] = new Pion(x,y, "BLANC");
                        System.out.println("Création d'un pion blanc");
                        possible = true;
                    }
                    if (couleur == "NOIR"){
                        tableau[x][y] = new Pion(x,y, "NOIR");
                        System.out.println("Création d'un pion noir");
                        possible = true;
                    }
                }
                else{
                    System.out.println("Placement impossible");
                }
            }
            
            return possible;
        }
        
        // Renvoie TRUE s'il est possible de placer un pion.
        public boolean placement_possible(int x, int y){
            boolean possible = true;
            if (!case_libre(x, y)){
                possible = false;
                System.out.println("La case n'est pas libre");
            }
            if (!case_voisine_occupee(x, y)){
                possible = false;
                System.out.println("Vous devez placer votre pion sur une case voisine d'un autre pion");
            }
            return possible;
        }
        
        // Retourne TRUE si au moins l'une des cases autour (diagonales comprises) est occupée.
        public boolean case_voisine_occupee(int x, int y){
            boolean drap = false;
            if (verifN(x, y)){
                drap = true;
            }
            if (verifS(x, y)){
                drap = true;
            }
            if (verifE(x, y)){
                drap = true;
            }
            if (verifO(x, y)){
                drap = true;
            }
            if (verifNE(x, y)){
                drap = true;
            }
            if (verifNO(x, y)){
                drap = true;
            }
            if (verifSE(x, y)){
                drap = true;
            }
            if (verifSO(x, y)){
                drap = true;
            }
            return drap;
        }

        
        // Retourne TRUE si la case au Nord est occupée
        public boolean verifN(int x, int y)
        {
            boolean possible = false;
            if (case_prise(x,y-1))
            {
                possible = true;
            }
            return possible;
        }
        
        // Retourne TRUE si la case au Sud est occupée
        public boolean verifS(int x, int y)
        {
            boolean possible = false;
            if (case_prise(x,y+1))
            {
                possible = true;
            }
            return possible;
        }
        
        // Retourne TRUE si la case à l'Est est occupée
        public boolean verifE(int x, int y)
        {
            boolean possible = false;
            if (case_prise(x+1,y))
            {
                possible = true;
            }
            return possible;
        }
        
        // Retourne TRUE si la case a l'Ouest est occupée
        public boolean verifO(int x, int y)
        {
            boolean possible = false;
            if (case_prise(x-1,y))
            {
                possible = true;
            }
            return possible;
        }
        
        // Retourne TRUE si la case au Nord-Est est occupée
        public boolean verifNE(int x, int y)
        {
            boolean possible = false;
            if (case_prise(x+1,y-1))
            {
                possible = true;
            }
            return possible;
        }
        
        // Retourne TRUE si la case au Sud-est est occupée
        public boolean verifSE(int x, int y)
        {
            boolean possible = false;
            if (case_prise(x+1,y+1))
            {
                possible = true;
            }
            return possible;
        }
        
        // Retourne TRUE si la case au Sud-Ouest est occupée
        public boolean verifSO(int x, int y)
        {
            boolean possible = false;
            if (case_prise(x-1,y+1))
            {
                possible = true;
            }
            return possible;
        }
        
        // Retourne TRUE si la case au Nord-Ouest est occupée
        public boolean verifNO(int x, int y)
        {
            boolean possible = false;
            if (case_prise(x-1,y-1))
            {
                possible = true;
            }
            return possible;
        }
        
        // Vérifie si la cas est libre
        public boolean case_libre(int x, int y)
        {
            boolean possible = true;
            if (tableau[x][y] != null){
                
                possible = false;
            }
            return possible;
        }
        
        // Vérifie si la case est prise
        public boolean case_prise(int x, int y){
            boolean possible = true;
            if (tableau[x][y] == null){
                
                possible = false;
            }
            return possible;
        }
        
        public String toString(){
            System.out.print("  ");
            for(int i = 0; i < tableau.length; i++){
                System.out.print(i+" ");
            }
            System.out.println("");
            System.out.println("");
            for(int i = 0; i < tableau.length; i++){
                System.out.print(i+" ");
                for(int j = 0; j < tableau[i].length; j++){
                    if (case_libre(j,i)){
                        System.out.print("0 ");
                    }
                    else{
                        
                        System.out.print(tableau[j][i].getLettre()+ " ");
                    }
                }
                System.out.println("");
                System.out.println("");
            }
            return "";
        }
}
