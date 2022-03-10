package gestores;
import java.util.ArrayList;

import clases.*;
import clasesDAO.CompetenciaDao;
import clasesDAO.ParticipanteDAO;
import clasesDTO.*;
public class GestorParticipante {

	public static ArrayList<ParticipanteDTO> obtenerParticipanteDTO(ArrayList<Participante> participantes){
		 
		ArrayList<ParticipanteDTO> lista=new ArrayList<ParticipanteDTO>();
		
		for(Participante p:participantes) {
			ParticipanteDTO dto=new ParticipanteDTO();
			dto.setCorreo(p.getCorreo());
			dto.setNombre(p.getNombre());
	     lista.add(dto);
		}
		
		return lista;
	}
	
	} 
	
	
	

