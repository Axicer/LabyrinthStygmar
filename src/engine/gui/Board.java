package engine.gui;

import java.awt.Graphics;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import engine.game.Game;
import engine.gui.texture.TextureRegistry;
import engine.modele.entity.player.Player;
import engine.modele.map.Orientation;
import engine.modele.map.room.Room;
import engine.modele.objets.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel {

    private final EnumMap<Orientation, JButton> doorButtons;
    private final EnumMap<Orientation, JButton> doorLockedButtons;
    private final List<JButton> keyButtons;
    private final JButton foodButton;
    private final JButton drugButton;
    private final JButton chestButton;
    private final JButton cookerButton;
    private final JButton monsterButton;
    private final JButton doctorButton;

    public Board() {
        this.doorButtons = new EnumMap<>(Orientation.class);
        this.doorLockedButtons = new EnumMap<>(Orientation.class);
        Stream.of(Orientation.values()).forEach(orientation -> {
            doorButtons.put(orientation, new JButton(""));
            doorLockedButtons.put(orientation, new JButton(""));
        });
        this.keyButtons = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            keyButtons.add(new JButton(""));
        }
        this.foodButton = new JButton("");
        this.drugButton = new JButton("");
        this.chestButton = new JButton("");
        this.cookerButton = new JButton("");
        this.monsterButton = new JButton("");
        this.doctorButton = new JButton("");

        //set textures
        doorButtons.get(Orientation.NORTH).setIcon(TextureRegistry.DOOR_NORTH);
        doorButtons.get(Orientation.EAST).setIcon(TextureRegistry.DOOR_EAST);
        doorButtons.get(Orientation.SOUTH).setIcon(TextureRegistry.DOOR_SOUTH);
        doorButtons.get(Orientation.WEST).setIcon(TextureRegistry.DOOR_WEST);

        doorLockedButtons.get(Orientation.NORTH).setIcon(TextureRegistry.LOCKED_DOOR_NORTH);
        doorLockedButtons.get(Orientation.EAST).setIcon(TextureRegistry.LOCKED_DOOR_EAST);
        doorLockedButtons.get(Orientation.SOUTH).setIcon(TextureRegistry.LOCKED_DOOR_SOUTH);
        doorLockedButtons.get(Orientation.WEST).setIcon(TextureRegistry.LOCKED_DOOR_WEST);

        keyButtons.forEach(button -> button.setIcon(TextureRegistry.KEY));

        chestButton.setIcon(TextureRegistry.CHEST);
        cookerButton.setIcon(TextureRegistry.COOKER);
        monsterButton.setIcon(TextureRegistry.MONSTER);
        doctorButton.setIcon(TextureRegistry.DOCTOR);
        foodButton.setIcon(TextureRegistry.FOOD);
        drugButton.setIcon(TextureRegistry.DRUG);

        //add element to panel
        this.add(doorButtons.get(Orientation.NORTH)).setBounds(this.getWidth() / 2 - 90, 0, 185, 155);
        this.add(doorButtons.get(Orientation.SOUTH)).setBounds(this.getWidth() / 2 - 90, this.getHeight() - 135, 185, 155);
        this.add(doorButtons.get(Orientation.WEST)).setBounds(0, this.getHeight() / 2 - 75, 150, 195);
        this.add(doorButtons.get(Orientation.EAST)).setBounds(this.getWidth() - 150, this.getHeight() / 2 - 75, 150, 195);

        this.add(doorLockedButtons.get(Orientation.NORTH)).setBounds(this.getWidth() / 2 - 90, 0, 185, 155);
        this.add(doorLockedButtons.get(Orientation.SOUTH)).setBounds(this.getWidth() / 2 - 90, this.getHeight() - 135, 185, 155);
        this.add(doorLockedButtons.get(Orientation.WEST)).setBounds(0, this.getHeight() / 2 - 75, 150, 195);
        this.add(doorLockedButtons.get(Orientation.EAST)).setBounds(this.getWidth() - 150, this.getHeight() / 2 - 75, 150, 195);

        this.add(keyButtons.get(0)).setBounds(this.getWidth() / 2 - 40, this.getHeight() / 2 - 55, 80, 65);
        this.add(keyButtons.get(1)).setBounds(this.getWidth() / 2 - 40, this.getHeight() / 2 + 10, 80, 65);
        this.add(keyButtons.get(2)).setBounds(this.getWidth() / 2 - 40, this.getHeight() / 2 + 75, 80, 65);

        this.add(foodButton).setBounds(70, this.getHeight() - 180, 75, 75);
        this.add(drugButton).setBounds(this.getWidth() / 2 - 30, this.getHeight() / 2 - 140, 50, 50);
        this.add(chestButton).setBounds(this.getWidth() / 2 - 150, this.getHeight() / 2 - 20, 70, 70);
        this.add(cookerButton).setBounds(this.getWidth() - 160, this.getHeight() - 210, 160, 195);
        this.add(monsterButton).setBounds(30, 30, 175, 160);
        this.add(doctorButton).setBounds(this.getWidth() - 170, 25, 140, 195);

        //define some parameters for every buttons
        getAllButtons().forEach(button -> {
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw background && player
        g.drawImage(TextureRegistry.BACKGROUND, 0, 0, this.getWidth(), this.getHeight(), this);
        g.drawImage(TextureRegistry.PLAYER, this.getWidth() / 2 + 20, this.getHeight() / 2 - 75, this);

        // permet de rendre visible les différents acteurs et objet du jeu.
        getAllButtons().forEach(button -> button.setVisible(false));

        final Player player = Game.getInstance().getScenario().getPlayer();
        final Room playerRoom = player.getRoom();
        Stream.of(Orientation.values()).forEach(orientation -> {
            playerRoom.getDoor(orientation).ifPresent(door -> {
                if (door.isClosed()) {
                    doorLockedButtons.get(orientation).setVisible(true);
                } else {
                    doorButtons.get(orientation).setVisible(true);
                }
            });
        });

        player.getCuisinierNearby().ifPresent(c -> {
            cookerButton.setVisible(true);
        });

        player.getMedecinNearby().ifPresent(m -> {
            doctorButton.setVisible(true);
        });

        player.getMonsterNearby().ifPresent(m -> {
            monsterButton.setVisible(true);
        });

        for (Objet objet : Game.getInstance().getScenario().getObjects()) {
            if (!objet.getPosition().equals(player.getRoom())) continue;

            if (objet instanceof Key) {
                if (objet.getIdentifiant() == 1) {
                    keyButtons.get(0).setVisible(true);
                }
                if (objet.getIdentifiant() == 2) {
                    keyButtons.get(1).setVisible(true);
                }
                if (objet.getIdentifiant() == 3) {
                    keyButtons.get(2).setVisible(true);
                }
            }
            if (objet instanceof Nourriture) {
                foodButton.setVisible(true);
            }
            if (objet instanceof Medicament) {
                drugButton.setVisible(true);
            }
            if (objet instanceof Tresor) {
                chestButton.setVisible(true);
            }
        }
    }

    private List<JButton> getAllButtons() {
        return Stream.of(doorButtons.values(), doorLockedButtons.values(), keyButtons, Arrays.asList(foodButton, drugButton, chestButton, cookerButton, monsterButton, doctorButton))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public EnumMap<Orientation, JButton> getDoorButtons() {
        return doorButtons;
    }

    public EnumMap<Orientation, JButton> getDoorLockedButtons() {
        return doorLockedButtons;
    }

    public List<JButton> getKeyButtons() {
        return keyButtons;
    }

    public JButton getChestButton() {
        return chestButton;
    }

    public JButton getCookerButton() {
        return cookerButton;
    }

    public JButton getDoctorButton() {
        return doctorButton;
    }

    public JButton getDrugButton() {
        return drugButton;
    }

    public JButton getFoodButton() {
        return foodButton;
    }

    public JButton getMonsterButton() {
        return monsterButton;
    }
}
