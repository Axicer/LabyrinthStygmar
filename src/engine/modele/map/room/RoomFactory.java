package engine.modele.map.room;

public class RoomFactory {

    private boolean setHasShortcut = false;

    public RoomFactory() {}

    public RoomFactory isShortcut(boolean shortcut){
        this.setHasShortcut = shortcut;
        return this;
    }

    public Room create(){
        Room room;
        if(setHasShortcut){
            room = new ShortcutRoom();
        }else{
            room = new Room();
        }
        return room;
    }
}
