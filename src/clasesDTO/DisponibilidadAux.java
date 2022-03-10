package clasesDTO;

public class DisponibilidadAux {
  
	private int idLugar;
	private int cantidad;
	private String nombreLugar;
	
	public int getIdLugar() {
		return idLugar;
	}
	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreLugar() {
		return nombreLugar;
	}
	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}
	public DisponibilidadAux(int idLugar, int cantidad, String nombreLugar) {
		super();
		this.idLugar = idLugar;
		this.cantidad = cantidad;
		this.nombreLugar = nombreLugar;
	}
	@Override
	public String toString() {
		return nombreLugar;
	}
	
	
	
}
