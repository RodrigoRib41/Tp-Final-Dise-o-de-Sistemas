package clases;

import java.util.ArrayList;

public class Deporte {
	  private int idDeporte;
	     private String nombreDeporte;
	     private String reglamento;
	     
		
	     public int getIdDeporte() {
			return idDeporte;
		}
		public void setIdDeporte(int idDeporte) {
			this.idDeporte = idDeporte;
		}
		public String getNombreDeporte() {
			return nombreDeporte;
		}
		public void setNombreDeporte(String nombreDeporte) {
			this.nombreDeporte = nombreDeporte;
		}
	
		public Deporte() {
			super();
		}
		public Deporte(int idDeporte, String nombreDeporte, String reglamento) {
			super();
			this.idDeporte = idDeporte;
			this.nombreDeporte = nombreDeporte;
			this.reglamento = reglamento;
		}
		@Override
		public String toString() {
			return nombreDeporte;
		}

}
