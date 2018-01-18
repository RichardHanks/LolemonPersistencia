package lolemon.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import lolemon.persistencia.base.*;
import lolemon.persistencia.modelo.*;

/**
 * @author Richard
 */



public class Consultas {

	Conexion con = new Conexion();
	EntityManager em;
	
	
	public Consultas() {
		 em = con.getem();
	}
	
	/**
	 * 
	 * @return Todos los personajes, bloqueados o no
	 */
	@SuppressWarnings("unchecked")
	public List<Personaje> getCampeones(){
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p FROM Personaje p", Personaje.class);
		List<Personaje> lista = query.getResultList();
		em.getTransaction().commit();
		return lista;
	}
	/**
	   * Devuelve una lista con los personajes
	   * desbloqueados de un usuario en concreto.
	   * @param nombreUsuario El nombre del usuario cuyos campeones se van a buscar
	   * @return Lista de personajes desbloqueados
	   */
	@SuppressWarnings("unchecked")
	public List<Personaje> getCampeonesDesbloqueados(String nombreUsuario) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT s FROM Usuario p JOIN p.personajes s where p.nombre=:nombre", Usuario.class);
		query.setParameter("nombre", nombreUsuario);
		List<Personaje> lista = query.getResultList();
		List<Personaje> disponibles = new ArrayList<>();
		for (Personaje personaje : lista) {
			if(!personaje.EstaBloqueado()) {
				disponibles.add(personaje);
			}
		}
		em.getTransaction().commit();
		
		return disponibles;
	}
	
	/**
	   * Devuelve una lista con los personajes
	   * bloqueados de un usuario en concreto.
	   * @param nombreUsuario El nombre del usuario cuyos campeones se van a buscar
	   * @return Lista de personajes bloqueados
	   */
	@SuppressWarnings("unchecked")
	public List<Personaje> getCampeonesBloqueados(String nombreUsuario) {

		em.getTransaction().begin();
		Query query = em.createQuery("SELECT s FROM Usuario p JOIN p.personajes s where p.nombre=:nombre", Usuario.class);
		query.setParameter("nombre", nombreUsuario);
		List<Personaje> lista = query.getResultList();
		List<Personaje> disponibles = new ArrayList<>();
		for (Personaje personaje : lista) {
			if(personaje.EstaBloqueado()) {
				disponibles.add(personaje);
			}
		}
		em.getTransaction().commit();
		
		return disponibles;
	}
	
	/**
	 * Inserta usuario en la base de datos
	 * @param nombre El nombre del usuario
	 * @param contrase�a La contrase�a del usuario
	 * @return 
	 */
	public void insertarUsuario(String nombre, String contrase�a) {

		em.getTransaction().begin();
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setContrase�a(contrase�a);
		u.setPuntos(6300);
		em.persist(u);
		em.getTransaction().commit();

	}
	
	/**
	 * Inserta un personaje en la base de datos
	 * @param nombre
	 * @param aspecto
	 * @param habilidades
	 * @param vida
	 * @param energia
	 * @param velocidad
	 * @param defensa
	 * @param sprite
	 */
	public void insertarPersonaje(String nombre, String aspecto, ArrayList<Habilidad> habilidades, 
			Integer vida, Integer energia, Integer velocidad, Integer defensa, String sprite, Usuario u) {
		em.getTransaction().begin();
		Personaje p = new Personaje();
		p.setNombre(nombre);
		p.setAspecto(aspecto);
		p.setHabilidades(habilidades);
		p.setVida(vida);
		p.setEnergia(energia);
		p.setVelocidad(velocidad);
		p.setDefensa(defensa);
		p.setSprite(sprite);
		em.persist(p);
		Usuario usuario =em.find(Usuario.class, u.getNombre());
		u.getPersonajes().add(p);
		em.merge(usuario);
		em.getTransaction().commit();

		
	}
	
	/**
	 * Devuelve el objeto de tipo usuario asociado a un nombre en concreto
	 * @param nombre nombre del usuario a buscar
	 * @return el usuario en cuesti�n
	 */
	public Usuario getUsuario(String nombre) {

		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p FROM Usuario p where p.nombre=:nombre", Usuario.class);
		query.setParameter("nombre", nombre);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Usuario u = (Usuario) query.getSingleResult();
		em.getTransaction().commit();
		return u;
	}
	
	/**
	 * Borra un personaje de la base de datos, esta acci�n no se puede deshacer
	 * @param p El personaje a borrar.
	 */
	public void eliminarPersonaje(Personaje p) {
		em.getTransaction().begin();
		Personaje borrar=em.find(Personaje.class, p.getId());
		em.remove(borrar);
		em.getTransaction().commit();
	}
	
	/**
	 * Actualiza los datos de un personaje en la base de datos.
	 * Debe ser un personaje ya existente en la base de datos.
	 * @param personaje El objeto personaje a actualizar con los nuevos valores
	 * ya guardados en el objeto. Se debera seleccionar el objeto ya existente, modificar los datos
	 * de este y pasarlo a la funcion. En su defecto se puede hacer un find del objeto, por su clave primaria
	 * modificar los valores, y llamar a esta funcion para actualizarlos.
	 */
	public void editarPersonaje(Personaje personaje) {
		em.getTransaction().begin();
		Personaje u=em.find(Personaje.class, personaje.getId());
		u.setNombre(personaje.getNombre());
		u.setAspecto(personaje.getAspecto());
		u.setDefensa(personaje.getDefensa());
		u.setEnergia(personaje.getEnergia());
		u.setEstaBloqueado(personaje.EstaBloqueado());
		u.setHabilidades(personaje.getHabilidades());
		u.setRecargo(personaje.getRecargo());
		u.setSprite(personaje.getSprite());
		u.setVelocidad(personaje.getVelocidad());
		u.setVida(personaje.getVida());
		
		em.merge(u);
		em.getTransaction().commit();
		
		
	}
	
	/**
	 * 
	 * @param numHabilidad El numero de habilidad a buscar
	 * @return La lista de habilidades de un numero de habilidad en concreto
	 */
	@SuppressWarnings("unchecked")
	public List<Habilidad> getHabilidades(int numHabilidad){
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT h from Habilidad h where h.numHabilidad=:numHabilidad", Habilidad.class);
		query.setParameter("numHabilidad", numHabilidad);

		List<Habilidad>u = query.getResultList();
		em.getTransaction().commit();
		return u;
	}
}
