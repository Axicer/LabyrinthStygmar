package engine.modele.map;

public enum Orientation {

    NORTH,EAST,SOUTH,WEST;

    public Orientation getOpposite(){
        switch (this){
            case SOUTH: return NORTH;
            case NORTH: return SOUTH;
            case EAST: return WEST;
            case WEST: return EAST;
            default: return null;
        }
    }

}
