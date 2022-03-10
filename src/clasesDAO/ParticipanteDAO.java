package clasesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.*;
import conexionBDD.Acceso;

public class ParticipanteDAO {
	
	
	public static boolean saveParticipante(Participante p) {
		
		Acceso conexion=new Acceso();
		Connection con=null;
		con=conexion.getConnection();
		Statement sentencia;
		if(p.getIdParticipante()==0) {
		int idParticipante=ParticipanteDAO.getIdParticipante(conexion);

		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate("INSERT INTO participante(idParticipante,nombre,correo,pts,pg,pe,pp,tf,tg,d,idCompetencia)"
					+ "VALUES ("+idParticipante+",'"+p.getNombre()+"','"+p.getCorreo()+"',"+p.getPts()+
					","+p.getPg()+","+p.getPe()
					+","+p.getPp()+","+p.getTf()+","+p.getTg()+","+p.getD()+","+p.getCompetencia().getIdCompetencia()+")");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		p.setIdParticipante(idParticipante);
		conexion.close();	
		return true;
		
	}
		else {
			conexion.close();	
			return false;
		}
		
	
	}
	public static int getParticipanteByNombre(String nombreParticipante, int idCom) {
		Acceso conn=new Acceso();
		int id;

		ResultSet rs =conn.getQuery("SELECT idCompetencia FROM participante WHERE nombre='"+nombreParticipante+"'");
		
		
			try {
                if(rs.next()) {
                	id=rs.getInt("idCompetencia");
                	if(id == idCom) {
					return rs.getInt(1);
				}
                	return 0;
                }
                return 0;
					}catch (SQLException e) {
				e.printStackTrace();
			}
		
		conn.close();	
	return 0;
}
	
	
	
	
	public static int getIdParticipante(Acceso conexion) {
		int id=0;
		ResultSet rs =conexion.getQuery("SELECT max(idParticipante) from participante");
		
			try {
				
				while(rs.next()) {
					id=rs.getInt("max(idParticipante)");
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
		
	return (id+1);	
	}
	

	
	
	
	
	
	public static ArrayList<Participante> obtenerParticipanteByIDCompetencia(int idCompetencia) {
	
		Acceso conexion=new Acceso();
	    	
	ResultSet rs=conexion.getQuery("select * from participante where idCompetencia="+idCompetencia);
	ArrayList<Participante> participante=new ArrayList<Participante>();
	try {
		
		while(rs.next()) {		
			participante.add(new Participante(rs.getInt("idParticipante"),rs.getString("nombre"),
					rs.getString("correo"),rs.getInt("pts"),rs.getInt("pg"),rs.getInt("pe")
					,rs.getInt("pp"),rs.getInt("tf"),rs.getInt("tg"),rs.getInt("d")));
						
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	conexion.close();	
	return participante;
	
	
	}
	
	
	public static Participante getParticipanteByID(int idParticipante) {
		Participante p=null;
		Acceso conn=new Acceso();
		
		ResultSet rs =conn.getQuery("select * from participante where idParticipante="+idParticipante);
		
			try {
				
				while(rs.next()) {
					
					p=new Participante(rs.getInt("idParticipante"),rs.getString("nombre"),
							rs.getString("correo"),rs.getInt("pts"),rs.getInt("pg"),rs.getInt("pe")
							,rs.getInt("pp"),rs.getInt("tf"),rs.getInt("tg"),rs.getInt("d"));
					
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
			conn.close();		
	return p;	
		
		
		

		
	}
	
	
	


}
