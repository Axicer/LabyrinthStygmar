package engine.modele.objets;

import engine.modele.map.room.Room;

public class Tresor extends Objet {

    public Tresor(Room p) {
        super(p);
    }

    public void afficher() {
        System.out.println("Trésor");
    }

}
