package engine.modele.entity;

import engine.modele.Descriptible;
import engine.modele.map.Orientation;
import engine.modele.map.room.Room;

public abstract class Entity implements Descriptible {

    private Room position;

    public Entity(Room p) {
        position = p;
    }

    public void move(Orientation orientation) {
        position.getAdjacentRoom(orientation).ifPresent(room -> position = room);
    }

    public void setPosition(Room position) {
        this.position = position;
    }

    public Room getRoom() {
        return position;
    }
}
