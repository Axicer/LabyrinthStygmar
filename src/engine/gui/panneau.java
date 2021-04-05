package engine.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import engine.game.Scenario;
import engine.modele.entity.Entity;
import engine.modele.entity.player.Player;
import engine.modele.objets.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * La classe panneau qui comporte les méthodes paintComponent, fondecran, affichageJoueur ,
 * va nous permettre de donner une apparence à notre jeu.
 * Cette classe initialise également des JButton pour les portes, les objets et les personnages(autres que le Joueur) ,
 * ceux-çi vont permettre à l'utilisateur d'intéragir dans le jeu grâce à la souris.
 */

public class panneau extends JPanel {

    Player player = Scenario.player;
    Entity[] individuses = Scenario.entities;
    Objet[] objets = Scenario.objets;
    JButton nord = new JButton("");
    JButton sud = new JButton("");
    JButton ouest = new JButton("");
    JButton est = new JButton("");
    JButton nord1 = new JButton("");
    JButton sud1 = new JButton("");
    JButton ouest1 = new JButton("");
    JButton est1 = new JButton("");
    JButton key1 = new JButton("");
    JButton key2 = new JButton("");
    JButton key3 = new JButton("");
    JButton food = new JButton("");
    JButton med = new JButton("");
    JButton tresor = new JButton("");
    JButton cuisinier = new JButton("");
    JButton monstre = new JButton("");
    JButton medecin = new JButton("");


    /**
     * Donne une apparence (forme et image ) aux différents objets et personnages du jeu.
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        fondecran(g);
        affichageJoueur(g);

        this.add(nord).setBounds(this.getWidth() / 2 - 90, 0, 185, 155);
        this.add(nord1).setBounds(this.getWidth() / 2 - 90, 0, 185, 155);
        this.add(sud).setBounds(this.getWidth() / 2 - 90, this.getHeight() - 135, 185, 155);
        this.add(sud1).setBounds(this.getWidth() / 2 - 90, this.getHeight() - 135, 185, 155);
        this.add(ouest).setBounds(0, this.getHeight() / 2 - 75, 150, 195);
        this.add(ouest1).setBounds(0, this.getHeight() / 2 - 75, 150, 195);
        this.add(est).setBounds(this.getWidth() - 150, this.getHeight() / 2 - 75, 150, 195);
        this.add(est1).setBounds(this.getWidth() - 150, this.getHeight() / 2 - 75, 150, 195);
        this.add(key1).setBounds(this.getWidth() / 2 - 40, this.getHeight() / 2 - 55, 80, 65);
        this.add(key2).setBounds(this.getWidth() / 2 - 40, this.getHeight() / 2 + 10, 80, 65);
        this.add(key3).setBounds(this.getWidth() / 2 - 40, this.getHeight() / 2 + 75, 80, 65);
        this.add(food).setBounds(70, this.getHeight() - 180, 75, 75);
        this.add(med).setBounds(this.getWidth() / 2 - 30, this.getHeight() / 2 - 140, 50, 50);
        this.add(tresor).setBounds(this.getWidth() / 2 - 150, this.getHeight() / 2 - 20, 70, 70);
        this.add(cuisinier).setBounds(this.getWidth() - 160, this.getHeight() - 210, 160, 195);
        this.add(monstre).setBounds(30, 30, 175, 160);
        this.add(medecin).setBounds(this.getWidth() - 170, 25, 140, 195);

        ImageIcon Tresor = new ImageIcon(getClass().getResource("/images/tresor.png"));
        ImageIcon portenord = new ImageIcon(getClass().getResource("/images/portenord.png"));
        ImageIcon portesud = new ImageIcon(getClass().getResource("/images/portesud.png"));
        ImageIcon porteouest = new ImageIcon(getClass().getResource("/images/porteouest.png"));
        ImageIcon porteest = new ImageIcon(getClass().getResource("/images/porteest.png"));
        ImageIcon doornord = new ImageIcon(getClass().getResource("/images/doornord.png"));
        ImageIcon doorsud = new ImageIcon(getClass().getResource("/images/doorsud.png"));
        ImageIcon doorouest = new ImageIcon(getClass().getResource("/images/doorouest.png"));
        ImageIcon doorest = new ImageIcon(getClass().getResource("/images/doorest.png"));
        ImageIcon cle = new ImageIcon(getClass().getResource("/images/cle.png"));
        ImageIcon Cuisinier = new ImageIcon(getClass().getResource("/images/cuisinier.png"));
        ImageIcon Monstre = new ImageIcon(getClass().getResource("/images/monstre.png"));
        ImageIcon Medecin = new ImageIcon(getClass().getResource("/images/medecin.png"));
        ImageIcon Food = new ImageIcon(getClass().getResource("/images/nourriture.png"));
        ImageIcon Med = new ImageIcon(getClass().getResource("/images/medicament.png"));


        //Permet d'associer
        tresor.setIcon(Tresor);
        nord.setIcon(portenord);
        nord1.setIcon(doornord);
        sud.setIcon(portesud);
        sud1.setIcon(doorsud);
        ouest.setIcon(porteouest);
        ouest1.setIcon(doorouest);
        est.setIcon(porteest);
        est1.setIcon(doorest);
        key1.setIcon(cle);
        key2.setIcon(cle);
        key3.setIcon(cle);
        cuisinier.setIcon(Cuisinier);
        monstre.setIcon(Monstre);
        medecin.setIcon(Medecin);
        food.setIcon(Food);
        med.setIcon(Med);


        // permet de rendre visible les différents acteurs et objet du jeu.
        tresor.setVisible(false);
        nord.setVisible(false);
        nord1.setVisible(false);
        sud.setVisible(false);
        sud1.setVisible(false);
        ouest.setVisible(false);
        ouest1.setVisible(false);
        est.setVisible(false);
        est1.setVisible(false);
        key1.setVisible(false);
        key2.setVisible(false);
        key3.setVisible(false);
        food.setVisible(false);
        med.setVisible(false);
        cuisinier.setVisible(false);
        monstre.setVisible(false);
        medecin.setVisible(false);

        if (player.getPosition().AuNord() != null) {
            if (!player.getPosition().AuNord().estFermé()) {
                nord.setVisible(true);
            } else nord1.setVisible(true);
        }

        if (player.getPosition().AuSud() != null) {
            if (!player.getPosition().AuSud().estFermé()) {
                sud.setVisible(true);
            } else sud1.setVisible(true);
        }

        if (player.getPosition().AOuest() != null) {
            if (!player.getPosition().AOuest().estFermé()) {
                ouest.setVisible(true);
            } else ouest1.setVisible(true);
        }

        if (player.getPosition().AEst() != null) {
            if (!player.getPosition().AEst().estFermé()) {
                est.setVisible(true);
            } else est1.setVisible(true);
        }

        player.getCuisinierNearby().ifPresent(c -> {
            cuisinier.setVisible(true);
            player.nourrir();
        });

        player.getMedecinNearby().ifPresent(m -> {
            medecin.setVisible(true);
            player.guerir();
        });

        player.getMonsterNearby().ifPresent(m -> {
            monstre.setVisible(true);
            player.combat(m);
        });

        for (Objet objet : objets) {
            if (objet.getPosition() == player.getPosition()) {
                if (objet instanceof Key) {
                    if (objet.getIdentifiant() == 1) {
                        key1.setVisible(true);
                    }
                    if (objet.getIdentifiant() == 2) {
                        key2.setVisible(true);
                    }
                    if (objet.getIdentifiant() == 3) {
                        key3.setVisible(true);
                    }
                }
                if (objet instanceof Nourriture) {
                    food.setVisible(true);
                }
                if (objet instanceof Medicament) {
                    med.setVisible(true);
                }
                if (objet instanceof engine.modele.objets.Tresor) {
                    tresor.setVisible(true);
                }
            }
        }

    }

    /**
     * Image de l'arrière plan , cette image reste la même quelque soit a pièce où on se trouve.
     */
    private void fondecran(Graphics g) {
        Image img = Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/room2.png"));
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }


    /**
     * Permet l'affichage du Joueur.
     */
    private void affichageJoueur(Graphics g) {
        Image img5 = Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/joueur.png"));
        g.drawImage(img5, this.getWidth() / 2 + 20, this.getHeight() / 2 - 75, this);
    }


}
