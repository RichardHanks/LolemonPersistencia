package lolemon.persistencia.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;
	private String contrase�a;
	private List<Personaje> personajes;
	private Integer puntos;
	private Historial historial;
	private Inventario Inventario;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String contrase�a, ArrayList<Personaje> personajes, Integer puntos) {
		super();
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.personajes = personajes;
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	public Inventario getInventario() {
		return Inventario;
	}

	public void setInventario(Inventario inventario) {
		Inventario = inventario;
	}
	
	
}
