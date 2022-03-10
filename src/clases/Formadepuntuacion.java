package clases;

import java.util.Set;

public class Formadepuntuacion {
	private int idFormadepuntuacion;
    private String tipoFormaPunt;
    private Integer cantMaxTantos;
    private Integer cantMaxSet;
    
	public String getTipoFormaPunt() {
		return tipoFormaPunt;
	}
	public void setTipoFormaPunt(String tipoFormaPunt) {
		this.tipoFormaPunt = tipoFormaPunt;
	}
	public Integer getCantMaxTantos() {
		return cantMaxTantos;
	}
	public void setCantMaxTantos(Integer cantMaxTantos) {
		this.cantMaxTantos = cantMaxTantos;
	}
	public Integer getCantMaxSet() {
		return cantMaxSet;
	}
	public void setCantMaxSet(Integer cantMaxSet) {
		this.cantMaxSet = cantMaxSet;
	}
	public Formadepuntuacion(String tipoFormaPunt, Integer cantMaxTantos, Integer cantMaxSet) {
		super();
		this.tipoFormaPunt = tipoFormaPunt;
		this.cantMaxTantos = cantMaxTantos;
		this.cantMaxSet = cantMaxSet;
	}
	public Formadepuntuacion(int idForma,String tipoFormaPunt, Integer cantMaxTantos, Integer cantMaxSet) {
		super();
		this.idFormadepuntuacion=idForma;
		this.tipoFormaPunt = tipoFormaPunt;
		this.cantMaxTantos = cantMaxTantos;
		this.cantMaxSet = cantMaxSet;
	}





}
