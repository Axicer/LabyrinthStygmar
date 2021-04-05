package engine.modele.objets;

import engine.modele.Descriptible;
import engine.modele.Identifiable;
import engine.modele.batiment.Piece;

/**
 * Cette classe donne une position et un numero à chaque objets du jeu.
 **/

public class Objet implements Descriptible, Identifiable {

    private Piece position;
    private int identifiant;

    public Objet(Piece p, int identifiant) {
        position = p;
        this.identifiant = identifiant;
    }

    public Objet(Piece p){
        this(p, (int) (Math.random()*Integer.MAX_VALUE));
    }

    @Override
    public void afficher() {
        position.afficher();
    }

    public Piece getPosition() {
        return position;
    }

    public void setPosition(Piece p) {
        position = p;
    }

    /**
     * Si l'objet est pris alors il n'a plus aucune position, il disparaît.
     **/
    public void prendre() {
        position = null;
    }

    @Override
    public int getIdentifiant() {
        return identifiant;
    }

    @Override
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }
}
