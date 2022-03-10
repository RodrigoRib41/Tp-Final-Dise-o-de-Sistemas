package clases;

import java.util.ArrayList;
import java.util.Set;

public class Encuentrosets extends Resultado {
	
    private int cantMaxSet;
    private int cantSetEq1;
    private int cantSetEq2;
    private ArrayList<SetJuego> sets = new ArrayList<SetJuego>();
	
	public int getCantMaxSet() {
		return cantMaxSet;
	}
	public void setCantMaxSet(int cantMaxSet) {
		this.cantMaxSet = cantMaxSet;
	}
	public int getCantSetEq1() {
		return cantSetEq1;
	}
	public void setCantSetEq1(int cantSetEq1) {
		this.cantSetEq1 = cantSetEq1;
	}
	public int getCantSetEq2() {
		return cantSetEq2;
	}
	public void setCantSetEq2(int cantSetEq2) {
		this.cantSetEq2 = cantSetEq2;
	}
	public ArrayList<SetJuego> getSets() {
		return sets;
	}
	public void setSets(ArrayList<SetJuego> sets) {
		this.sets = sets;
	}

}
