package gestores;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.*;
import clasesDAO.*;
import clasesDTO.CompetenciaDTO;
import clasesDTO.ParticipanteDTO;
import conexionBDD.Acceso;


public class GestorCompetencia {

	public static ArrayList<Deporte> obtenerAllDeportes(){
		
		
	  ArrayList<Deporte> deportes=DeporteDAO.getAllDeporte();
		
		return deportes;
		
		
	}
	
public static int verificacionNombreParticipante(String nombre, int idCompe) {
		
		
		return ParticipanteDAO.getParticipanteByNombre(nombre, idCompe);
		
	}
	
	
	public static  boolean verificarNombreParticipante(String nombre, int idCompe) {
		
		if(GestorCompetencia.verificacionNombreParticipante(nombre, idCompe)!=0) {
			
			return true;
			
		}else {
			return false;
		}
	}
	public static Deporte getDeporteByID(int id){
		
			return DeporteDAO.getDeporteById(id);
			
			
		}
	
	public static Boolean verificarNombreCompetencia(String nombre) {
		
		
		
		return CompetenciaDao.getCompetenciaByNombre(nombre);
		
	}
	
	

	
	
	public static  int crearCompetencia(CompetenciaDTO dto) {
		
		if(GestorCompetencia.verificarNombreCompetencia(dto.getNombre())) {
			
			JOptionPane.showMessageDialog(null,"El nombre de la competencia no esta disponible");
			
			return -1;
			
		}
		else {
		
		Competencia nuevaCompetencia;
		Usuario user=GestorUsuario.getUsuarioByID(dto.getIdUsuario());
		Deporte deporte=GestorCompetencia.getDeporteByID(dto.getIdDeporte());
		Formadepuntuacion formaDePuntuacion=new Formadepuntuacion(dto.getFormaDePuntuacion(),dto.getCantMaxTantos(),dto.getCantMaxSets());
		SistemaLiga sistemaLiga=null;
		
		if(dto.getModalidad()=="Sistema Liga") {	
		sistemaLiga=new SistemaLiga(dto.getPuntosPartidoGanado(),dto.getPuntosEmpate(),dto.getPuntosPartidoJugado());
		nuevaCompetencia= new Competencia(deporte, formaDePuntuacion, user, dto.getNombre(), "creada"
				, dto.getReglamento(), dto.getModalidad(), sistemaLiga);
		}
		else {
		 nuevaCompetencia= new Competencia(deporte, formaDePuntuacion, user, dto.getNombre(), "creada"
					, dto.getReglamento(), dto.getModalidad());
		}		
		
		
		ArrayList<Disponibilidad> disponibilidades=new ArrayList<Disponibilidad>();
		int i=0;
		while(dto.getLugares().size()>i) {
			LugarDeRealizacion lugar=GestorLugarDeRealizacion.getLugarByID(dto.getLugares().get(i).getIdLugar());
			disponibilidades.add(new Disponibilidad(nuevaCompetencia,lugar,dto.getLugares().get(i).getCantidad()));
			i++;
		}
		nuevaCompetencia.setDisponibilidades(disponibilidades);
		nuevaCompetencia.setIdCompetencia(0);
		
		CompetenciaDao.setCompetencia(nuevaCompetencia);
		
	
		
		return 0;
		}
		
	}
	
	
	public static ArrayList<CompetenciaDTO> buscarCompetencias(String nombre,String estado,String modalidad,String deporte,int idUsuario){
		ArrayList<Competencia> competencia=CompetenciaDao.obtenerAllCompetencias();

		
		int tam=competencia.size();
		if(nombre!="all") {
			for(int i=0; i<tam;i++) {
				
				if(competencia.get(i).getNombreCompetencia().toLowerCase().compareTo(nombre)!=0) {
					
					competencia.remove(i);
					i--;
					tam=competencia.size();
				}	
			}
			}
		if(estado!="all") {
			for(int i=0; i<tam;i++) {
				
				if(competencia.get(i).getEstado().toLowerCase().compareTo(estado)!=0) {
					competencia.remove(i);
					i--;
					tam=competencia.size();
				}	
			}
			}
		if(modalidad!="all") {
			for(int i=0; i<tam;i++) {
				
				if(competencia.get(i).getModalidad().toLowerCase().compareTo(modalidad)!=0) {
					competencia.remove(i);
					i--;
					tam=competencia.size();
				}	
			}
			}
		if(deporte!="all") {
			for(int i=0; i<tam;i++) {
				
				if(competencia.get(i).getDeporte().getNombreDeporte().toLowerCase().compareTo(deporte)!=0) {
					competencia.remove(i);
					i--;
					tam=competencia.size();
				}	
			}
			}
		if(idUsuario!=0) {
			for(int i=0; i<tam;i++) {
				
				if(competencia.get(i).getUsuario().getIdUsuario()!=idUsuario) {
					competencia.remove(i);
					i--;
					tam=competencia.size();
				}	
			}
			}

		
		return GestorCompetencia.obtenerCompetenciasDTO(competencia);
	}
	
	
	public static ArrayList<CompetenciaDTO> obtenerCompetenciasDTO(ArrayList<Competencia> competencias){
		ArrayList<CompetenciaDTO> competenciasDTO=new ArrayList<CompetenciaDTO>();
		
		for(Competencia c:competencias) {
			CompetenciaDTO dto=new CompetenciaDTO();
			dto.setNombre(c.getNombreCompetencia());
			dto.setEstado(c.getEstado());
			dto.setModalidad(c.getModalidad());
			dto.setDeporte(c.getDeporte().getNombreDeporte().toLowerCase());
			dto.setIdCompetencia(c.getIdCompetencia());
			competenciasDTO.add(dto);
		}
	
		
		return competenciasDTO;
	}
	public static CompetenciaDTO obtenerCompetenciasDTO(Competencia c) {
		CompetenciaDTO dto= new CompetenciaDTO();
		ArrayList<String> participantes=new ArrayList<String>();
		dto.setNombre(c.getNombreCompetencia());
		dto.setEstado(c.getEstado());
		dto.setModalidad(c.getModalidad());
		dto.setDeporte(c.getDeporte().getNombreDeporte().toLowerCase());
		dto.setIdCompetencia(c.getIdCompetencia());
		for(Participante p:c.getParticipante()) {
			participantes.add(p.getNombre());
		}
		dto.setIdUsuario(c.getUsuario().getIdUsuario());
		dto.setParticipantes(participantes);
		
		
		return dto;
	}
	

	public static void darDeAltaParticipante(ParticipanteDTO p) {
		
		Competencia c=CompetenciaDao.getCompetenciaByID(p.getIdCompetencia());
		
		Participante participante= new Participante(c, p.getNombre()
				, p.getCorreo(), 0, 0, 0, 0, 0, 0, 0);
		c.addPartcipante(participante);
		c.setEstado("creada");
		c.setFixture(null);
		CompetenciaDao.setCompetencia(c);
		
}
	
}
