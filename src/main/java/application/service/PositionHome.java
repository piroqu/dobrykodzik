package application.service;
// Generated 2015-11-30 22:06:01 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Position.
 * @see hibernate.model.dao.Position
 * @author Hibernate Tools
 */
@Stateless
public class PositionHome {

	private static final Log log = LogFactory.getLog(PositionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Position transientInstance) {
		log.debug("persisting Position instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Position persistentInstance) {
		log.debug("removing Position instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Position merge(Position detachedInstance) {
		log.debug("merging Position instance");
		try {
			Position result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Position findById(Integer id) {
		log.debug("getting Position instance with id: " + id);
		try {
			Position instance = entityManager.find(Position.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
