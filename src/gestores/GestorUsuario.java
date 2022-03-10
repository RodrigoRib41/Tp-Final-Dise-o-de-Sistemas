package gestores;

import clasesDAO.UsuarioDAO;
import conexionBDD.Acceso;
import java.util.ArrayList;

import clases.*;
import clasesDAO.*;

public class GestorUsuario {

	public static int verificarUsuario(String usuario, String contrasenia) {
		
		
		return UsuarioDAO.getUsuarioLogin(usuario,contrasenia);
		
	}
public static Usuario getUsuarioByID(int idUsuario) {
		
		return UsuarioDAO.getUsuarioByID(idUsuario);
		
	}
 	
	public static String getCorreoByID(int idUsuario) {
		return UsuarioDAO.getCorreoByID(idUsuario);
	}

}
