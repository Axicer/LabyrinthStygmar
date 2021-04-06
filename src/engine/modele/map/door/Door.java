package engine.modele.map.door;

import engine.modele.Descriptible;
import engine.modele.Identifiable;
import engine.modele.map.room.Room;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Door implements Descriptible, Identifiable {

    private Room A, B;
    private boolean closed;
    private int identifiant;

    public Door(Room A, Room B) {
        this(A, B, Integer.MIN_VALUE, false);
    }

    public Door(Room A, Room B, int i, boolean closed) {
        this.A = A;
        this.B = B;
        identifiant = i;
        this.closed = closed;
    }

    @Override
    public void afficher() {
        if (closed)
            System.out.println("porte fermé Numéro " + identifiant);
        else
            System.out.println("porte ouverte");

    }

    public void setA(Room a) {
        A = a;
    }

    public Room getA() {
        return A;
    }

    public void setB(Room b) {
        B = b;
    }

    public Room getB() {
        return B;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isClosed() {
        return closed;
    }

	@Override
	public int getIdentifiant() {
		return identifiant;
	}

	@Override
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public void open() {
        closed = false;
    }

    public Optional<Room> getOppositeRoom(Room p) {
        if(!Arrays.asList(A, B).contains(p))return Optional.empty();
        return Optional.of(p.equals(A) ? B : A);
    }
}
