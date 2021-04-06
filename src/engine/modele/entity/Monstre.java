package engine.modele.entity;

import engine.modele.objets.Nourriture;
import engine.modele.map.room.Room;
import engine.modele.entity.player.Puissant;

public class Monstre extends Entity implements Puissant {

	private static final int MINFORCE = 5;
	private static final int MAXFORCE = 10;

	private int force;
	
	/**
	 *Ce constructeur défini la force comme étant une valeur aléatoire entre 5 et 20.
	 **/
	public Monstre(Room p)
	{
		super(p);
		force = MINFORCE + (int) (Math.random()*( MAXFORCE - MINFORCE +1));
	}

	@Override
	public void afficher()
	{
		System.out.println("Monstre de force : "+force);
	}

	@Override
	public int getForce()
	{
		return force;
	}

	@Override
	public void setForce(int force) {
		this.force = force;
	}

	@Override
	public void manger(Nourriture n) {
		force = Math.min(force + n.getForce(), MINFORCE);
	}

	@Override
	public void nourrir() {
		force = MINFORCE + (int) (Math.random()*( MAXFORCE - MINFORCE +1));
	}


}
