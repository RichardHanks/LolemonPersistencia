package lolemon.persistencia.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Item extends Movimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean vida;
	private Integer incremento;
	
	public Item() {
		
	}

	public Item(boolean tipo, Integer incremento) {
		super();
		this.vida = tipo;
		this.incremento = incremento;
	}

	public boolean getvida() {
		return vida;
	}

	public void setVida(boolean vida) {
		this.vida = vida;
	}

	public Integer getIncremento() {
		return incremento;
	}

	public void setIncremento(Integer incremento) {
		this.incremento = incremento;
	}
	
	
}
