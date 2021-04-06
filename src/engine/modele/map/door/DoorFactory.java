package engine.modele.map.door;

import engine.modele.map.room.Room;

public class DoorFactory {

    private Room A, B;
    private int id;
    private boolean useId, closed;

    public DoorFactory() {}

    public DoorFactory withFirstRoom(Room A){
        this.A = A;
        return this;
    }

    public DoorFactory withSecondRoom(Room B){
        this.B = B;
        return this;
    }

    public DoorFactory usingID(int id){
        this.id = id;
        this.useId = true;
        return this;
    }

    public DoorFactory withoutID(){
        this.useId = false;
        return this;
    }

    public DoorFactory closed(boolean close){
        this.closed = close;
        return this;
    }

    public Door create(){
        Door door;
        if(useId){
            door = new Door(A, B, id, closed);
        }else{
            door = new Door(A, B);
        }

        return door;
    }
}
