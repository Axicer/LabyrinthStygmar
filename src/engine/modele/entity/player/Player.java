package engine.modele.entity.player;

import engine.game.MessageService;
import engine.game.Scenario;
import engine.modele.batiment.Piece;
import engine.modele.batiment.Porte;
import engine.modele.entity.Cuisinier;
import engine.modele.entity.Entity;
import engine.modele.entity.Medecin;
import engine.modele.entity.Monstre;
import engine.modele.objets.Key;
import engine.modele.objets.Medicament;
import engine.modele.objets.Nourriture;
import engine.modele.objets.Objet;

import java.util.Optional;

public class Player extends Entity implements Vivant, Puissant {

    public static final int START_FORCE = 10;
    public static final int START_VIE = 10;

    private int force;
    private int vie;

    public Objet[] inventaire;

    public Player(Piece p) {
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
        super.getPosition().afficher();
    }

    public Objet[] getInventaire() {
        return inventaire;
    }

    public boolean combat(Monstre m) {
        if (getPosition() != m.getPosition()) {
            return false;
        }

        boolean aGagné = false;
        MessageService.message = "Combat!!\n";
        int sommeForce = force + m.getForce();
        int tirage = (int) (Math.random() * sommeForce);
        MessageService.message += "tirage : " + tirage + "\n";
        if (tirage < this.force) { // si tirage compris entre 0 et force le joueur gagne
            MessageService.message += "Joueur gagne";
            aGagné = true;
        } else { // si tirage compris entre force et (force + force du monstre) le monstre gagne
            MessageService.message += "Monstre gagne";
            this.vie--;
        }

        return aGagné;
    }

    // -------------------  ATTRIBUTS PUISSANT  --------------------------------------

    @Override
    public void manger(Nourriture n) {
        force = Math.min(force + n.getForce(), START_FORCE);
        MessageService.message = "la force est maintenant de " + this.force;
    }

    @Override
    public void nourrir() {
        MessageService.message = "Nourrir";
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
        MessageService.message = "Les points de vie sont maintenant de " + vie;
    }

    @Override
    public void guerir() {
        MessageService.message = "Guerir";
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
    public boolean peutOuvrir(Porte p) {
        boolean open = false;
        if (!p.estFermé()) {//si la porte est déjà ouverte on passe
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
        return Optional.ofNullable((Monstre)anyOfType(Scenario.entities, Monstre.class).orElse(null));
    }

    public Optional<Medecin> getMedecinNearby() {
        return Optional.ofNullable((Medecin)anyOfType(Scenario.entities, Medecin.class).orElse(null));
    }

    public Optional<Cuisinier> getCuisinierNearby() {
        return Optional.ofNullable((Cuisinier)anyOfType(Scenario.entities, Cuisinier.class).orElse(null));
    }

    private Optional<? extends Entity> anyOfType(Entity[] entities, Class<? extends Entity> type) {
        for (Entity entity : entities) {
            if (type.isAssignableFrom(entity.getClass()) && entity.getPosition() == this.getPosition()) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

}
