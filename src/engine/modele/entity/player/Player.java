package engine.modele.entity.player;

import engine.game.Game;
import engine.game.Scenario;
import engine.modele.map.room.Room;
import engine.modele.map.door.Door;
import engine.modele.entity.Cuisinier;
import engine.modele.entity.Entity;
import engine.modele.entity.Medecin;
import engine.modele.entity.Monstre;
import engine.modele.objets.Key;
import engine.modele.objets.Medicament;
import engine.modele.objets.Nourriture;
import engine.modele.objets.Objet;

import java.util.List;
import java.util.Optional;

public class Player extends Entity implements Vivant, Puissant {

    public static final int START_FORCE = 10;
    public static final int START_VIE = 10;

    private int force;
    private int vie;

    public Objet[] inventaire;

    public Player(Room p) {
        super(p);
        force = START_FORCE;
        vie = START_VIE;
        inventaire = new Objet[4];
    }

    @Override
    public void afficher() {
        System.out.println();
        System.out.println("JOUEUR force : " + force + " et de point de vie : " + vie);

        // compte objet du joueur
        int nbObj = 0;
        for (int i = 0; i < inventaire.length; i++) {
            if (inventaire[i] != null) {
                System.out.print("Objet en " + i + " : ");
                inventaire[i].afficher();
                nbObj++;
            }
        }
        if (nbObj == 0) {
            System.out.println("pas d'objet sur le joueur");
        }

        // pièce
        System.out.println("Dans la pièce du joueur");
        super.getRoom().afficher();
    }

    public Objet[] getInventaire() {
        return inventaire;
    }

    public boolean fight(Monstre m) {
        if (getRoom() != m.getRoom()) {
            return false;
        }

        boolean won = false;
        int sommeForce = force + m.getForce();
        int tirage = (int) (Math.random() * sommeForce);
        if (tirage < this.force) { // si tirage compris entre 0 et force le joueur gagne
            won = true;
        } else { // si tirage compris entre force et (force + force du monstre) le monstre gagne
            this.vie--;
        }

        return won;
    }

    // -------------------  ATTRIBUTS PUISSANT  --------------------------------------

    @Override
    public void manger(Nourriture n) {
        force = Math.min(force + n.getForce(), START_FORCE);
    }

    @Override
    public void nourrir() {
        force = START_FORCE;
    }

    @Override
    public int getForce() {
        return force;
    }

    @Override
    public void setForce(int force) {
        this.force = force;
    }

    // --------------------  ATTRIBUTS VIVANT  ---------------------------------------

    @Override
    public void soigner(Medicament m) {
        vie = Math.min(vie + m.getVie(), START_FORCE);
    }

    @Override
    public void guerir() {
        vie = START_VIE;
    }

    @Override
    public int getVie() {
        return vie;
    }

    @Override
    public void setVie(int vie) {
        this.vie = vie;
    }

    // ------------------------  VERIFICATIONs ---------------------------------------

    /**
     * Cette méthode permet d'ouvrir une porte fermé, si la porte est fermé à clé ,
     * on va parcourir tous les objets de notre inventaire pour savoir si le joueur
     * possède la clé correspondant au numéro de la porte fermée.
     */
    public boolean peutOuvrir(Door p) {
        boolean open = false;
        if (!p.isClosed()) {//si la porte est déjà ouverte on passe
            open = true;
        } else {
            for (Objet objet : inventaire) {
                if (objet instanceof Key) {
                    if (objet.getIdentifiant() == p.getIdentifiant()) {
                        open = true;
                        break;
                    }
                }
            }
        }
        return open;
    }

    public Optional<Monstre> getMonsterNearby() {
        return Optional.ofNullable((Monstre)anyOfType(Game.getInstance().getScenario().getEntities(), Monstre.class).orElse(null));
    }

    public Optional<Medecin> getMedecinNearby() {
        return Optional.ofNullable((Medecin)anyOfType(Game.getInstance().getScenario().getEntities(), Medecin.class).orElse(null));
    }

    public Optional<Cuisinier> getCuisinierNearby() {
        return Optional.ofNullable((Cuisinier)anyOfType(Game.getInstance().getScenario().getEntities(), Cuisinier.class).orElse(null));
    }

    private Optional<? extends Entity> anyOfType(List<Entity> entities, Class<? extends Entity> type) {
        for (Entity entity : entities) {
            if (type.isAssignableFrom(entity.getClass()) && entity.getRoom().equals(this.getRoom())) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

}
