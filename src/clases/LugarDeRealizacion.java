package clases;


import java.util.ArrayList;
import java.util.Set;

public class LugarDeRealizacion {

    private int idLugarDeRealizacion;
    private int idUsuario;
    private int codigo;
    private String nombrelugar;
    private ArrayList<Deporte> deportes = new ArrayList<Deporte>();
    private ArrayList<Disponibilidad> disponibilidades = new ArrayList<Disponibilidad>();
	
    
    
    public LugarDeRealizacion(int idLugarDeRealizacion, int usuario, int codigo, String nombrelugar) {
		super();
		this.idLugarDeRealizacion = idLugarDeRealizacion;
		this.idUsuario = usuario;
		this.codigo = codigo;
		this.nombrelugar = nombrelugar;
	}



	public int getIdLugarDeRealizacion() {
		return idLugarDeRealizacion;
	}



	public int getIdUsuario() {
		return idUsuario;
	}



	public int getCodigo() {
		return codigo;
	}



	public String getNombrelugar() {
		return nombrelugar;
	}



	public ArrayList<Deporte> getDeportes() {
		return deportes;
	}



	public ArrayList<Disponibilidad> getDisponibilidades() {
		return disponibilidades;
	}
	
	public void addDisponobilidad(Disponibilidad d) {
		disponibilidades.add(d);
	}
	public void addDeporte(Deporte d) {
		deportes.add(d);
	}



	@Override
	public String toString() {
		return  nombrelugar ;
	}
	
	
	
	
    
	
    
	
}
