package clases;

import java.util.ArrayList;

public class Usuario {
	private int idUsuario;
    private Localidad localidad;
    private String nombre;
    private String apellido;
    private String contrase�a;
    private String correo;
    private String tipoDocumento;
    private int documento;
    private ArrayList<Competencia> competencias = new ArrayList<Competencia>();
    private ArrayList<LugarDeRealizacion> lugarderealizacions = new ArrayList<LugarDeRealizacion>();

    
    public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public ArrayList<Competencia> getCompetencias() {
		return competencias;
	}
	public void setCompetencias(ArrayList<Competencia> competencias) {
		this.competencias = competencias;
	}
	public ArrayList<LugarDeRealizacion> getLugarderealizacions() {
		return lugarderealizacions;
	}
	public void setLugarderealizacions(ArrayList<LugarDeRealizacion> lugarderealizacions) {
		this.lugarderealizacions = lugarderealizacions;
	}
	public Usuario(int idUsuario, Localidad localidad, String nombre, String apellido, String contrase�a, String correo,
			String tipoDocumento, int documento) {
		super();
		this.idUsuario = idUsuario;
		this.localidad = localidad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrase�a = contrase�a;
		this.correo = correo;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
	}
	
	
    
    
    
}
