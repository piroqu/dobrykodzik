package application.service;
// Generated 2015-11-24 00:08:03 by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.model.Dziecko;
import application.model.Pozycja;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

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

	public List<Pozycja> findByChilId(Dziecko id) {
		log.debug("getting Pozycja instance with id: " + id);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pozycja> criteria = cb.createQuery(Pozycja.class);
		Root<Pozycja> positions = criteria.from(Pozycja.class);
		criteria.select(positions).where(cb.equal(positions.get("dziecko"), id));
		return entityManager.createQuery(criteria).getResultList();
	}
}
