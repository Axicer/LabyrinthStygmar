package engine.modele.objets;

import engine.modele.map.room.Room;

public class KeyFactory {

    private Room room;
    private int identifiant;

    public KeyFactory() {}

    public KeyFactory inPiece(Room room){
        this.room = room;
        return this;
    }

    public KeyFactory withIdentifiant(int identifiant){
        this.identifiant = identifiant;
        return this;
    }

    public Key create(){
        return new Key(room, identifiant);
    }
}
