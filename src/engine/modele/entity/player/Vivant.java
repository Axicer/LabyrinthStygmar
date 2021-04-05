package engine.modele.entity.player;

import engine.modele.objets.Medicament;

/**
 * Représente qqch de vivant (avec de la vie)
 */
public interface Vivant {

    int getVie();

    void setVie(int vie);

    /**
     * Soigne avec un médicament donné
     * @param m médicament donné
     */
    void soigner(Medicament m);

    /**
     * Reset la vie à sa valeur d'origine
     */
    void guerir();

}
