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
	private int critico;
	private int numHabilidad;
	private boolean dmgverdadero;
	private boolean robovida;
	private double porcentajeRV;
	private TiposRobosVida tipoRobovida;
	private int precision;
	
	public Habilidad() {
		
	}

	

	public Habilidad(Integer da�o, Integer coste, int critico, int numHabilidad, boolean dmgverdadero, boolean robovida,
			double porcentajeRV, TiposRobosVida tipoRobovida, int precision) {
		super();
		this.da�o = da�o;
		this.coste = coste;
		this.critico = critico;
		this.numHabilidad = numHabilidad;
		this.dmgverdadero = dmgverdadero;
		this.robovida = robovida;
		this.porcentajeRV = porcentajeRV;
		this.tipoRobovida = tipoRobovida;
		this.precision = precision;
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



	public int getCritico() {
		return critico;
	}



	public void setCritico(int critico) {
		this.critico = critico;
	}



	public int getNumHabilidad() {
		return numHabilidad;
	}



	public void setNumHabilidad(int numHabilidad) {
		this.numHabilidad = numHabilidad;
	}



	public boolean isDmgverdadero() {
		return dmgverdadero;
	}



	public void setDmgverdadero(boolean dmgverdadero) {
		this.dmgverdadero = dmgverdadero;
	}



	public boolean isRobovida() {
		return robovida;
	}



	public void setRobovida(boolean robovida) {
		this.robovida = robovida;
	}



	public double getPorcentajeRV() {
		return porcentajeRV;
	}



	public void setPorcentajeRV(double porcentajeRV) {
		this.porcentajeRV = porcentajeRV;
	}



	public TiposRobosVida getTipoRobovida() {
		return tipoRobovida;
	}



	public void setTipoRobovida(TiposRobosVida tipoRobovida) {
		this.tipoRobovida = tipoRobovida;
	}



	public int getPrecision() {
		return precision;
	}



	public void setPrecision(int precision) {
		this.precision = precision;
	}
	
	
	
}
