package engine.modele.entity;

import engine.modele.batiment.Piece;

public class MonsterFactory {

    private Piece piece;
    private int force;
    private boolean useCustomForce = false;

    public MonsterFactory() {}

    public MonsterFactory inPiece(Piece piece){
        this.piece = piece;
        return this;
    }

    public MonsterFactory withForce(int force){
        this.force = force;
        useCustomForce = true;
        return this;
    }

    public MonsterFactory withDefaultForce(){
        useCustomForce = false;
        return this;
    }

    public Monstre create(){
        Monstre m = new Monstre(piece);
        if(useCustomForce){
            m.setForce(force);
        }
        return m;
    }

}
