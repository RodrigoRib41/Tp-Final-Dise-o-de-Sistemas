package clasesDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Deporte;
import clases.LugarDeRealizacion;
import conexionBDD.Acceso;


public class DeporteDAO {
	
	public static Deporte getDeporteById(Integer id_deporte) {
		Acceso conn=new Acceso();
		Deporte deporte= new Deporte();
		ResultSet tablaDeporte =conn.getQuery("select * from deporte where idDeporte="+id_deporte+"");
		
			try {
				
				while(tablaDeporte.next()) {
					deporte.setIdDeporte(tablaDeporte.getInt("idDeporte"));	
					deporte.setNombreDeporte(tablaDeporte.getString("nombreDeporte"));
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
	conn.close();	
	return deporte;	
}
	
	public static ArrayList<Deporte> getAllDeporte() {
		Acceso conn=new Acceso();
		ArrayList<Deporte> deportes= new ArrayList<Deporte>();
		
		
		ResultSet tablaDeporte =conn.getQuery("select * from deporte ");
		
			try {
				while(tablaDeporte.next()) {
					Deporte deporte= new Deporte();
					deporte.setIdDeporte(tablaDeporte.getInt("idDeporte"));	
					deporte.setNombreDeporte(tablaDeporte.getString("nombreDeporte"));
				deportes.add(deporte);
				
				}
					
				}catch (SQLException e) {
				e.printStackTrace();
			}
			conn.close();	
	return deportes;	
}
	
	public static ArrayList<Deporte> getDeportesByIDLugar(int idLugar){
		Acceso conexion=new Acceso();
		ArrayList<Deporte> deportes = new ArrayList<Deporte>();
		
		ResultSet tablaLugarDeporte=conexion.getQuery("select idDeporte from deportelugarderealizacion where idLugarderealizacion="+idLugar);
		
		try {
			
			while(tablaLugarDeporte.next()) {
		
				ResultSet tablaDeporte=conexion.getQuery("select * from deporte where idDeporte="+ tablaLugarDeporte.getInt("idDeporte"));
				while(tablaDeporte.next()) {
				deportes.add(new Deporte(
						tablaDeporte.getInt("idDeporte"), 
						tablaDeporte.getString("nombreDeporte"),
						tablaDeporte.getString("reglamento"))
						);
				}
				
			}	} catch (SQLException e) {
				e.printStackTrace();
			}
		conexion.close();
				return deportes;
		
	}
	
	
	


}
