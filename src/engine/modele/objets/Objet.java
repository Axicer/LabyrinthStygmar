package engine.modele.objets;

import engine.modele.Descriptible;
import engine.modele.Identifiable;
import engine.modele.map.room.Room;

/**
 * Cette classe donne une position et un numero ? chaque objets du jeu.
 **/

public class Objet implements Descriptible, Identifiable {

    private Room position;
    private int identifiant;

    public Objet(Room p, int identifiant) {
        position = p;
        this.identifiant = identifiant;
    }

    public Objet(Room p){
        this(p, (int) (Math.random()*Integer.MAX_VALUE));
    }

    @Override
    public void afficher() {
        position.afficher();
    }

    public Room getPosition() {
        return position;
    }

    public void setPosition(Room p) {
        position = p;
    }

    /**
     * Si l'objet est pris alors il n'a plus aucune position, il dispara?t.
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
