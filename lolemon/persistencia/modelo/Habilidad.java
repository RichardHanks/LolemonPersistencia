package lolemon.persistencia.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Habilidad extends Movimiento implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer da�o;
	private Integer coste;
	
	public Habilidad() {
		
	}

	public Habilidad(Integer da�o, Integer coste) {
		super();
		this.da�o = da�o;
		this.coste = coste;

	}

	public Integer getDa�o() {
		return da�o;
	}

	public void setDa�o(Integer da�o) {
		this.da�o = da�o;
	}

	public Integer getCoste() {
		return coste;
	}

	public void setCoste(Integer coste) {
		this.coste = coste;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
