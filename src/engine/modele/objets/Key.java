package engine.modele.objets;

import engine.modele.map.room.Room;

public class Key extends Objet {

    public Key(Room p, int n) {
        super(p, n);
    }

    /**
     * Affiche le numéro de la clé.
            * */
    @Override
    public void afficher() {
        System.out.println("Cle numéro : " + getIdentifiant());
    }

    /**
     * Cette méthode permet de redefinir un objet clé en returnant le numéro de la clé. 
     * */
    public String toString() {
        return "Cle numéro " + getIdentifiant();
    }
}
