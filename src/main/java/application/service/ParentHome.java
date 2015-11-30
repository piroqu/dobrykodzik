package application.service;
// Generated 2015-11-30 22:06:01 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Parent.
 * @see hibernate.model.dao.Parent
 * @author Hibernate Tools
 */
@Stateless
public class ParentHome {

	private static final Log log = LogFactory.getLog(ParentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Parent transientInstance) {
		log.debug("persisting Parent instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Parent persistentInstance) {
		log.debug("removing Parent instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Parent merge(Parent detachedInstance) {
		log.debug("merging Parent instance");
		try {
			Parent result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Parent findById(Integer id) {
		log.debug("getting Parent instance with id: " + id);
		try {
			Parent instance = entityManager.find(Parent.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
