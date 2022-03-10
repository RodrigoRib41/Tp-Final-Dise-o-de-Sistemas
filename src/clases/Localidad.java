package clases;

public class Localidad {
	
	private int idLocalidad;
    private Provincia provincia;
    private String nombreLocalidad;
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getNombreLocalidad() {
		return nombreLocalidad;
	}
	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}
	public Localidad(int idLocalidad, Provincia provincia, String nombreLocalidad) {
		super();
		this.idLocalidad = idLocalidad;
		this.provincia = provincia;
		this.nombreLocalidad = nombreLocalidad;
	}

    
    
}
