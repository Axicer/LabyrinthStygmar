package engine.modele.map.room;

public class ShortcutRoom extends Room {

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Passage secret");
    }

}
