package conexionBDD;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Acceso {
	
	private String _usuario="root";
	 private String _pwd= "";
	 private static String _bd="tpb6";
	 static String _url = "jdbc:mysql://localhost/"+_bd;
	 private Connection conn = null;
	 
	 public Acceso() {
	  
	   try{
	     Class.forName("com.mysql.jdbc.Connection");
	     conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
	  
	   }
	   catch(SQLException ex)
	   {
	      System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
	   }
	   catch(ClassNotFoundException ex)
	   {
	      System.out.println(ex);
	   }  
	 }
	 
	 public ResultSet getQuery(String _query)
	 {

	    Statement state = null;
	    ResultSet resultado = null;
	    try{
	      state = (Statement) conn.createStatement();
	      resultado = state.executeQuery(_query);
	    }
	    catch(SQLException e)
	    {
	      e.printStackTrace();
	    }
	    return resultado;
	 }
	 
	 public void setQuery(String _query){

	    Statement state = null;
	  
	    try{   
	      state=(Statement) conn.createStatement();
	      state.execute(_query);

	    }catch (SQLException e){
	      e.printStackTrace();
	    }
	 }
	 
	 public com.mysql.jdbc.Connection getConnection() {
			// TODO Auto-generated method stub
			return (com.mysql.jdbc.Connection) conn;
		}
	 
	 public void close() {
		 try {
			this.conn.close();
			System.out.println("Conexi-n a base de datos jdbc:mysql://localhost/tpdiseño . . . Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
}