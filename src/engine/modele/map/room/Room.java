package engine.modele.map.room;

import engine.modele.Descriptible;
import engine.modele.map.Orientation;
import engine.modele.map.door.Door;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class Room implements Descriptible {

    private final EnumMap<Orientation, Door> doors;

    public Room() {
        doors = new EnumMap<>(Orientation.class);
    }

    public Optional<Door> getDoor(Orientation orientation){
        return Optional.ofNullable(doors.get(orientation));
    }

    @Override
    public void afficher() {
        for(Map.Entry<Orientation, Door> entry : doors.entrySet()){
            System.out.print("at "+entry.getKey()+" : ");
            Optional.ofNullable(entry.getValue()).ifPresent(Door::afficher);
        }
    }

    /**
     * Permet d'ajouter une porte à une pièce.
     **/
    public void ajoutPorte(Door door, Orientation orientation, boolean setOpposite) {
        //add door on this room
        doors.put(orientation, door);
        //get the other room and add door at opposite orientation
        if(setOpposite)door.getOppositeRoom(this).ifPresent(room -> room.ajoutPorte(door, orientation.getOpposite(), false));
    }

    public Optional<Room> getAdjacentRoom(Orientation orientation){
        return getDoor(orientation).flatMap(door -> door.getOppositeRoom(this));
    }
}
