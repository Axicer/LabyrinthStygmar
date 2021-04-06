package engine.game;

import engine.modele.map.Orientation;
import engine.modele.map.door.DoorFactory;
import engine.modele.map.room.RoomFactory;
import engine.modele.entity.*;
import engine.modele.objets.*;
import engine.modele.entity.player.Player;
import engine.modele.map.room.Room;
import engine.modele.map.door.Door;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scenario {

    private final List<Entity> entities;
    private final List<Room> rooms;
    private final Player player;
    private final List<Key> keys;
    private final List<Nourriture> foods;
    private final List<Medicament> drugs;
    private final Tresor chest;

    public Scenario() {
        rooms = new LinkedList<>();
        RoomFactory roomFactory = new RoomFactory().isShortcut(false);
        Room p1 = roomFactory.create();
        Room p2 = roomFactory.create();
        Room p3 = roomFactory.create();
        Room p4 = roomFactory.create();
        Room p5 = roomFactory.create();
        Room p6 = roomFactory.create();
        Room p7 = roomFactory.create();
        Room p8 = roomFactory.isShortcut(true).create();
        Collections.addAll(rooms, p1, p2, p3, p4, p5, p6, p7, p8);

        // doors
        DoorFactory doorFactory = new DoorFactory();
        Door po1 = doorFactory.withFirstRoom(p1).withSecondRoom(p2).withoutID().create();
        Door po2 = doorFactory.withFirstRoom(p1).withSecondRoom(p5).usingID(3).create();
        Door po3 = doorFactory.withFirstRoom(p2).withSecondRoom(p3).withoutID().create();
        Door po4 = doorFactory.withFirstRoom(p3).withSecondRoom(p4).usingID(2).create();
        Door po5 = doorFactory.withFirstRoom(p5).withSecondRoom(p6).withoutID().create();
        Door po6 = doorFactory.withFirstRoom(p6).withSecondRoom(p7).withoutID().create();
        Door po7 = doorFactory.withFirstRoom(p6).withSecondRoom(p8).usingID(2).create();
        Door po8 = doorFactory.withFirstRoom(p7).withSecondRoom(p3).usingID(3).create();

        // add doors to rooms
        p1.ajoutPorte(po1, Orientation.EAST, true);
        p1.ajoutPorte(po2, Orientation.NORTH, true);
        p2.ajoutPorte(po3, Orientation.EAST, true);
        p3.ajoutPorte(po4, Orientation.EAST, true);
        p5.ajoutPorte(po5, Orientation.EAST, true);
        p6.ajoutPorte(po6, Orientation.EAST, true);
        p6.ajoutPorte(po7, Orientation.NORTH, true);
        p7.ajoutPorte(po8, Orientation.SOUTH, true);

        // entities
        player = new Player(p6);
        MonsterFactory monsterFactory = new MonsterFactory().withDefaultForce();
        Monstre m1 = monsterFactory.inPiece(p1).create();
        Monstre m2 = monsterFactory.inPiece(p5).create();
        Cuisinier c1 = new Cuisinier(p7);
        Medecin m = new Medecin(p4);
        entities = new LinkedList<>();
        Collections.addAll(entities, player, m1, m2, c1, m);

        // objects
        KeyFactory keyFactory = new KeyFactory();
        Key cl1 = keyFactory.inPiece(p5).withIdentifiant(1).create();
        Key cl2 = keyFactory.inPiece(p6).withIdentifiant(2).create();
        Key cl3 = keyFactory.inPiece(p7).withIdentifiant(3).create();

        Nourriture n1 = new Nourriture(p2);
        Medicament me1 = new Medicament(p3);
        keys = new LinkedList<>();
        Collections.addAll(keys, cl1, cl2, cl3);
        foods = new LinkedList<>();
        Collections.addAll(foods, n1);
        drugs = new LinkedList<>();
        Collections.addAll(drugs, me1);

        chest = new Tresor(p8);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<? extends Objet> getObjects() {
        return Stream.of(keys, foods, drugs)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Player getPlayer() {
        return player;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public List<Medicament> getDrugs() {
        return drugs;
    }

    public List<Nourriture> getFoods() {
        return foods;
    }

    public Tresor getChest() {
        return chest;
    }
}
