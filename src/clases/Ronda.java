package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ronda {
	 private int idRonda;
     private String nombreRonda;
     private Fixture fixture;
     private ArrayList<Encuentro> encuentros = new ArrayList<Encuentro>();
	public int getIdRonda() {
		return idRonda;
	}
	public void setIdRonda(int idRonda) {
		this.idRonda = idRonda;
	}
	public String getNombreRonda() {
		return nombreRonda;
	}
	public void setNombreRonda(String nombreRonda) {
		this.nombreRonda = nombreRonda;
	}
	public ArrayList<Encuentro> getEncuentros() {
		return encuentros;
	}
	public void addEncuentro(Encuentro encuentro) {
		this.encuentros.add(encuentro);
	}
	public void setEncuentros(ArrayList<Encuentro> encuentros) {
		this.encuentros=encuentros;
	}
	public Fixture getFixture() {
		return fixture;
	}
	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
	public Ronda() {
		super();
	}
	public Ronda(int idRonda,String nombre) {
		super();
		this.idRonda=idRonda;
		this.nombreRonda=nombre;
	
	}
     
	
     
	
	
}
