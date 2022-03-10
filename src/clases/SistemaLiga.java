package clases;

public class SistemaLiga {
	private int idSistemaliga;
    private int puntPartGan;
    private int puntPartEm;
    private int puntPresentarse;
    private boolean empate;
    private int idCompetencia;
    
    public int getIdSistemaliga() {
		return idSistemaliga;
	}
	public void setIdSistemaliga(int idSistemaliga) {
		this.idSistemaliga = idSistemaliga;
	}
	public int getPuntPartGan() {
		return puntPartGan;
	}
	public void setPuntPartGan(int puntPartGan) {
		this.puntPartGan = puntPartGan;
	}
	public int getPuntPartEm() {
		return puntPartEm;
	}
	public void setPuntPartEm(int puntPartEm) {
		this.puntPartEm = puntPartEm;
	}
	public int getPuntPresentarse() {
		return puntPresentarse;
	}
	public void setPuntPresentarse(int puntPresentarse) {
		this.puntPresentarse = puntPresentarse;
	}
	public boolean isEmpate() {
		return empate;
	}
	public void setEmpate(boolean empate) {
		this.empate = empate;
	}
	public SistemaLiga(int puntPartGan, int puntPartEm, int puntPresentarse) {
		super();
		this.puntPartGan = puntPartGan;
		this.puntPartEm = puntPartEm;
		this.puntPresentarse = puntPresentarse;
	if(puntPartEm>0) {
		this.setEmpate(true);	
	}
	}
	
	public SistemaLiga(int idSistema,int idCompetencia,int puntPartGan, int puntPartEm, int puntPresentarse) {
		super();
		this.idSistemaliga = idSistema;
		this.idCompetencia = idCompetencia;
		this.puntPartGan = puntPartGan;
		this.puntPartEm = puntPartEm;
		this.puntPresentarse = puntPresentarse;
	if(puntPartEm>0) {
		this.setEmpate(true);	
	}
	}
	public int getIdCompetencia() {
		return idCompetencia;
	}
	public void setIdCompetencia(int idCompetencia) {
		this.idCompetencia = idCompetencia;
	}





}
