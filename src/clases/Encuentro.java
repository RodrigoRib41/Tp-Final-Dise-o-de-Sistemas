package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Encuentro {

	private int idEncuentro;
    private Participante participante1;
    private Participante participante2;
    private LugarDeRealizacion lugarDeRealizacion;
    private Ronda ronda;
    private Resultado resultado;
    private ArrayList<Resultado> resultados = new ArrayList<Resultado>();
    private int idP1;
    private int idP2;
    private int idLr;
	public int getIdEncuentro() {
		return idEncuentro;
	}
	public void setIdEncuentro(int idEncuentro) {
		this.idEncuentro = idEncuentro;
	}
	public Participante getParticipante1() {
		return participante1;
	}
	public void setParticipante1(Participante participante1) {
		this.participante1 = participante1;
	}
	public Participante getParticipante2() {
		return participante2;
	}
	public void setParticipante2(Participante participante2) {
		this.participante2 = participante2;
	}
	public LugarDeRealizacion getLugarDeRealizacion() {
		return lugarDeRealizacion;
	}
	public void setLugarDeRealizacion(LugarDeRealizacion lugarDeRealizacion) {
		this.lugarDeRealizacion = lugarDeRealizacion;
	}
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	public ArrayList<Resultado> getResultados() {
		return resultados;
	}
	public void setResultados(ArrayList<Resultado> resultados) {
		this.resultados = resultados;
	}
	public Ronda getRonda() {
		return ronda;
	}
	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}
	public Encuentro(int idEncuentro,Ronda ronda, int participante1, int participante2,
			int lugarDeRealizacion) {
		super();
		this.idEncuentro = idEncuentro;
		this.setIdP1(participante1);
		this.setIdP2(participante2);
		this.setIdLr(lugarDeRealizacion);
		this.ronda = ronda;
	}
	public Encuentro() {
		super();
		
	}
	public int getIdP1() {
		return idP1;
	}
	public void setIdP1(int idP1) {
		this.idP1 = idP1;
	}
	public int getIdP2() {
		return idP2;
	}
	public void setIdP2(int idP2) {
		this.idP2 = idP2;
	}
	public int getIdLr() {
		return idLr;
	}
	public void setIdLr(int idLr) {
		this.idLr = idLr;
	}
	
	
    
    
    
    
}
