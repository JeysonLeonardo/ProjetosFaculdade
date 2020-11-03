package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import connection.Conexao;
import model.Dono;

public class DonoRepository {

	@PersistenceUnit(unitName = "local")
	private EntityManager entityManager;
	
	public DonoRepository() {
		this.entityManager = Conexao.getConexao();
	}
	
	public void save(Dono dono) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.flush();
			this.entityManager.persist(dono);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}
	
	public void update(Dono dono) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(dono);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}
	
	public void delete(Dono dono) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(dono);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Dono> find() {
		List<Dono> list = new ArrayList<>();
		try {
			this.entityManager.getTransaction().begin();
			String sql = "SELECT d FROM Dono d";
			Query query = this.entityManager.createQuery(sql);
			list = query.getResultList();
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Dono findById(int id) {
		Dono dono = null;
		try {
			this.entityManager.getTransaction().begin();
			String sql = "SELECT d FROM Dono d WHERE d.codigo = :id";
			Query query = this.entityManager.createQuery(sql).setParameter("id", id);
			dono = (Dono) query.getSingleResult();
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dono;
	}
}
