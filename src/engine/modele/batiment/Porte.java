package engine.modele.batiment;

import engine.modele.Descriptible;
import engine.modele.Identifiable;

public class Porte implements Descriptible, Identifiable {

    private Piece devant;
    private Piece derriere;
    private boolean ferme;
    private int identifiant;

    /**
     * Permet de savoir si une porte est fermée ou ouverte.
     **/
    public Porte() {
        ferme = false;
        identifiant = -1;
    }

    /**
     * L'utilisation de cette méthode permet de fermer une porte et de lui attribuer un numero.
     **/
    public Porte(int i) {
        identifiant = i;
        ferme = true;
    }

    /**
     * Si une porte est fermée , cette méthode affiche son numéro , sinon affiche que la porte est ouverte.
     **/
    @Override
    public void afficher() {
        if (ferme)
            System.out.println("porte fermé Numéro " + identifiant);
        else
            System.out.println("porte ouverte");

    }

    /**
     * Permet d'ajouter une pièce en fonction de sa pièce voisine.
     **/
    public void ajoutPiece(Piece p1, Piece p2) {
        devant = p1;
        derriere = p2;
    }


    public Piece autrePiece(Piece p) {
        if (devant == p)
            return derriere;
        else
            return devant;
    }

    public boolean estFermé() {
        return ferme;
    }

	@Override
	public int getIdentifiant() {
		return identifiant;
	}

	@Override
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public void ouvrir() {
        ferme = false;
    }
}
