package application.service;
// Generated 2015-11-24 00:08:03 by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import application.model.RodzicDziecko;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class RodzicDziecko.
 * @see hibernate.RodzicDziecko
 * @author Hibernate Tools
 */
@Stateless
public class RodzicDzieckoHome {

	private static final Log log = LogFactory.getLog(RodzicDzieckoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(RodzicDziecko transientInstance) {
		log.debug("persisting RodzicDziecko instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(RodzicDziecko persistentInstance) {
		log.debug("removing RodzicDziecko instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public RodzicDziecko merge(RodzicDziecko detachedInstance) {
		log.debug("merging RodzicDziecko instance");
		try {
			RodzicDziecko result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RodzicDziecko findById(Integer id) {
		log.debug("getting RodzicDziecko instance with id: " + id);
		try {
			RodzicDziecko instance = entityManager.find(RodzicDziecko.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
