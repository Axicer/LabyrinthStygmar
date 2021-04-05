package engine.game;


import engine.modele.entity.*;
import engine.modele.objets.*;
import engine.modele.entity.player.Player;
import engine.modele.batiment.PassageSecret;
import engine.modele.batiment.Piece;
import engine.modele.batiment.Porte;

/**
 * Cette classe va creer les objets,les personnages, des portes, des pièces et ajoute des portes aux pièces.
 * 
 * */
public class Scenario {

    static public Entity[] entities;
    static public Objet[] objets;
    static public Player player;
    static public Tresor tresor;
    static public Key cl1;
    static public Key cl2;
    static public Key cl3;
    static public Piece p1;

    public Scenario() {
    	p1 = new Piece();
        Piece p2 = new Piece();
        Piece p3 = new Piece();
        Piece p4 = new Piece();
        Piece p5 = new Piece();
        Piece p6 = new Piece();
        Piece p7 = new Piece();
        PassageSecret p8 = new PassageSecret();

        // les portes
        Porte po1 = new Porte();
        Porte po2 = new Porte(3);
        Porte po3 = new Porte();
        Porte po4 = new Porte(2);
        Porte po5 = new Porte();
        Porte po6 = new Porte();
        Porte po7 = new Porte(2);
        Porte po8 = new Porte(3);
        
        // ajout de portes aux pièces
        p1.ajoutPorte(po1, p2, "Est");
        p1.ajoutPorte(po2, p5, "Nord");
        p2.ajoutPorte(po3, p3, "Est");
        p3.ajoutPorte(po4, p4, "Est");
        p5.ajoutPorte(po5, p6, "Est");
        p6.ajoutPorte(po6, p7, "Est");
        p6.ajoutPorte(po7, p8, "Nord");
        p7.ajoutPorte(po8, p3, "Sud");
        p8.ajoutPassageSecret(p3);
        
        // individus
        player = new Player(p6);
        MonsterFactory monsterFactory = new MonsterFactory().withDefaultForce();
        Monstre m1 = monsterFactory.inPiece(p1).create();
        Monstre m2 = monsterFactory.inPiece(p5).create();
        Cuisinier c1 = new Cuisinier(p7);
        Medecin m = new Medecin(p4);
        entities = new Entity[]{player, m1, m2, c1, m};

        // objets
        KeyFactory keyFactory = new KeyFactory();
        cl1 = keyFactory.inPiece(p5).withIdentifiant(1).create();
        cl2 = keyFactory.inPiece(p6).withIdentifiant(2).create();
        cl3 = keyFactory.inPiece(p7).withIdentifiant(3).create();

        Nourriture n1 = new Nourriture(p2);
        Medicament me1 = new Medicament(p3);
        Tresor t = new Tresor(p8);
        tresor = t;
        objets = new Objet[]{cl1, cl2, cl3, n1, me1, t};
    }
    
}
