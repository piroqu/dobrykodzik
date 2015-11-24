package application.service;
// Generated 2015-11-24 00:08:03 by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import application.model.Pozycja;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Pozycja.
 * @see hibernate.Pozycja
 * @author Hibernate Tools
 */
@Stateless
public class PozycjaHome {

	private static final Log log = LogFactory.getLog(PozycjaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Pozycja transientInstance) {
		log.debug("persisting Pozycja instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Pozycja persistentInstance) {
		log.debug("removing Pozycja instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Pozycja merge(Pozycja detachedInstance) {
		log.debug("merging Pozycja instance");
		try {
			Pozycja result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pozycja findById(Integer id) {
		log.debug("getting Pozycja instance with id: " + id);
		try {
			Pozycja instance = entityManager.find(Pozycja.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
