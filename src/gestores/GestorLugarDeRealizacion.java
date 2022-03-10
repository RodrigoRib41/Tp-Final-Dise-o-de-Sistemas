package gestores;
import java.util.ArrayList;

import clases.*;
import clasesDAO.*;
import conexionBDD.Acceso;



public class GestorLugarDeRealizacion {

	public static ArrayList<LugarDeRealizacion> getLugaresDisponibles(Deporte obj,int idUsuario){
		
		Deporte deporte=(Deporte)obj;
		int idDeporte=deporte.getIdDeporte();
		ArrayList<LugarDeRealizacion> lugares = new ArrayList<LugarDeRealizacion>();
		ArrayList<LugarDeRealizacion> lugaresDeporte = null;
		ArrayList<LugarDeRealizacion> lugaresUsuario = null;
		
		lugaresDeporte=LugarDeRealizacionDao.getLugaresByIdDeporte( idDeporte);
		lugaresUsuario=LugarDeRealizacionDao.getLugaresByIdUsuario( idUsuario);
		
		for(LugarDeRealizacion d:lugaresDeporte) {
			usuarios: for(LugarDeRealizacion u:lugaresUsuario) {
				if(d.getIdLugarDeRealizacion()==u.getIdLugarDeRealizacion()) {
					lugares.add(d);
					break usuarios;}}	
		}
			
		return lugares;
	}
	
	
	
	
	public static LugarDeRealizacion getLugarByID(int id) {
		
		return LugarDeRealizacionDao.getLugarByIdLugar(id);
		
	}
	
	
	
	

}











