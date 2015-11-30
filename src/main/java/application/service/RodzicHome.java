package application.service;
// Generated 2015-11-30 11:50:25 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import application.model.Rodzic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Rodzic.
 * @see hibernate.model.dao.Rodzic
 * @author Hibernate Tools
 */
@Stateless
public class RodzicHome {

	private static final Log log = LogFactory.getLog(RodzicHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Rodzic transientInstance) {
		log.debug("persisting Rodzic instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public Integer persistAndGetId(Rodzic transientInstance) {
		log.debug("persisting Rodzic instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
			entityManager.flush();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		return transientInstance.getRodzicId();
	}


	public void remove(Rodzic persistentInstance) {
		log.debug("removing Rodzic instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Rodzic merge(Rodzic detachedInstance) {
		log.debug("merging Rodzic instance");
		try {
			Rodzic result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rodzic findById(Integer id) {
		log.debug("getting Rodzic instance with id: " + id);
		try {
			Rodzic instance = entityManager.find(Rodzic.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
