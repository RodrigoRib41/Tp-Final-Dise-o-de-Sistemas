package clasesDTO;

import java.util.ArrayList;

public class RondaDTO {

	private ArrayList<EncuentroDTO> encuentros=new ArrayList<EncuentroDTO>();
	private String nombreFecha;
	public ArrayList<EncuentroDTO> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(ArrayList<EncuentroDTO> encuentros) {
		this.encuentros = encuentros;
	}
	public void add(EncuentroDTO encuentro) {
		this.encuentros.add(encuentro);
	}
	public String getNombreFecha() {
		return nombreFecha;
	}
	public void setNombreFecha(String nombreFecha) {
		this.nombreFecha = nombreFecha;
	}
	@Override
	public String toString() {
		return nombreFecha;
	}
	
	
	
}
