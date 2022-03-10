package clases;

import java.util.ArrayList;

public class Fixture {
	 private int idFixture;
     private Competencia competencia;
     private ArrayList<Ronda> rondas = new ArrayList<Ronda>();
	public int getIdFixture() {
		return idFixture;
	}
	public void setIdFixture(int idFixture) {
		this.idFixture = idFixture;
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public ArrayList<Ronda> getRondas() {
		return rondas;
	}
	public void setRondas(ArrayList<Ronda> rondas) {
		this.rondas = rondas;
	}



}
