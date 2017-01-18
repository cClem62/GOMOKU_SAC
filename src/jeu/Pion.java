package jeu;

import gui.InterfaceGomoku;

import java.util.ArrayList;

public class Pion 
{

    /**
     * constantes pour les pixels, les emplacements des pions et pour les checks des possibilités de mettre un pion.
     */
    public static final int[] pixels = pixelsDisponibles();
    public static final int haut = 0, hautDroite = 45, droite = 90, basDroite = 135, bas = 180, basGauche = 225, gauche = 270, hautGauche = 315;
    public static final int[] directions = {haut, hautDroite, droite, basDroite, bas, basGauche, gauche, hautGauche};

    /**
     * variables de la classe (en autre les positions (x,y) et la couleur en textuel).
     */
    private int x, y;
    private String couleur;

    public Pion() 
    {
        x = 0;
        y = 0;
    }

    public Pion(int x, int y) 
    {
       this.x = x;
       this.y = y;
    }

    public Pion (int x, int y, String couleur)
    {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }
    /**
     * Genere un tableau d'emplacements de pixels disponibles pour les Pions.
     */
    private static int[] pixelsDisponibles() 
    {
        int[] tableauPixels = new int[15];
        for (int i = 0; i < 15; i++) 
        {
            tableauPixels[i] = InterfaceGomoku.marge * (i+1);
        }
        return tableauPixels;
    }

    //getteurs
    public int getX() { return x; }
    public int getY() { return y; }

    //setteurs
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setXY(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
    
    public String toString() 
    {
        return "(" + x + ", " + y + ")";
    }

    /**
     * comparer les pions pour la validité de l'emplacement.
     */
    @Override
    public boolean equals(Object unObjet) 
    {
        if (!(unObjet instanceof Pion)) 
        {
            return false;
        }
        Pion unPion = (Pion) unObjet;
        if (this.getX() == unPion.getX() && this.getY() == unPion.getY())
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    /**
     * chercher le pion le plus près.
     *
     * @param  pixel = la distance entre pixels
     * @return un pion valide
     */
    private static int roundToPointValue(int pixel) 
    {
        int minimum = 1000;  //1000 car il faut une grande valeur de base pour trouver le min.
        int valeur = 0;
        for (int valeurPixel : Pion.pixels) 
        {
            int difference = Math.abs(pixel-valeurPixel);
            if (difference < minimum)
            {
                minimum = difference;
                valeur = valeurPixel;
            }
        }
        return valeur;
    }

    /**
     * Créez un objet Pion selon les pixels.
     * par exemple 25px * 25px est (1, 1)pour un pion sur la grille.
     * @param x
     * @param y
     * @return 
     */
    public static Pion convertirLesPixels(int x, int y) 
    {
        int x2 = Pion.roundToPointValue(x);
        int y2 = Pion.roundToPointValue(y);
        return new Pion(x2, y2);
    }

    /**
     * donne le pion adjacent
    */
    public Pion getPionAdjacent(int direction) 
    {
        int x = 0;
        int y = 0;
        switch (direction) 
        {
            case haut:
                x = this.getX();
                y = this.getY() - InterfaceGomoku.marge;
                break;
            case hautDroite:
                x = this.getX() + InterfaceGomoku.marge;
                y = this.getY() - InterfaceGomoku.marge;
                break;
            case droite:
                x = this.getX() + InterfaceGomoku.marge;
                y = this.getY();
                break;
            case basDroite:
                x = this.getX() + InterfaceGomoku.marge;
                y = this.getY() + InterfaceGomoku.marge;
                break;
            case bas:
                x = this.getX();
                y = this.getY() + InterfaceGomoku.marge;
                break;
            case basGauche:
                x = this.getX() - InterfaceGomoku.marge;
                y = this.getY() + InterfaceGomoku.marge;
                break;
            case gauche:
                x = this.getX() - InterfaceGomoku.marge;
                y = this.getY();
                break;
            case hautGauche:
                x = this.getX() - InterfaceGomoku.marge;
                y = this.getY() - InterfaceGomoku.marge;
                break;
            default:
                break;
        }

        if (x < InterfaceGomoku.marge || x > InterfaceGomoku.marge || y < InterfaceGomoku.marge || y > InterfaceGomoku.marge)
        {
            return null;
        }

        return new Pion(x, y);
    }

    /**
     * donne la liste des pions adjacents, afin de mémorriser via les directions.
     * exemple : haut : null, hautDroite : pion, droite : pion...
     */
    public ArrayList<Pion> getLesPionsAdjacents () 
    {
        ArrayList<Pion> listePions = new ArrayList<Pion>();
        for (int uneDirection : Pion.directions) 
        {
            Pion adjPoint = this.getPionAdjacent(uneDirection);
            listePions.add(adjPoint);
        }
        return listePions;
    }
    
    public char getLettre()
    {
            char car = '0';
            if (couleur == "BLANC"){
                car = 'B';
            }
            if (couleur == "NOIR"){
                car = 'N';
            }
            return car;
    }    
    
    public String getCouleur()
    {
        return couleur;
    }

}