package engine.modele.objets;

import engine.modele.batiment.Piece;

public class Tresor extends Objet {

    public Tresor(Piece p) {
        super(p);
    }

    public void afficher() {
        System.out.println("Trésor");
    }

}
