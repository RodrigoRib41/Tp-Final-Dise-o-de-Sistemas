package clasesDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBDD.Acceso;
import clases.Deporte;
import clases.LugarDeRealizacion;

public class LugarDeRealizacionDao {
	

public static ArrayList<LugarDeRealizacion> getLugaresByIdUsuario(int idUsuario){
		
	Acceso conexion=new Acceso();
	
	    ResultSet tablaLugares=conexion.getQuery("select * from lugarderealizacion where idUsuario="+idUsuario);
		ArrayList<LugarDeRealizacion> lugares = new ArrayList<LugarDeRealizacion>();
		try {
			
			while(tablaLugares.next()) {
			LugarDeRealizacion l = new LugarDeRealizacion(tablaLugares.getInt("idLugarderealizacion"), 
					tablaLugares.getInt("idUsuario"),
					tablaLugares.getInt("codigo"), 
					tablaLugares.getString("nombrelugar")
					);
			
			
			
			lugares.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.close();	
		return lugares;
	}
public static LugarDeRealizacion getLugarByIdLugar(int idLugar){
	
	
	Acceso conexion=new Acceso();
    ResultSet tablaLugares=conexion.getQuery("select * from lugarderealizacion where idLugarderealizacion="+idLugar);
    LugarDeRealizacion lugar=null;
	try {
		
		while(tablaLugares.next()) {
		 lugar = new LugarDeRealizacion(tablaLugares.getInt("idLugarderealizacion"), 
				tablaLugares.getInt("idUsuario"),
				tablaLugares.getInt("codigo"), 
				tablaLugares.getString("nombrelugar")
				);
		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	ArrayList<Deporte> deportesLugar=DeporteDAO.getDeportesByIDLugar(idLugar);
	for(Deporte d:deportesLugar) {
		lugar.addDeporte(d);
	}
	
	conexion.close();	
	return lugar;
}

public static ArrayList<LugarDeRealizacion> getLugaresByIdDeporte(int idDeporte){
	Acceso conexion=new Acceso();
	ArrayList<LugarDeRealizacion> lugares = new ArrayList<LugarDeRealizacion>();
	
	ResultSet tablaLugarDeporte=conexion.getQuery("select idLugarderealizacion from deportelugarderealizacion where idDeporte="+idDeporte);
	
	try {
		
		while(tablaLugarDeporte.next()) {
	
			ResultSet tablaLugar=conexion.getQuery("select * from lugarderealizacion where idLugarderealizacion="+ tablaLugarDeporte.getInt("idLugarderealizacion"));
			while(tablaLugar.next()) {
			lugares.add(new LugarDeRealizacion(tablaLugar.getInt("idLugarderealizacion"), 
					tablaLugar.getInt("idUsuario"),
					tablaLugar.getInt("codigo"), 
					tablaLugar.getString("nombrelugar")
					));
			}
			
		}	} catch (SQLException e) {
			e.printStackTrace();
		}
	
	conexion.close();	
			return lugares;
	
}

}
