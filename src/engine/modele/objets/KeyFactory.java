package engine.modele.objets;

import engine.modele.batiment.Piece;

public class KeyFactory {

    private Piece piece;
    private int identifiant;

    public KeyFactory() {}

    public KeyFactory inPiece(Piece piece){
        this.piece = piece;
        return this;
    }

    public KeyFactory withIdentifiant(int identifiant){
        this.identifiant = identifiant;
        return this;
    }

    public Key create(){
        return new Key(piece, identifiant);
    }
}
