package engine.modele.objets;

import engine.modele.map.room.Room;

public class Medicament extends Objet {

    private static final int MAX_VIE = 10;
    private int vie;

    public Medicament(Room p) {
        super(p);
        vie = (int) (Math.random()*MAX_VIE);
    }

    @Override
    public void afficher() {
        System.out.println("Medicament de " + vie + " point(s) ");
    }

    public int getVie() {
        return vie;
    }

    @Override
    public String toString() {
        return "Medic " + vie + " point(s)";
    }
}
