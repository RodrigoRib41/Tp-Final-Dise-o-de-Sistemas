package clasesDTO;

import java.util.ArrayList;

public class CompetenciaDTO {

	String nombre;
    int idDeporte;
    int idCompetencia;
    ArrayList<DisponibilidadAux> lugares;
    ArrayList<String> participantes;
	String modalidad;
    String formaDePuntuacion;
    String deporte;
    String estado;
    int cantMaxSets;
    int cantMaxTantos;
    int puntosPartidoGanado;
    int puntosPartidoJugado;
    int puntosEmpate=0;
    int idUsuario;
    String Reglamento;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdDeporte() {
		return idDeporte;
	}
	public int getIdCompetencia() {
		return idCompetencia;
	}
	public void setIdCompetencia(int idCompetencia) {
		this.idCompetencia=idCompetencia;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}
	public ArrayList<DisponibilidadAux> getLugares() {
		return lugares;
	}
	public void setLugares(ArrayList<DisponibilidadAux> lugares) {
		this.lugares = lugares;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getFormaDePuntuacion() {
		return formaDePuntuacion;
	}
	public void setFormaDePuntuacion(String formaDePuntuacion) {
		this.formaDePuntuacion = formaDePuntuacion;
	}
	public int getCantMaxSets() {
		return cantMaxSets;
	}
	public void setCantMaxSets(int cantMaxSets) {
		this.cantMaxSets = cantMaxSets;
	}
	public int getCantMaxTantos() {
		return cantMaxTantos;
	}
	public void setCantMaxTantos(int cantMaxTantos) {
		this.cantMaxTantos = cantMaxTantos;
	}
	public int getPuntosPartidoGanado() {
		return puntosPartidoGanado;
	}
	public void setPuntosPartidoGanado(int puntosPartidoGanado) {
		this.puntosPartidoGanado = puntosPartidoGanado;
	}
	public int getPuntosPartidoJugado() {
		return puntosPartidoJugado;
	}
	public void setPuntosPartidoJugado(int puntosPartidoJugado) {
		this.puntosPartidoJugado = puntosPartidoJugado;
	}
	public int getPuntosEmpate() {
		return puntosEmpate;
	}
	public void setPuntosEmpate(int puntosEmpate) {
		this.puntosEmpate = puntosEmpate;
	}
	public String getReglamento() {
		return Reglamento;
	}
	public void setReglamento(String reglamento) {
		Reglamento = reglamento;
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	public ArrayList<String> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(ArrayList<String> participantes) {
		this.participantes = participantes;
	}
	@Override
	public String toString() {
		return "CompetenciaDTO [nombre=" + nombre + ", idDeporte=" + idDeporte + ", lugares=" + lugares + ", modalidad="
				+ modalidad + ", formaDePuntuacion=" + formaDePuntuacion + ", cantMaxSets=" + cantMaxSets
				+ ", cantMaxTantos=" + cantMaxTantos + ", puntosPartidoGanado=" + puntosPartidoGanado
				+ ", puntosPartidoJugado=" + puntosPartidoJugado + ", puntosEmpate=" + puntosEmpate + ", Reglamento="
				+ Reglamento + "]";
	}
    
    
    
	
}
