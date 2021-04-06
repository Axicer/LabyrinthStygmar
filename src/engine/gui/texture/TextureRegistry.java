package engine.gui.texture;

import javax.swing.*;
import java.awt.*;

public class TextureRegistry {

    public static final Image BACKGROUND = Toolkit.getDefaultToolkit().getImage(TextureRegistry.class.getResource("/textures/map/room2.png"));
    public static final ImageIcon DOOR_NORTH = new ImageIcon(TextureRegistry.class.getResource("/textures/map/doors/unlocked/door_north.png"));
    public static final ImageIcon DOOR_SOUTH = new ImageIcon(TextureRegistry.class.getResource("/textures/map/doors/unlocked/door_south.png"));
    public static final ImageIcon DOOR_WEST = new ImageIcon(TextureRegistry.class.getResource("/textures/map/doors/unlocked/door_west.png"));
    public static final ImageIcon DOOR_EAST = new ImageIcon(TextureRegistry.class.getResource("/textures/map/doors/unlocked/door_east.png"));
    public static final ImageIcon LOCKED_DOOR_NORTH = new ImageIcon(TextureRegistry.class.getResource("/textures/map/doors/locked/locked_door_north.png"));
    public static final ImageIcon LOCKED_DOOR_SOUTH = new ImageIcon(TextureRegistry.class.getResource("/textures/map/doors/locked/locked_door_south.png"));
    public static final ImageIcon LOCKED_DOOR_WEST = new ImageIcon(TextureRegistry.class.getResource("/textures/map/doors/locked/locked_door_west.png"));
    public static final ImageIcon LOCKED_DOOR_EAST = new ImageIcon(TextureRegistry.class.getResource("/textures/map/doors/locked/locked_door_east.png"));

    public static final Image PLAYER = Toolkit.getDefaultToolkit().getImage(TextureRegistry.class.getResource("/textures/entities/player.png"));
    public static final ImageIcon COOKER = new ImageIcon(TextureRegistry.class.getResource("/textures/entities/cooker.png"));
    public static final ImageIcon MONSTER = new ImageIcon(TextureRegistry.class.getResource("/textures/entities/monster.png"));
    public static final ImageIcon DOCTOR = new ImageIcon(TextureRegistry.class.getResource("/textures/entities/doctor.png"));

    public static final ImageIcon CHEST = new ImageIcon(TextureRegistry.class.getResource("/textures/objects/chest.png"));
    public static final ImageIcon KEY = new ImageIcon(TextureRegistry.class.getResource("/textures/objects/key.png"));
    public static final ImageIcon FOOD = new ImageIcon(TextureRegistry.class.getResource("/textures/objects/food.png"));
    public static final ImageIcon DRUG = new ImageIcon(TextureRegistry.class.getResource("/textures/objects/drug.png"));

}
