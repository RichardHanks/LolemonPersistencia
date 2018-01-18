package lolemon.persistencia.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Personaje implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Integer Id;
	private String nombre;
	private String aspecto;
	private ArrayList<Habilidad> habilidades;
	private Integer vida;
	private Integer energia;
	private Integer velocidad;
	private Integer defensa;
	private Double recargo = 0.10;
	private String sprite;
	private boolean estaBloqueado;
	
	public Personaje() {
		
	}

	public Personaje(String nombre, String aspecto, ArrayList<Habilidad> habilidades, Integer vida,
			Integer energia, Integer velocidad, Integer defensa, String sprite) {

		this.nombre = nombre;
		this.aspecto = aspecto;
		this.habilidades = habilidades;
		this.vida = vida;
		this.energia = energia;
		this.velocidad = velocidad;
		this.defensa = defensa;
		this.sprite = sprite;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAspecto() {
		return aspecto;
	}

	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
	}

	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	public Integer getDefensa() {
		return defensa;
	}

	public void setDefensa(Integer defensa) {
		this.defensa = defensa;
	}

	public Double getRecargo() {
		return recargo;
	}

	public void setRecargo(Double recargo) {
		this.recargo = recargo;
	}
	
	public String getSprite() {
		return sprite;
	}
	
	public void setSprite(String sprite) {
		this.sprite = sprite;
	}
	
	public boolean EstaBloqueado() {
		return estaBloqueado;
	}

	public void setEstaBloqueado(boolean estaBloqueado) {
		this.estaBloqueado = estaBloqueado;
	}

	@Override
	public String toString() {
		return getNombre();
	}
}
