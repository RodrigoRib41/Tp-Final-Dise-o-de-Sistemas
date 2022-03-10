package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import clasesDAO.CompetenciaDao;

public class Participante {

	private int idParticipante;
    private Competencia competencia;
    private String nombre;
    private String correo;
    private int pts;
    private int pg;
    private int pe;
    private int pp;
    private int tf;
    private int tg;
    private int d;
    private ArrayList<Encuentro> encuentros=new ArrayList<Encuentro>();
    private ArrayList<Participante> enfrentados=new ArrayList<Participante>();
    private boolean libre;
	public int getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public int getPe() {
		return pe;
	}
	public void setPe(int pe) {
		this.pe = pe;
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	public int getTf() {
		return tf;
	}
	public void setTf(int tf) {
		this.tf = tf;
	}
	public int getTg() {
		return tg;
	}
	public void setTg(int tg) {
		this.tg = tg;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public ArrayList<Encuentro> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(ArrayList<Encuentro> encuentros) {
		this.encuentros = encuentros;
	}
	public Participante(Competencia competencia, String nombre, String correo, int pts, int pg, int pe, int pp, int tf,
			int tg, int d) {
		super();
		this.competencia = competencia;
		this.nombre = nombre;
		this.correo = correo;
		this.pts = pts;
		this.pg = pg;
		this.pe = pe;
		this.pp = pp;
		this.tf = tf;
		this.tg = tg;
		this.d = d;
		this.libre=false;
	}
	public Participante(int idParticipante, String nombre, String correo, int pts, int pg, int pe, int pp, int tf,
			int tg, int d) {
		super();
		this.idParticipante =idParticipante; 
		this.nombre = nombre;
		this.correo = correo;
		this.pts = pts;
		this.pg = pg;
		this.pe = pe;
		this.pp = pp;
		this.tf = tf;
		this.tg = tg;
		this.d = d;
		this.libre=false;
	}
	public ArrayList<Participante> getEnfrentados() {
		return enfrentados;
	}
	public void addEnfrentado(Participante p) {
		this.enfrentados.add(p);
	}
	public Participante() {
		super();
		
	}
    
    
    
}
