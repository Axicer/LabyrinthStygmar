package engine.modele.entity;

import engine.modele.map.room.Room;

public class MonsterFactory {

    private Room room;
    private int force;
    private boolean useCustomForce = false;

    public MonsterFactory() {}

    public MonsterFactory inPiece(Room room){
        this.room = room;
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
        Monstre m = new Monstre(room);
        if(useCustomForce){
            m.setForce(force);
        }
        return m;
    }

}
