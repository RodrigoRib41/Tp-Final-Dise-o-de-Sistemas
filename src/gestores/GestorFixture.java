package gestores;
import gestores.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.*;
import clasesDAO.*;
import clasesDTO.*;
import conexionBDD.Acceso;

public class GestorFixture {
	
	public static int generarFixture(Competencia c) {
		
		if(!GestorFixture.validarDisponibilidad(c)) {
			System.out.println("NO HAY SUFICIENTE DISPONIBILIDAD ");	
			return 1;
		}
		if(c.getFixture()!=null) {
			System.out.println("EL FIXTURE YA EXISTE ");	
			return 2;
		}
		
		
		
		if(c.getModalidad().compareTo("Sistema Liga")==0 ) {
	
			Fixture f= new Fixture();
			f.setIdFixture(0);
			c.setFixture(f);
	        f.setCompetencia(c);
			
			ArrayList<Ronda> rondas= new ArrayList<Ronda>();
		
					System.out.println("---------GENERO TODAS LAS RONDAS-----------");		
					rondas=GestorFixture.generarRondas(c.getParticipante());
					int indiceLugar=0;
					int disponibilidadLugar;
					for(int i=0;i<rondas.size();i++) {
						disponibilidadLugar=c.getDisponibilidades().get(indiceLugar).getDisponibilidad();
						rondas.get(i).setFixture(f);
						rondas.get(i).setNombreRonda("Fecha "+(i+1));
						for(Encuentro e:rondas.get(i).getEncuentros()) {
							e.setLugarDeRealizacion(c.getDisponibilidades().get(indiceLugar).getLugarderealizacion());
							disponibilidadLugar--;
							if(disponibilidadLugar==0) {
								indiceLugar++;
								if(indiceLugar<c.getDisponibilidades().size()) {
								disponibilidadLugar=c.getDisponibilidades().get(indiceLugar).getDisponibilidad();
							}
								}
						}
						indiceLugar=0;
					}
			
			
				f.setRondas(rondas);
				System.out.println(f.getRondas().get(0).getEncuentros().size());
				System.out.println(f.getRondas().size());
				c.setEstado("planificada");
				CompetenciaDao.setCompetencia(c);                   
		
				return 0;
		
	}
		else {
			System.out.println("SOLAMENTE HACEMOS FIXTURES PARA LIGAS ");
		return 3
				;
		}
	}
	


/*
public static ArrayList<Encuentro> generarListaEncuentros(Competencia c){
	
	ArrayList<Encuentro>listaEncuentros=new ArrayList<Encuentro>();
	
	ArrayList<Participante>listaParticipante=c.getParticipante();
	int contadorAux=0;
	for(Participante p:listaParticipante ) {
		int contador=contadorAux;
		while(contador<(listaParticipante.size()-1)) {
			
			Encuentro e= new Encuentro();
			e.setParticipante1(p);
			e.setParticipante2(listaParticipante.get(contador+1));
			e.setLugarDeRealizacion(c.getDisponibilidades().get(0).getLugarderealizacion());
			
			
			
          listaEncuentros.add(e);	
			contador++;
		}
	contadorAux++;

}


	System.out.println("CANTIDAD DE ENCUENTROS--------"+listaEncuentros.size());
	
	return listaEncuentros;


}*/


public static ArrayList<Ronda> generarRondas(ArrayList<Participante> p){

	ArrayList<Participante> participantes=(ArrayList<Participante>) p.clone();
	ArrayList<Ronda> fechas=new ArrayList<Ronda>();
	if(participantes.size()%2==0) {
		
		for(int k=0;k<participantes.size();k++) {
			int i=0,j=participantes.size()-1;
			Ronda r=new Ronda();
			r.setIdRonda(0);
			while(i<j) {
			Encuentro e=new Encuentro();
			e.setParticipante1(participantes.get(i));
			e.setParticipante2(participantes.get(j));
			e.setIdEncuentro(0);
			e.setRonda(r);
			r.addEncuentro(e);
			
				i++;j--;
		}
		Participante aux=participantes.get(0);
		participantes.remove(0);
		participantes.add(aux);
		fechas.add(r);
		
		}
	}
	else {
		Participante libre=participantes.get(0);
		participantes.remove(0);
		for(int k=0;k<participantes.size()+1;k++) {
			int i=0,j=participantes.size()-1;
			Ronda r=new Ronda();
			r.setIdRonda(0);
			while(i<j) {
			Encuentro e=new Encuentro();
			e.setParticipante1(participantes.get(i));
			e.setParticipante2(participantes.get(j));
			e.setIdEncuentro(0);
			e.setRonda(r);
			r.addEncuentro(e);
			
				i++;j--;
		}
		participantes.add(libre);
		libre=participantes.get(0);
		participantes.remove(0);
		
		fechas.add(r);
		
		}
			
	}

	return fechas;
	
	
}




/*
public static boolean validarEncuentro(ArrayList<Encuentro> lista,Encuentro encuentro) {
	boolean valido=true;
	

	for(Encuentro e:lista) {
		if(e.getParticipante1().getIdParticipante()==encuentro.getParticipante1().getIdParticipante() ||
			    e.getParticipante1().getIdParticipante()==encuentro.getParticipante2().getIdParticipante() ||	 
			    e.getParticipante2().getIdParticipante()==encuentro.getParticipante2().getIdParticipante()||
			    e.getParticipante2().getIdParticipante()==encuentro.getParticipante1().getIdParticipante()
			    
				
				)  {
			valido=false;
		}
		
		
	}
	return valido;
}

/*public static void ordenarRondas(ArrayList<Ronda> lista,int indice) {
	Participante repetido=null;
	
	
	int ultimo=lista.get(indice).getEncuentros().size()-1;
	Encuentro aCambiar=lista.get(indice).getEncuentros().get(ultimo);

	lista.get(indice).getEncuentros().remove(aCambiar);
	
	for(Encuentro e:lista.get(indice).getEncuentros()) {
		if(e.getParticipante1()==aCambiar.getParticipante1() ||
			e.getParticipante2()==aCambiar.getParticipante1()	) {
			repetido=aCambiar.getParticipante1();
	
			
		}
		else if(e.getParticipante1()==aCambiar.getParticipante2() ||
				e.getParticipante2()==aCambiar.getParticipante2()) {
			repetido=aCambiar.getParticipante2();
		
		}};
		System.out.println(repetido.getNombre());

	boolean noJugo;
	Ronda candidata1=null;
	Ronda candidata2=null;
	int i=0;
	for(Ronda r:lista) {
		noJugo=true;
		for(Encuentro e:r.getEncuentros()) {
			
			if(e.getParticipante1()==repetido||e.getParticipante2()==repetido) {
				noJugo=false;}
		}
		if(noJugo) {
			if(i==0) {
				candidata1=r;
				i++;
			}
			else {
				candidata2=r;
				break;
			}
		}}
	System.out.println(candidata1.getEncuentros().size()+"---"+candidata2.getEncuentros().size());

	
    ArrayList<Encuentro> auxEncuentros=new ArrayList<Encuentro>();
	ArrayList<Ronda> auxRondas=new ArrayList<Ronda>();
	auxEncuentros.add(aCambiar);
	auxEncuentros.addAll(candidata1.getEncuentros());
	auxEncuentros.addAll(candidata2.getEncuentros());
	auxEncuentros.addAll(lista.get(indice).getEncuentros());
	System.out.println(auxEncuentros.size());

	
	System.out.println(candidata1.getIdRonda());

	auxRondas=GestorFixture.generarRondas(3,candidata1.getEncuentros().size(), auxEncuentros);
	lista.remove(candidata1);
	lista.remove(candidata2);
	lista.remove(indice);
	lista.addAll(auxRondas);}*/

public static boolean validarDisponibilidad(Competencia c) {

	int disponibilidadTotal=0;
	
	for(Disponibilidad d:c.getDisponibilidades()) {
		disponibilidadTotal=disponibilidadTotal+d.getDisponibilidad();
	}	
	return disponibilidadTotal>=(c.getParticipante().size()/2);
}

public static FixtureDTO obtenerFixture(int idCompetencia) {
	FixtureDTO dto=new FixtureDTO();
	
	Fixture f=FixtureDAO.getFixtureByCompetencia(CompetenciaDao.getCompetenciaByID(idCompetencia));
	
	
	
	for(Ronda r:f.getRondas()) {
		RondaDTO dtoR=new RondaDTO();
		dtoR.setNombreFecha(r.getNombreRonda());
		for(Encuentro e:r.getEncuentros()) {
			EncuentroDTO dtoE=new EncuentroDTO();
		dtoE.setP1(e.getParticipante1().getNombre());
		dtoE.setP2(e.getParticipante2().getNombre());
		dtoE.setL(e.getLugarDeRealizacion().getNombrelugar());	
		dtoR.add(dtoE);	
		}
		dto.addRonda(dtoR);
	}
	

	return dto;
	
}

}
