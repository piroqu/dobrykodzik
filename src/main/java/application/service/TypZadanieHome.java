package application.service;
// Generated 2015-11-24 00:08:03 by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import application.model.TypZadanie;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TypZadanie.
 * @see hibernate.TypZadanie
 * @author Hibernate Tools
 */
@Stateless
public class TypZadanieHome {

	private static final Log log = LogFactory.getLog(TypZadanieHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TypZadanie transientInstance) {
		log.debug("persisting TypZadanie instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TypZadanie persistentInstance) {
		log.debug("removing TypZadanie instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TypZadanie merge(TypZadanie detachedInstance) {
		log.debug("merging TypZadanie instance");
		try {
			TypZadanie result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TypZadanie findById(Integer id) {
		log.debug("getting TypZadanie instance with id: " + id);
		try {
			TypZadanie instance = entityManager.find(TypZadanie.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
