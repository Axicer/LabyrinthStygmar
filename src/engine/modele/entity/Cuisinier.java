package engine.modele.entity;

import engine.modele.map.room.Room;

public class Cuisinier extends Entity {

    public Cuisinier(Room p) {
        super(p);
    }

    @Override
    public void afficher() {
        System.out.println("Cuisinier");
    }
}
