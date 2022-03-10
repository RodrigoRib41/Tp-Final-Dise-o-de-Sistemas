package clasesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Competencia;
import clases.Deporte;
import clases.Disponibilidad;
import clases.Encuentro;
import clases.Formadepuntuacion;
import clases.LugarDeRealizacion;
import clases.Participante;
import clases.Ronda;
import clases.SistemaLiga;
import clases.Usuario;
import clasesDTO.*;
import conexionBDD.Acceso;
import gestores.GestorFixture;


public class CompetenciaDao {
	
	public static Boolean getCompetenciaByNombre(String nombreCompetencia) {
		Acceso conn=new Acceso();
		Boolean existe=false;
		int contador=0;
		ResultSet rs =conn.getQuery("select idCompetencia from competencia where nombreCompetencia='"+nombreCompetencia+"'");
		
			try {
                while(rs.next()) {
					contador++;
				}
					}catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(contador>0){existe=true;}
		conn.close();	
	return existe;
}
	
	public static Competencia getCompetenciaByID(int idCompetencia){
		
		
		Acceso conexion=new Acceso();
	    ResultSet tablaCompetencia=conexion.getQuery("select * from competencia where idCompetencia="+idCompetencia);
	    Competencia competencia=null;
	    int idDeporte=0;
	    int idUsuario=0;
	    int idFormaDePuntuacion=0;
		try {
			
			while(tablaCompetencia.next()) {
				
				
			 competencia = new Competencia(tablaCompetencia.getInt("idCompetencia"), 
					tablaCompetencia.getString("nombreCompetencia"),
					tablaCompetencia.getString("estado"), 
					tablaCompetencia.getString("reglamento"),
					tablaCompetencia.getString("modalidad")
					);
			 idFormaDePuntuacion=tablaCompetencia.getInt("idFormadepuntuacion");
			 idDeporte=tablaCompetencia.getInt("idDeporte");
			 idUsuario=tablaCompetencia.getInt("idUsuario");
			 
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Deporte deporte=DeporteDAO.getDeporteById(idDeporte);		
		Usuario usuario=UsuarioDAO.getUsuarioByID(idUsuario);
		Formadepuntuacion forma= CompetenciaDao.getFormaDePuntuacionByID( idFormaDePuntuacion);
		ArrayList<Integer> lugares= new ArrayList<Integer>();
		ArrayList<Integer> cantidades= new ArrayList<Integer>();
		ArrayList<Disponibilidad> dispoCompetencia=new ArrayList<Disponibilidad>();
		ArrayList<Participante> participante=ParticipanteDAO.obtenerParticipanteByIDCompetencia(idCompetencia);
		
		
		tablaCompetencia=conexion.getQuery("select * from disponibilidad where idCompetencia="+idCompetencia);
try {
			
			while(tablaCompetencia.next()) {		
				lugares.add(tablaCompetencia.getInt("idLugarderealizacion"));
				cantidades.add(tablaCompetencia.getInt("disponibilidad"));
							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		if(competencia.getModalidad().compareTo("Sistema Liga")==0) {
			SistemaLiga sistema=CompetenciaDao.getSistemaLigaByIDCompetencia(competencia.getIdCompetencia());
		competencia.setSistemaLiga(sistema);
		
		}
		
		competencia.setDeporte(deporte);
		competencia.setUsuario(usuario);
		competencia.setFormadepuntuacion(forma);
		
	for(int i=0;i<lugares.size();i++) {
		LugarDeRealizacion lugar=LugarDeRealizacionDao.getLugarByIdLugar(lugares.get(i));
		dispoCompetencia.add(new Disponibilidad(competencia,lugar,cantidades.get(i)));
	}
	
	
	competencia.setDisponibilidades(dispoCompetencia);
	competencia.setParticipante(participante);
		
	for(Participante par:participante) {
		par.setCompetencia(competencia);
		
	}
	if(competencia.getEstado().compareTo("creada")!=0) {
	competencia.setFixture(FixtureDAO.getFixtureByCompetencia(competencia));
	

	
	}
	conexion.close();
		return competencia;
	}
	
	public static Participante obtenerParticipanteByID(int id,Competencia c) {
		Participante participante=null;
	
		for(Participante p:c.getParticipante()) {
			if(p.getIdParticipante()==id) {
				participante=p;	break;
			}		
		}
		
		return participante;
	    		
		}
	public static LugarDeRealizacion obtenerLugarByID(int id,Competencia c) {
		LugarDeRealizacion l=null;
	
		
		for(int i=0;i<c.getDisponibilidades().size();i++) {
			if(id==c.getDisponibilidades().get(i).getLugarderealizacion().getIdLugarDeRealizacion()) {
				
				l=c.getDisponibilidades().get(i).getLugarderealizacion();
			}
			
		}
		
		
		
		return l;
	    		
		}
	
	
	
	

	public static Formadepuntuacion getFormaDePuntuacionByID(Integer idForma) {
		Acceso conn=new Acceso();
		Formadepuntuacion formaPunt= null;
		ResultSet tablaForma =conn.getQuery("select * from formadepuntuacion where idFormadepuntuacion="+idForma+"");
		
			try {
				
				while(tablaForma.next()) {
					
					formaPunt=new Formadepuntuacion(
							tablaForma.getInt("idFormadepuntuacion"),
					        tablaForma.getString("tipo_forma_punt"),
					        tablaForma.getInt("cant_max_tantos"),   
					        tablaForma.getInt("cant_max_set")
							);
				
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
		conn.close();
	return formaPunt;	
}
	public static SistemaLiga getSistemaLigaByIDCompetencia(Integer idCompetencia) {
		Acceso conn=new Acceso();
		SistemaLiga sistema= null;
		ResultSet tabla =conn.getQuery("select * from sistemaliga where idCompetencia="+idCompetencia+"");
		
			try {
				
				while(tabla.next()) {
					
					sistema=new SistemaLiga(
							tabla.getInt("idSistemaliga"),
					        tabla.getInt("idCompetencia"),
					        tabla.getInt("puntPartGan"),   
					        tabla.getInt("puntPartEm"),
					        tabla.getInt("puntPresentarse")
							);
				
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
		conn.close();
	return sistema;	
}
	
	
	
	
	public static int setCompetencia(Competencia competencia ) {
		
		Acceso conexion=new Acceso();
			Connection con=null;
			con=conexion.getConnection();
			Statement sentencia;
			
			if(competencia.getIdCompetencia()==0) {
			
			int idFormaDePuntuacion=CompetenciaDao.setFormadePuntuacion(competencia.getFormadepuntuacion());
			
			int idCompetencia=CompetenciaDao.getIdCompetencia(conexion);
			competencia.setIdCompetencia(idCompetencia);

			try {
				sentencia = con.createStatement();
				sentencia.executeUpdate("INSERT INTO competencia(idCompetencia,nombreCompetencia,estado,reglamento,modalidad,idFormadepuntuacion,idDeporte,idUsuario)"
						+ "VALUES ("+competencia.getIdCompetencia()+",'"+competencia.getNombreCompetencia()+"','creada','"+competencia.getReglamento()+
						"','"+competencia.getModalidad()+"'"+ ","+idFormaDePuntuacion
						+","+competencia.getDeporte().getIdDeporte()+","+competencia.getUsuario().getIdUsuario()+")");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			if(competencia.getModalidad()=="Sistema Liga") {
				competencia.getSistemaLiga().setIdCompetencia(competencia.getIdCompetencia());
				CompetenciaDao.setSistemaLiga(competencia.getSistemaLiga());
			}
			
			CompetenciaDao.setDisponibilidad(competencia.getDisponibilidades());
			}
			else {
				
		
			if(competencia.getParticipante().size()>0) {
				
				boolean agregoParticipante=false;
				for(Participante p:competencia.getParticipante()) {
					if(ParticipanteDAO.saveParticipante(p)) {
						agregoParticipante=true;
						
					};
				}
				if(agregoParticipante) {
					CompetenciaDao.setEstadoCompetencia(competencia.getEstado(), competencia.getIdCompetencia());	
				    FixtureDAO.eliminarFixture(FixtureDAO.getFixtureByCompetencia(competencia));
				    
				}
				
				
			}
			
			if(competencia.getFixture()!=null) {
				FixtureDAO.saveFixture(competencia.getFixture());
				CompetenciaDao.setEstadoCompetencia(competencia.getEstado(),competencia.getIdCompetencia());
				
			}
			
			
			}
			
			
		conexion.close();	
		return competencia.getIdCompetencia();
	
	
	
	}
	
	
	
	
	public static int setFormadePuntuacion(Formadepuntuacion forma) {
		Acceso conexion=new Acceso();
		Connection con=null;
		con=conexion.getConnection();
		Statement sentencia;
		
		int idFormadePuntuacion=CompetenciaDao.getIdFormaDePuntuacion(conexion);
		
		
		
		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate("INSERT INTO formadepuntuacion"
					+ "(idFormadepuntuacion,tipo_forma_punt,cant_max_tantos,cant_max_set)"
					+ "VALUES ("+idFormadePuntuacion+",'"+forma.getTipoFormaPunt()+"',"+forma.getCantMaxTantos()+","+forma.getCantMaxSet()+")");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexion.close();	
		return idFormadePuntuacion;
		
		
	}
	
	public static int getIdFormaDePuntuacion(Acceso conexion) {
		int id=0;
		ResultSet rs =conexion.getQuery("SELECT max(idFormadepuntuacion) from formadepuntuacion");
		
			try {
				
				while(rs.next()) {
					id=rs.getInt("max(idFormadepuntuacion)");
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
		
	return (id+1);	
}
		

public static int getIdCompetencia(Acceso conexion) {
	int id=0;
	ResultSet rs =conexion.getQuery("SELECT max(idCompetencia) from competencia");
	
		try {
			
			while(rs.next()) {
				id=rs.getInt("max(idCompetencia)");
			}
				
			}catch (SQLException e) {
			e.printStackTrace();
		}
	
return (id+1);	
}

public static int setSistemaLiga(SistemaLiga sis) {
	
	
	
	Acceso conexion=new Acceso();
	Connection con=null;
	con=conexion.getConnection();
	Statement sentencia;
	int idSistemaLiga=CompetenciaDao.getIdSistemaLiga(conexion);
	Boolean empate= sis.isEmpate();
	try {
		sentencia = con.createStatement();
		sentencia.executeUpdate("INSERT INTO sistemaliga"
				+ "(idSistemaliga,idCompetencia,puntPartGan,puntPartEm,puntPresentarse,empate)"
				+ "VALUES ("+idSistemaLiga+",'"+sis.getIdCompetencia()+"',"+sis.getPuntPartGan()+","+sis.getPuntPartEm()+
				","+sis.getPuntPresentarse()+","+ empate+ ")");

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conexion.close();	
	return idSistemaLiga;
	
	
}

public static int getIdSistemaLiga(Acceso conexion) {
	int id=0;
	ResultSet rs =conexion.getQuery("SELECT max(idSistemaliga) from sistemaliga");
	
		try {
			
			while(rs.next()) {
				id=rs.getInt("max(idSistemaliga)");
			}
				
			}catch (SQLException e) {
			e.printStackTrace();
		}
	
return (id+1);	
}


public static void setDisponibilidad(ArrayList<Disponibilidad> disponibilidad) {
	Acceso conexion=new Acceso();
	Connection con=null;
	con=conexion.getConnection();
	Statement sentencia;
	int i=0;
	while(disponibilidad.size()>i) {
		
	try {
		sentencia = con.createStatement();
		sentencia.executeUpdate("INSERT INTO disponibilidad"
				+ "(idCompetencia,idLugarderealizacion,disponibilidad)"
				+ "VALUES ("+disponibilidad.get(i).getCompetencia().getIdCompetencia()+",'"
				+disponibilidad.get(i).getLugarderealizacion().getIdLugarDeRealizacion()+"',"
				+disponibilidad.get(i).getDisponibilidad()+")"
				);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	i++;
	
	}
	
	conexion.close();	

}




public static ArrayList<Participante> obtenerParticipanteByIDCompetencia(int idCompetencia){
	
	Competencia c=CompetenciaDao.getCompetenciaByID(idCompetencia);
	
	return c.getParticipante();
}


public static ArrayList<Competencia> obtenerAllCompetencias(){
	ArrayList<Competencia> competencias= new ArrayList<Competencia>();
	
	Acceso conexion=new Acceso();
	
	ResultSet rs =conexion.getQuery("select idCompetencia from competencia");
	
		try {
			
			while(rs.next()) {
				competencias.add(CompetenciaDao.getCompetenciaByID(rs.getInt("idCompetencia")));
			}
				
			}catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	
		conexion.close();	
	return competencias;
}

public static void setEstadoCompetencia(String estado, int idCompetencia) {
	Acceso conexion=new Acceso();
	Connection con=null;
	con=conexion.getConnection();
	Statement sentencia;
	try {
		sentencia = con.createStatement();
		sentencia.executeUpdate("UPDATE competencia SET estado='"+estado+"' WHERE idCompetencia="+idCompetencia );

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	conexion.close();	
}









}


	


















	
	
	
	
	
