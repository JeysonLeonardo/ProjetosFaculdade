package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("local");
	
	private static EntityManager entityManager = null;
	
	private Conexao() {
	}
	
	public static EntityManager getConexao() {
		if (factory != null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
}
