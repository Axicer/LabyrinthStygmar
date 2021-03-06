package engine.modele.objets;

import engine.modele.map.room.Room;

public class Nourriture extends Objet {

    private static final int MAX_FORCE = 10;
    private int force;

    public Nourriture(Room p) {
        super(p);
        force = (int) (Math.random() * MAX_FORCE);
    }

    @Override
    public void afficher() {
        System.out.println("Nourriture de " + force + " point(s) de force ");
    }

    public int getForce() {
        return force;
    }

    public String toString() {
        return "Nourriture de " + force + " point(s) de force";
    }
}
