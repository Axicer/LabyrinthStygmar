package engine.modele.entity.player;

import engine.modele.objets.Nourriture;

/**
 * Représente qqch de fort (avec de la force)
 */
public interface Puissant {

    int getForce();

    void setForce(int force);

    /**
     * Redonne de la force en fonction de la nourriture donnée
     * @param n nourriture donné
     */
    void manger(Nourriture n);

    /**
     * Reset la force à sa valeur d'origine
     */
    void nourrir();

}
