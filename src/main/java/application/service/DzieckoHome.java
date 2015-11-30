package application.service;
// Generated 2015-11-30 11:50:25 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import application.model.Dziecko;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Dziecko.
 * @see hibernate.model.dao.Dziecko
 * @author Hibernate Tools
 */
@Stateless
public class DzieckoHome {

	private static final Log log = LogFactory.getLog(DzieckoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Dziecko transientInstance) {
		log.debug("persisting Dziecko instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public Integer persistAndGetId(Dziecko transientInstance) {
		log.debug("persisting Dziecko instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
			entityManager.flush();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		return transientInstance.getDzieckoId();
	}

	public void remove(Dziecko persistentInstance) {
		log.debug("removing Dziecko instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Dziecko merge(Dziecko detachedInstance) {
		log.debug("merging Dziecko instance");
		try {
			Dziecko result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Dziecko findById(Integer id) {
		log.debug("getting Dziecko instance with id: " + id);
		try {
			Dziecko instance = entityManager.find(Dziecko.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
