package lolemon.persistencia.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Habilidad extends Movimiento implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer daño;
	private Integer coste;
	
	public Habilidad() {
		
	}

	public Habilidad(Integer daño, Integer coste) {
		super();
		this.daño = daño;
		this.coste = coste;

	}

	public Integer getDaño() {
		return daño;
	}

	public void setDaño(Integer daño) {
		this.daño = daño;
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
