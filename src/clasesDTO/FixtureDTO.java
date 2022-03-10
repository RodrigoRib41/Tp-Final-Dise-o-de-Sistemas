package clasesDTO;

import java.util.ArrayList;

public class FixtureDTO {
	
	private ArrayList<RondaDTO> rondas=new ArrayList<RondaDTO>();

	public ArrayList<RondaDTO> getRondas() {
		return rondas;
	}

	public void setRondas(ArrayList<RondaDTO> rondas) {
		this.rondas = rondas;
	}
	public void addRonda(RondaDTO ronda) {
		this.rondas.add(ronda);
	}
	
	
	
	

}
