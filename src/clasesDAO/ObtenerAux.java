package clasesDAO;
import conexionBDD.Acceso;

import gestores.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.*;
import clasesDTO.*;
public class ObtenerAux {

	public static void main(String[] args) {
		
		Competencia competencia=CompetenciaDao.getCompetenciaByID(3);
	
		FixtureDAO.eliminarFixture(competencia.getFixture());
		//GestorFixture.generarFixture(competencia);
		
		/*	
		ArrayList<Participante> participantes=(ArrayList<Participante>)competencia.getParticipante().clone();
		ArrayList<Ronda> fechas=new ArrayList<Ronda>();
		ArrayList<Encuentro> encuentro=new ArrayList<Encuentro>();
		if(participantes.size()%2==0) {
			
			for(int k=0;k<participantes.size();k++) {
				int i=0,j=participantes.size()-1;
				Ronda r=new Ronda();
				while(i<j) {
				Encuentro e=new Encuentro();
				e.setParticipante1(participantes.get(i));
				e.setParticipante2(participantes.get(j));
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
				while(i<j) {
				Encuentro e=new Encuentro();
				e.setParticipante1(participantes.get(i));
				e.setParticipante2(participantes.get(j));
				r.addEncuentro(e);
				
					i++;j--;
			}
			participantes.add(libre);
			libre=participantes.get(0);
			participantes.remove(0);
			
			fechas.add(r);
			
			}
			
			
			
			
			
			
		}
		
		for(int i=0;i<fechas.size();i++) {
			System.out.println("FECHA: "+(i+1));
		
			for(Encuentro e:fechas.get(i).getEncuentros()) {
				System.out.println(e.getParticipante1().getNombre()+"---VS---"+e.getParticipante2().getNombre());
				
			}
			System.out.println("-----------------");
			
		}	
		
		
		
		
		//
		
		//GestorFixture.generarFixture(competencia);
	
	/*for(Ronda fecha:competencia.getFixture().getRondas()) {
			System.out.println("-----"+fecha.getNombreRonda()+"-----");
			
			for(Encuentro e:fecha.getEncuentros()) {
				
				System.out.println(e.getParticipante1().getNombre()+"---VS----"+e.getParticipante2().getNombre()+"----lugar:"
						+e.getLugarDeRealizacion().getNombrelugar());
			}
			
		}
	   
		
		/*ArrayList<Encuentro> listaEncuentros=GestorFixture.generarListaEncuentros(competencia);
		
		int cantRondas;
		if(competencia.getParticipante().size()%2==0) {
			cantRondas=competencia.getParticipante().size()-1;
			
		}
		else {
			cantRondas=competencia.getParticipante().size();
			
		}
		int cantPartidos=competencia.getParticipante().size()/2;
	for(Encuentro e:listaEncuentros) {
			
			System.out.println(e.getParticipante1().getNombre()+"------VS------"+e.getParticipante2().getNombre());
			
		}
		ArrayList<Ronda> fechas=GestorFixture.generarRondas(cantRondas,cantPartidos, listaEncuentros);
		
	
		for(Ronda r:fechas) {
			System.out.println("----- "+r.getNombreRonda()+"------");
			for(Encuentro e:r.getEncuentros()){
				System.out.println(e.getParticipante1().getNombre()+"----VS----"+e.getParticipante2().getNombre());	
				
				
			}
		
			
		}
		
		
		
	/*
			ArrayList<Encuentro> listaEncuentros=GestorFixture.generarListaEncuentros(competencia);

		ArrayList<Encuentro> fecha1=new ArrayList<Encuentro>();
		ArrayList<Encuentro> fecha2=new ArrayList<Encuentro>();
		ArrayList<Encuentro> fecha3=new ArrayList<Encuentro>();
		ArrayList<Encuentro> fecha4=new ArrayList<Encuentro>();
		ArrayList<Encuentro> fecha5=new ArrayList<Encuentro>();
		ArrayList<Encuentro> fecha6=new ArrayList<Encuentro>();
		ArrayList<Encuentro> fecha7=new ArrayList<Encuentro>();
		int indice;
		int i;
		
	/*	i=0;
		while(i<4) {
		
			boolean valido=true; 
			indice=(int) Math.floor(Math.random()*(listaEncuentros.size())); 
			for(Encuentro e:fecha1) {
			 if(e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante() ||
					    e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante() || 
					    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante()||
					    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante()) 
			 {valido=false;}}
		
			 if(valido) {
				 System.out.println("PARTIDO VALIDO:"+listaEncuentros.get(indice).getParticipante1().getNombre() +"---VS---"+listaEncuentros.get(indice).getParticipante2().getNombre());
				 fecha1.add(listaEncuentros.get(indice));
				 listaEncuentros.remove(indice);
				 i++;
			 }
			
		}
		i=0;
		while(i<4) {
	
			boolean valido=true; 
			indice=(int) Math.floor(Math.random()*(listaEncuentros.size())); 
			for(Encuentro e:fecha2) {
			 if(e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante() ||
					    e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante() || 
					    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante()||
					    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante()) 
			 {valido=false;}}
		
			 if(valido) {
				 System.out.println("PARTIDO VALIDO:"+listaEncuentros.get(indice).getParticipante1().getNombre() +"---VS---"+listaEncuentros.get(indice).getParticipante2().getNombre());
				 fecha2.add(listaEncuentros.get(indice));
				 listaEncuentros.remove(indice);
				 i++;
			 }
			
		}
		i=0;
		while(i<4) {
			
			boolean valido=true; 
			indice=(int) Math.floor(Math.random()*(listaEncuentros.size())); 
			for(Encuentro e:fecha3) {
			 if(e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante() ||
					    e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante() || 
					    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante()||
					    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante()) 
			 {valido=false;}}
		
			 if(valido) {
				 System.out.println("PARTIDO VALIDO:"+listaEncuentros.get(indice).getParticipante1().getNombre() +"---VS---"+listaEncuentros.get(indice).getParticipante2().getNombre());
				 fecha3.add(listaEncuentros.get(indice));
				 listaEncuentros.remove(indice);
				 i++;
			 }
			
		}
		
		i=0;
		while(i<4) {
			
			boolean valido=true; 
			indice=(int) Math.floor(Math.random()*(listaEncuentros.size())); 
			for(Encuentro e:fecha4) {
			 if(e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante() ||
			    e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante() || 
			    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante()||
			    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante()
					 )
			 {valido=false;}}
		
			 if(valido) {
				 System.out.println("PARTIDO VALIDO:"+listaEncuentros.get(indice).getParticipante1().getNombre() +"---VS---"+listaEncuentros.get(indice).getParticipante2().getNombre());
				 fecha4.add(listaEncuentros.get(indice));
				 listaEncuentros.remove(indice);
				 i++;
			 }
			
		}
	
		
	
		i=0;
		while(i<4) {
			
			boolean valido=true; 
			indice=(int) Math.floor(Math.random()*(listaEncuentros.size())); 
			for(Encuentro e:fecha5) {
			 if(e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante() ||
			    e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante() || 
			    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante()||
			    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante())
			 {valido=false;}}
		
			 if(valido) {
				 fecha5.add(listaEncuentros.get(indice));
				 listaEncuentros.remove(indice);
				 i++;
			 }
			
		}
		i=0;
		while(i<4) {
		
			boolean valido=true; 
			indice=(int) Math.floor(Math.random()*(listaEncuentros.size())); 
			for(Encuentro e:fecha6) {
			 if(e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante() ||
			    e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante() || 
			    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante()||
			    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante()) 
			 {valido=false;}}
		
			 if(valido) {
				 fecha6.add(listaEncuentros.get(indice));
				 listaEncuentros.remove(indice);
				 i++;
			 }
			
		}
		i=0;
		while(i<4) {
			
			boolean valido=true; 
			indice=(int) Math.floor(Math.random()*(listaEncuentros.size())); 
			for(Encuentro e:fecha7) {
			 if(e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante() ||
			    e.getParticipante1().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante() || 
			    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante2().getIdParticipante()||
			    e.getParticipante2().getIdParticipante()==listaEncuentros.get(indice).getParticipante1().getIdParticipante()) 
			 {valido=false;}}
		
			 if(valido) {
				 fecha7.add(listaEncuentros.get(indice));
				 listaEncuentros.remove(indice);
				 i++;
			 }
			
		}
		System.out.println("---ENCUENTROS FECHA1----");
		for(Encuentro e:fecha1) {
			
			System.out.println(e.getParticipante1().getNombre()+"------vs-----"+e.getParticipante2().getNombre());
		}
		System.out.println("---ENCUENTROS FECHA2----");
		for(Encuentro e:fecha2) {
			
			System.out.println(e.getParticipante1().getNombre()+"------vs-----"+e.getParticipante2().getNombre());
		}
		System.out.println("---ENCUENTROS FECHA3----");
		for(Encuentro e:fecha3) {
			
			System.out.println(e.getParticipante1().getNombre()+"------vs-----"+e.getParticipante2().getNombre());
		}
	
		System.out.println("---ENCUENTROS FECHA4----");
		for(Encuentro e:fecha4) {
			
			System.out.println(e.getParticipante1().getNombre()+"------vs-----"+e.getParticipante2().getNombre());
		}
		System.out.println("---ENCUENTROS FECHA5----");
		for(Encuentro e:fecha5) {
			
			System.out.println(e.getParticipante1().getNombre()+"------vs-----"+e.getParticipante2().getNombre());
		}
		System.out.println("---ENCUENTROS FECHA6----");
		for(Encuentro e:fecha6) {
			
			System.out.println(e.getParticipante1().getNombre()+"------vs-----"+e.getParticipante2().getNombre());
		}
		System.out.println("---ENCUENTROS FECHA7----");
		for(Encuentro e:fecha7) {
			
			System.out.println(e.getParticipante1().getNombre()+"------vs-----"+e.getParticipante2().getNombre());
		}
		System.out.println("---ENCUENTROS RESTANTES----");
		for(Encuentro e:listaEncuentros) {
			
			System.out.println(e.getParticipante1().getNombre()+"------vs-----"+e.getParticipante2().getNombre());
		}

		
		//	 GestorFixture.generarFixture(competencia);
		
	
		
		/*	
		
		ArrayList<Ronda> rondas=new ArrayList<Ronda>();
		Fixture f=new Fixture();
		Ronda r=new Ronda();
		
		
		
		Encuentro e=new Encuentro();
		
		

		e.setParticipante1(competencia.getParticipante().get(0));
		e.setParticipante2(competencia.getParticipante().get(1));
		e.setIdEncuentro(0);
		e.setLugarDeRealizacion(competencia.getDisponibilidades().get(0).getLugarderealizacion());
		
		r.setEncuentros(encuentros);
		r.setFixture(f);
		r.setNombreRonda("fecha 1");
		r.setIdRonda(0);
		e.setRonda(r);
		
		encuentros.add(e);
		rondas.add(r);
		
	    f.setIdFixture(0);
		f.setCompetencia(competencia);
		f.setRondas(rondas);
		
		FixtureDAO.saveFixture(f);
		
		
		
	
		
		ArrayList<CompetenciaDTO> competencias=GestorCompetencia.buscarCompetencias("","creada","","");
		
		for(CompetenciaDTO c:competencias) {
			
			System.out.println(c.getNombre()+" "+c.getDeporte()+" "+c.getModalidad());
			
		}
 	//competencias.remove(0);
		//System.out.println(competencias.get(0).getNombre());
		
		
	
		
		Participante p= new Participante(competencia,"Ginobili","gino@hotmail.com",0,0,0,0,0,0,0);
		p.setIdParticipante(0);
		competencia.addPartcipante(p);
		CompetenciaDao.setCompetencia(competencia);
		
		ArrayList<Participante> lista=CompetenciaDao.obtenerParticipanteByIDCompetencia(competencia.getIdCompetencia());
		
		for(Participante participante:lista) {
			
			System.out.println(participante.getNombre());
			
		}
		
		
		
		
		Acceso conexion=new Acceso();
	
		Connection con=null;
		con=conexion.getConnection();
		Statement sentencia;
		
		int idFormadePuntuacion=CompetenciaDao.getIdFormaDePuntuacion(conexion);
		
		
		
		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate("INSERT INTO formadepuntuacion"
					+ "(idFormadepuntuacion,tipo_forma_punt,cant_max_tantos,cant_max_set)"
					+ "VALUES ('"+idFormadePuntuacion+"','"+"simple"+"',"+3+",null)");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(idFormadePuntuacion);
		
		
		
		
		
		
		/*int id=0;
		ResultSet rs =conexion.getQuery("SELECT max(idFormadepuntuacion) from formadepuntuacion");
			try {
				while(rs.next()) {
					id=rs.getInt("max(idFormadepuntuacion)");
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(id);
		
		
		
		
		
		
		
		
		String nombreCompetencia="amigos";
		
		
		int contador=0;
		ResultSet rs =conexion.getQuery("select idCompetencia from competencia where nombreCompetencia='amigos'");
			try {
				
				while(rs.next()) {
					
					contador++;
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(contador);
			
			
			
	
		
		
		ArrayList<LugarDeRealizacion> l=new ArrayList<LugarDeRealizacion>();
		
		l= LugarDeRealizacionDao.getLugaresByIdDeporte(conexion, 102);
		
		
		
		for(LugarDeRealizacion a:l) {
			
			System.out.println(a.getNombrelugar());
		}
		
		
		Deporte deporte=null;
		
		deporte=DeporteDAO.getDeporteById(102, conexion);
		
		if(deporte!=null) {
			
			System.out.println(deporte.getNombreDeporte());
		}*/

	}
	
	

}
