package clasesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Competencia;
import clases.Deporte;
import clases.Localidad;
import clases.Pais;
import clases.Provincia;
import clases.Usuario;
import clasesDTO.*;
import conexionBDD.Acceso;
import gestores.GestorUsuario;
import conexionBDD.Acceso;

public class UsuarioDAO {
	public static int getUsuarioLogin(String correo,String contrasenia1) {
		Acceso conn=new Acceso(); 
		
		int id=-1;
		Boolean existe=false;
		int contador=0;
		ResultSet rs =conn.getQuery("select idUsuario from usuario where correo='"+correo+"'");
		ResultSet rs2 =conn.getQuery("select idUsuario from usuario where contraseña='"+contrasenia1+"'");
		
			try {
                while(rs.next() && rs2.next()) {
					id=rs.getInt("idUsuario");
                	contador++;
				}
					}catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(contador>0){existe=true;}
		conn.close();	
	return id;
}
	
	
	public static Usuario getUsuarioByID(int idUsuario) {
		
		Acceso conn=new Acceso(); 
		Usuario user;
	     Localidad localidad=null;
	     String nombre=null;
	     String apellido=null;
	     String contraseña=null;
	     String correo=null;
	     String tipoDocumento=null;
	     int documento=0;
	     int id=0;
	     int idLocalidad=0;
		
		
		ResultSet rs =conn.getQuery("select * from usuario where idUsuario='"+idUsuario+"'");
		
			try {
                while(rs.next()) {
					
                    id=rs.getInt("idUsuario");
                    nombre=rs.getString("nombre");
                    apellido=rs.getString("apellido");
                    contraseña=rs.getString("contraseña");
                    correo=rs.getString("correo");
                    tipoDocumento=rs.getString("tipo_documento");
                    documento=rs.getInt("documento");  
                    idLocalidad=rs.getInt("idLocalidad");  
				}
					}catch (SQLException e) {
				e.printStackTrace();
			}
			
			localidad=UsuarioDAO.getLocalidadByID(idLocalidad);
			
			
			
			user=new Usuario(id, localidad, nombre,apellido ,contraseña ,correo,tipoDocumento ,documento);  
			user.setLugarderealizacions(LugarDeRealizacionDao.getLugaresByIdUsuario(user.getIdUsuario()));
			conn.close();
			return user;
}
	
public static String getCorreoByID(int idUsuario) {
		
		Acceso conn=new Acceso(); 
	     String correo=null;
		ResultSet rs =conn.getQuery("select * from usuario where idUsuario='"+idUsuario+"'");
			try {
                while(rs.next()) {
                    correo=rs.getString("correo");
				}
					}catch (SQLException e) {
				e.printStackTrace();
			}
			conn.close();
			return correo;
}
	
public static Localidad getLocalidadByID(int idLocalidad) {
		
		Acceso conn=new Acceso(); 
	    Localidad localidad=null;
		int id=0;
		int idProvincia=0;
		String nombreLocalidad=null;
		Provincia prov=null;
		
		ResultSet rs =conn.getQuery("select * from localidad where idLocalidad='"+idLocalidad+"'");
		
			try {
                while(rs.next()) {
					
                    id=rs.getInt("idLocalidad");
                    nombreLocalidad=rs.getString("nombreLocalidad");
                    idProvincia=rs.getInt("idProvincia");  
				}
					}catch (SQLException e) {
				e.printStackTrace();
			}
			
			prov=UsuarioDAO.getProvinciaByID(idProvincia);
			
			
			
			localidad=new Localidad(id,prov,nombreLocalidad);  
			conn.close();
			return localidad;
}
public static Provincia getProvinciaByID(int idProvincia) {
	
	Acceso conn=new Acceso(); 
    Provincia provincia=null;
	int id=0;
	int idPais=0;
	String nombreProvincia=null;
	Pais pais=null;
	
	ResultSet rs =conn.getQuery("select * from provincia where idProvincia='"+idProvincia+"'");
	
		try {
            while(rs.next()) {
				
                id=rs.getInt("idProvincia");
                nombreProvincia=rs.getString("nombreProvincia");
                idPais=rs.getInt("idPais");  
			}
				}catch (SQLException e) {
			e.printStackTrace();
		}
		
		pais=UsuarioDAO.getPaisByID(idPais);
		
		
		
		provincia=new Provincia(id,pais,nombreProvincia);
		conn.close();
		return provincia;
}

public static Pais getPaisByID(int idPais) {
	
	Acceso conn=new Acceso(); 
    Pais pais=null;
	int id=0;
	String nombrePais=null;
	ResultSet rs =conn.getQuery("select * from pais where idPais='"+idPais+"'");
	
		try {
            while(rs.next()) {
                id=rs.getInt("idPais");
                nombrePais=rs.getString("nombrePais");
			}
				}catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		pais=new Pais(id,nombrePais);
		conn.close();
		return pais;
}
	
	
	
	
	
	
	
	
	
	
	
	


}