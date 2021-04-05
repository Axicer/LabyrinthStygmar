package engine.modele.entity;

import engine.modele.batiment.Piece;

public class Medecin extends Entity {

	  public Medecin(Piece p)
	  {
		  super(p);
	  }

	  @Override
	  public void afficher()
	  {
		  System.out.println("Medecin");
	  }

}
