package engine.modele.entity.player;

import engine.modele.objets.Medicament;

/**
 * Repr�sente qqch de vivant (avec de la vie)
 */
public interface Vivant {

    int getVie();

    void setVie(int vie);

    /**
     * Soigne avec un m�dicament donn�
     * @param m m�dicament donn�
     */
    void soigner(Medicament m);

    /**
     * Reset la vie � sa valeur d'origine
     */
    void guerir();

}
