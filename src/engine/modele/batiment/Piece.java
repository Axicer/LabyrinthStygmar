package engine.modele.batiment;

import engine.modele.Descriptible;

/**
 * Cette classe va instancier 4 portes et va permettre d'organiser les pièces en fonctions
 * des portes Nord, Sud, Est ou Ouest qu'elles possède.
 **/
public class Piece implements Descriptible {

    private Porte nord;
    private Porte sud;
    private Porte ouest;
    private Porte est;

    public Porte AuNord() {
        return nord;
    }

    public Porte AuSud() {
        return sud;
    }

    public Porte AOuest() {
        return ouest;
    }

    public Porte AEst() {
        return est;
    }

    /**
     * Affiche si une pièce possède une porte nord, sud, est ou ouest.
     **/
    @Override
    public void afficher() {
        if (nord != null) {
            System.out.print("Au Nord : ");
            nord.afficher();
        }
        if (est != null) {
            System.out.print("A l'Est : ");
            est.afficher();
        }
        if (sud != null) {
            System.out.print("Au Sud : ");
            sud.afficher();
        }
        if (ouest != null) {
            System.out.print("A l'Ouest : ");
            ouest.afficher();
        }
    }

    /**
     * Permet d'ajouter une porte à une pièce.
     **/
    public void ajoutPorte(Porte po, Piece pi, String s) {
        po.ajoutPiece(this, pi);
        if (s.equals("Nord")) {
            nord = po;
            pi.sud = po;
        }
        if (s.equals("Sud")) {
            sud = po;
            pi.nord = po;
        }
        if (s.equals("Est")) {
            est = po;
            pi.ouest = po;
        }
        if (s.equals("Ouest")) {
            ouest = po;
            pi.est = po;
        }
    }

    public Porte getPorte(char r) {
        switch (r) {
            case 'N':
                return nord;
            case 'E':
                return est;
            case 'S':
                return sud;
            case 'O':
                return ouest;
            default:
                System.out.println("Vous devez taper une des 4 lettres suivantes N, E, S, O");
                return null;
        }
    }

    /**
     * Permet de savoir si une pièce possède une pièce voisine.
     **/
    public Piece possedePieceVoisine(char r) {
        Porte po = getPorte(r);

        if (po != null) {
            return po.autrePiece(this);
        } else return this;
    }

} 
