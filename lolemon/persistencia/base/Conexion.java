package lolemon.persistencia.base;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lolemon.consultas.Consultas;
import lolemon.persistencia.modelo.Habilidad;
import lolemon.persistencia.modelo.Personaje;
import lolemon.persistencia.modelo.Usuario;

public class Conexion {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public Conexion() {
		emf = Persistence.createEntityManagerFactory("$objectdb/db/lolemon.odb");
		em = emf.createEntityManager();
		 
	}
	
	public static void main(String[] args) {
		 emf = Persistence.createEntityManagerFactory("$objectdb/db/lolemon.odb");
		 em = emf.createEntityManager();
		 
		 crear();
		 
	
		
	}
	
	public EntityManager getem() {
		return em;

	}
	
	private static void crear() {
		 em.getTransaction().begin();
		 
		 Habilidad h = new Habilidad(50, 25);
		 h.setNombre("sentencia de muerte");
		 h.setDescripcion("lanza un gancho");
		 h.setIcono("imagenes/whatever");
		 em.persist(h);
		 
		 Personaje p = new Personaje();
		 p.setNombre("ahri");
		 p.setVida(100);
		 p.setAspecto("/54/ahri/splash/ahri.jpg");
		 System.out.println(p.getAspecto());
		 Personaje p1 = new Personaje();
		 p1.setNombre("xinzhao");
		 em.persist(p);
		 em.persist(p1);
		 
		 p1.setEstaBloqueado(false);
		 p.setEstaBloqueado(true);
		 
		 Usuario u = new Usuario();
		 ArrayList<Personaje> personajes = new ArrayList<>();
		 personajes.add(p);
		 personajes.add(p1);
		 
		 u.setNombre("richard");
		 u.setContraseña("caca");
		 u.setPersonajes(personajes);
		 em.persist(u);
		 em.getTransaction().commit();
		 
		 
		 Consultas c = new Consultas();
		 List<Personaje> personajess = c.getCampeonesDesbloqueados("richard");
		 System.out.println(personajess);

		 p1.setNombre("margarita");
		 c.editarPersonaje(p1);
		 System.out.println();
		 
		 List<Personaje> personajes2 = c.getCampeonesDesbloqueados("richard");
		 System.out.println(personajes2);
	}
}
