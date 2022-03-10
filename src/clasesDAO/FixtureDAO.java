package clasesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.*;
import conexionBDD.Acceso;
import gestores.GestorFixture;

public class FixtureDAO {
	
	
	public static void saveFixture(Fixture f) {
		
		
		Acceso conexion=new Acceso();
		Connection con=null;
		con=conexion.getConnection();
		Statement sentencia;
		if(f.getIdFixture()==0) {
		int idFixture=FixtureDAO.getIdFixture(conexion);

		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate("INSERT INTO fixture(idFixture,idCompetencia)"
					+ "VALUES ("+idFixture+","+f.getCompetencia().getIdCompetencia()+")");

		} catch (SQLException e) {
			System.out.println("aca salta f");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		f.setIdFixture(idFixture);
		System.out.println("GUARDO FIXTURE");
	    for(Ronda ronda:f.getRondas()) {
	    	System.out.println("---GUARDO UNA RONDA-----");
	    	FixtureDAO.saveRonda(ronda);
	    	
	    } 
		
		
		}
		
	
		conexion.close();	
	}
	
	
	public static int getIdFixture(Acceso conexion) {
		int id=0;
		ResultSet rs =conexion.getQuery("SELECT max(idFixture) from fixture");
		
			try {
				
				while(rs.next()) {
					id=rs.getInt("max(idFixture)");
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
		
	return (id+1);	
	}
	
	public static void saveRonda(Ronda r) {
		
		Acceso conexion=new Acceso();
		Connection con=null;
		con=conexion.getConnection();
		Statement sentencia;
		if(r.getIdRonda()==0) {
		int idRonda=FixtureDAO.getIdRonda(conexion);

		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate("INSERT INTO ronda(idRonda,nombreRonda,idFixture)"
					+ "VALUES ("+idRonda+",'"+r.getNombreRonda()+"',"+r.getFixture().getIdFixture() +")");

		} catch (SQLException e) {
			System.out.println("aca salta r");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	r.setIdRonda(idRonda);
		 
	    for(Encuentro e:r.getEncuentros()) {
	    	System.out.println("--GUARDO UN ENCUENTRO-----");
	    	FixtureDAO.saveEncuentro(e);
	    	
	    } 
		}
		conexion.close();	
	}
	
	public static int getIdRonda(Acceso conexion) {
		int id=0;
		ResultSet rs =conexion.getQuery("SELECT max(idRonda) from ronda");
		
			try {
				
				while(rs.next()) {
					id=rs.getInt("max(idRonda)");
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
			
	return (id+1);	
	}
	
	public static void saveEncuentro(Encuentro e) {
		Acceso conexion=new Acceso();
		Connection con=null;
		con=conexion.getConnection();
		Statement sentencia;
		if(e.getIdEncuentro()==0) {
		int idEncuentro=FixtureDAO.getIdEncuentro(conexion);

		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate("INSERT INTO encuentro(idEncuentro,idRonda,idParticipante1,idParticipante2,idLugarderealizacion)"
					+ "VALUES ("+idEncuentro+"," +e.getRonda().getIdRonda()+"," +e.getParticipante1().getIdParticipante() +","+
					e.getParticipante2().getIdParticipante()+","+e.getLugarDeRealizacion().getIdLugarDeRealizacion()+ ")");

		} catch (SQLException ex) {
			System.out.println("aca salta " + idEncuentro);
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}	
	e.setIdEncuentro(idEncuentro);
	   
	/* if(e.getResultado() instanceof Encuentropuntuacion ) {
		 
		 FixtureDAO.saveEncuentroPuntuacion(e.getResultado());
		 
	 }
	 else if(e.getResultado() instanceof Encuentrosets) {
		 FixtureDAO.saveEncuentroSets(e.getResultado());
	 }
    else if(e.getResultado() instanceof Encuentroresultadofinal) {
    	
		 FixtureDAO.saveEncuentroResultadoFinal(e.getResultado());
		 
	 }*/
	 
	
	conexion.close();	
	
	
		}}
	
	public static int getIdEncuentro(Acceso conexion) {
		int id=0;
		ResultSet rs =conexion.getQuery("SELECT max(idEncuentro) from encuentro");
		
			try {
				
				while(rs.next()) {
					id=rs.getInt("max(idEncuentro)");
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
		
	return (id+1);	
	}
	
	
	public static Fixture getFixtureByCompetencia(Competencia c) {
		Fixture f=new Fixture();
		f.setCompetencia(c);
		Acceso conexion=new Acceso();
	    ResultSet r=conexion.getQuery("select * from fixture where idCompetencia="+c.getIdCompetencia());
		try {
			
			while(r.next()) {
				f.setIdFixture(r.getInt("idFixture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Ronda> fechas= FixtureDAO.getRondasByFixture(f);
		
		for(Ronda ronda:fechas) {
			for(Encuentro e:ronda.getEncuentros()) {
				
				e.setParticipante1(CompetenciaDao.obtenerParticipanteByID(e.getIdP1(), c));
				e.setParticipante2(CompetenciaDao.obtenerParticipanteByID(e.getIdP2(), c));
				e.setLugarDeRealizacion(CompetenciaDao.obtenerLugarByID(e.getIdLr(), c));
				
			}
			
			
			
		}

		
		
		
		
		
		
		
		
		
		f.setRondas(fechas);

		conexion.close();	
		
		 return f;
	}


	public static ArrayList<Ronda> getRondasByFixture(Fixture f){
		ArrayList<Ronda> rondas=new ArrayList<Ronda>();
		Acceso conexion=new Acceso();
	    ResultSet r=conexion.getQuery("select * from ronda where idFixture="+f.getIdFixture());
		try {
			
			while(r.next()) {
				
				rondas.add(new Ronda(r.getInt("idRonda"),r.getString("nombreRonda")));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Ronda fecha:rondas) {
			
			fecha.setEncuentros(FixtureDAO.getEncuentrosByRonda(fecha));
			fecha.setFixture(f);
		}
		

		
		conexion.close();	
		 return rondas;
		
		

		
	}


	public static ArrayList<Encuentro> getEncuentrosByRonda(Ronda ronda){
		ArrayList<Encuentro> encuentros=new ArrayList<Encuentro>();
		Acceso conexion=new Acceso();
	    ResultSet r=conexion.getQuery("select * from encuentro where idRonda="+ronda.getIdRonda());
		try {
			
			while(r.next()) {
				
				encuentros.add(new Encuentro(r.getInt("idEncuentro"),
						ronda,
						r.getInt("idParticipante1"),
						r.getInt("idParticipante2"),
						r.getInt("idLugarderealizacion")
						));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.close();	
		 return encuentros;
		
		
	}
	

public static void eliminarFixture(Fixture f) {
	
	for(Ronda r:f.getRondas()) {
		FixtureDAO.eliminarRonda(r);
	}
	
	Acceso conexion=new Acceso();
	Connection con=null;
	con=conexion.getConnection();
	Statement sentencia;

	try {
		sentencia = con.createStatement();
		sentencia.executeUpdate("delete from fixture where idFixture="+f.getIdFixture());

	} catch (SQLException ex) {
		
	
		ex.printStackTrace();
	}	
	conexion.close();	
	
	
}
public static void eliminarRonda(Ronda r) {
	
	
	for(Encuentro e:r.getEncuentros()) {
		FixtureDAO.eliminarEncuentro(e);
	}
	
	Acceso conexion=new Acceso();
	Connection con=null;
	con=conexion.getConnection();
	Statement sentencia;

	try {
		sentencia = con.createStatement();
		sentencia.executeUpdate("delete from ronda where idFixture="+r.getFixture().getIdFixture());

	} catch (SQLException e) {
		e.printStackTrace();
	}	
	conexion.close();	
	
	
}
	
public static void eliminarEncuentro(Encuentro en) {
	
	Acceso conexion=new Acceso();
	Connection con=null;
	con=conexion.getConnection();
	Statement sentencia;

	try {
		sentencia = con.createStatement();
		sentencia.executeUpdate("delete from encuentro where idRonda="+en.getRonda().getIdRonda());

	} catch (SQLException e) {
		e.printStackTrace();
	}	
	conexion.close();	
	
	
}
	







	
	
	
	
	

}
