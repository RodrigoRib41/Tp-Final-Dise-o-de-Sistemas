package clases;

public class Disponibilidad {
	 
	
	private DisponibilidadId id;
     private Competencia competencia;
     private LugarDeRealizacion lugarderealizacion;
     private int disponibilidad;
	public DisponibilidadId getId() {
		return id;
	}
	public void setId(DisponibilidadId id) {
		this.id = id;
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public LugarDeRealizacion getLugarderealizacion() {
		return lugarderealizacion;
	}
	public void setLugarderealizacion(LugarDeRealizacion lugarderealizacion) {
		this.lugarderealizacion = lugarderealizacion;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	public Disponibilidad(Competencia competencia, LugarDeRealizacion lugarderealizacion, int disponibilidad) {
		super();
		this.competencia = competencia;
		this.lugarderealizacion = lugarderealizacion;
		this.disponibilidad = disponibilidad;
	}
	@Override
	public String toString() {
		return "Disponibilidad [lugarderealizacion=" + lugarderealizacion + ", disponibilidad=" + disponibilidad + "]";
	}


     
     
     

}
