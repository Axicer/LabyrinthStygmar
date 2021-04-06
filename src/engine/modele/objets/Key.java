package engine.modele.objets;

import engine.modele.map.room.Room;

public class Key extends Objet {

    public Key(Room p, int n) {
        super(p, n);
    }

    /**
     * Affiche le num�ro de la cl�.
            * */
    @Override
    public void afficher() {
        System.out.println("Cle num�ro : " + getIdentifiant());
    }

    /**
     * Cette m�thode permet de redefinir un objet cl� en returnant le num�ro de la cl�. 
     * */
    public String toString() {
        return "Cle num�ro " + getIdentifiant();
    }
}
