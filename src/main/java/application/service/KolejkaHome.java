package application.service;
// Generated 2015-11-30 11:50:25 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.model.Kolejka;
import application.model.Rodzic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Home object for domain model class Kolejka.
 * @see hibernate.model.dao.Kolejka
 * @author Hibernate Tools
 */
@Stateless
public class KolejkaHome {

	private static final Log log = LogFactory.getLog(KolejkaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Kolejka transientInstance) {
		log.debug("persisting Kolejka instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Kolejka persistentInstance) {
		log.debug("removing Kolejka instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Kolejka merge(Kolejka detachedInstance) {
		log.debug("merging Kolejka instance");
		try {
			Kolejka result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Kolejka findById(Integer id) {
		log.debug("getting Kolejka instance with id: " + id);
		try {
			Kolejka instance = entityManager.find(Kolejka.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Kolejka> findByParentAndWithStatusActivte(Rodzic parent) {
		log.debug("getting Kolejka instance with id: " + parent);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Kolejka> criteria = cb.createQuery(Kolejka.class);
		Root<Kolejka> root = criteria.from(Kolejka.class);
		try {
			criteria.select(root).where(cb.equal(root.get("rodzic"), parent));
			criteria.select(root).where(cb.equal(root.get("status"), true));
			log.debug("get successful");
			List<Kolejka> results =entityManager.createQuery(criteria).getResultList();
			for(Kolejka tmp : results){
				tmp.getTypZadanie().getNazwa();
				tmp.getDziecko().getDzieckoId();
			}
			return results;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
