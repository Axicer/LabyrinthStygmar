package engine.modele.entity;

import engine.modele.Descriptible;
import engine.modele.batiment.Piece;

public abstract class Entity implements Descriptible {

    private Piece position;

    public Entity(Piece p) {
        position = p;
    }

    public void move(char r) {
        position = position.possedePieceVoisine(r);
    }

    public void setPosition(Piece position) {
        this.position = position;
    }

    public Piece getPosition() {
        return position;
    }
}
