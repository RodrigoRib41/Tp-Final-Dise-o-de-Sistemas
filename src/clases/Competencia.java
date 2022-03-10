package clases;

import java.util.ArrayList;



public class Competencia {
	
	
	private int idCompetencia;
    private Deporte deporte;
    private Formadepuntuacion formadepuntuacion;
    private Usuario usuario;
    private String nombreCompetencia;
    private String estado;
    private String reglamento;
    private String modalidad;
    private SistemaLiga sistemaLiga;
    private Fixture fixture;
    
    private ArrayList<Participante> participante = new ArrayList<Participante>();
    private ArrayList<Disponibilidad> disponibilidades = new ArrayList<Disponibilidad>();

	public int getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(int idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Formadepuntuacion getFormadepuntuacion() {
		return formadepuntuacion;
	}

	public void setFormadepuntuacion(Formadepuntuacion formadepuntuacion) {
		this.formadepuntuacion = formadepuntuacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombreCompetencia() {
		return nombreCompetencia;
	}

	public void setNombreCompetencia(String nombreCompetencia) {
		this.nombreCompetencia = nombreCompetencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getReglamento() {
		return reglamento;
	}

	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public SistemaLiga getSistemaLiga() {
		return sistemaLiga;
	}

	public void setSistemaLiga(SistemaLiga sistemaLiga) {
		this.sistemaLiga = sistemaLiga;
	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}

	public ArrayList<Participante> getParticipante() {
		return participante;
	}

	public void addPartcipante(Participante p) {
		this.participante.add(p);
	}

	public Competencia(Deporte deporte, Formadepuntuacion formadepuntuacion, Usuario usuario, String nombreCompetencia,
			String estado, String reglamento, String modalidad) {
		super();
		this.deporte = deporte;
		this.formadepuntuacion = formadepuntuacion;
		this.usuario = usuario;
		this.nombreCompetencia = nombreCompetencia;
		this.estado = estado;
		this.reglamento = reglamento;
		this.modalidad = modalidad;
	}

	public Competencia(Deporte deporte, Formadepuntuacion formadepuntuacion, Usuario usuario, String nombreCompetencia,
			String estado, String reglamento, String modalidad, SistemaLiga sistemaLiga) {
		super();
		this.deporte = deporte;
		this.formadepuntuacion = formadepuntuacion;
		this.usuario = usuario;
		this.nombreCompetencia = nombreCompetencia;
		this.estado = estado;
		this.reglamento = reglamento;
		this.modalidad = modalidad;
		this.sistemaLiga = sistemaLiga;
	}
	
	public Competencia(int idCompetencia,String nombreCompetencia,String estado,String reglamento,String modalidad) {
		this.idCompetencia= idCompetencia;
		this.nombreCompetencia=nombreCompetencia;
		this.estado=estado;
		this.reglamento=reglamento;
		this.modalidad=modalidad;
	}
	
	
	

	public ArrayList<Disponibilidad> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(ArrayList<Disponibilidad> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}
	public void setParticipante(ArrayList<Participante> participantes) {
		this.participante = participantes;
	}
	
	
	@Override
	public String toString() {
		return "Competencia [idCompetencia=" + idCompetencia + ", deporte=" + deporte + ", formadepuntuacion="
				+ formadepuntuacion + ", usuario=" + usuario + ", nombreCompetencia=" + nombreCompetencia + ", estado="
				+ estado + ", reglamento=" + reglamento + ", modalidad=" + modalidad + ", sistemaLiga=" + sistemaLiga
				+ ", fixture=" + fixture + ", participante=" + participante + ", disponibilidades=" + disponibilidades
				+ "]";
	}
	
	


	
    
    
    
    
   
}
