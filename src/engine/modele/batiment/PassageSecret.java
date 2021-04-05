package engine.modele.batiment;

/**
 * Permet d'ajouter un passage secret dans le labyrinthe qui permet de gagner la partie instantanement quand on le trouve.
 **/
public class PassageSecret extends Piece {

    private Piece passageSecret;

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Passage secret");
    }

    /**
     * Permet d'ajouter un passage secret dans une pièce.
     **/
    public void ajoutPassageSecret(Piece p) {
        passageSecret = p;
    }


}
