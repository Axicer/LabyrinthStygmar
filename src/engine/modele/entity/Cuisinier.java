package engine.modele.entity;

import engine.modele.batiment.Piece;

public class Cuisinier extends Entity {

    public Cuisinier(Piece p) {
        super(p);
    }

    @Override
    public void afficher() {
        System.out.println("Cuisinier");
    }
}
