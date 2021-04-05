package engine.modele.entity.player;

import engine.modele.objets.Nourriture;

/**
 * Repr�sente qqch de fort (avec de la force)
 */
public interface Puissant {

    int getForce();

    void setForce(int force);

    /**
     * Redonne de la force en fonction de la nourriture donn�e
     * @param n nourriture donn�
     */
    void manger(Nourriture n);

    /**
     * Reset la force � sa valeur d'origine
     */
    void nourrir();

}
