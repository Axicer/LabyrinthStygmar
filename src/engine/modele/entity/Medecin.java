package engine.modele.entity;

import engine.modele.map.room.Room;

public class Medecin extends Entity {

	  public Medecin(Room p)
	  {
		  super(p);
	  }

	  @Override
	  public void afficher()
	  {
		  System.out.println("Medecin");
	  }

}
