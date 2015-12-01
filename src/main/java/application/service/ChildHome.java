package application.service;
// Generated 2015-11-30 22:06:01 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.model.Child;
import application.model.Parent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Child.
 * @see hibernate.model.dao.Child
 * @author Hibernate Tools
 */
@Stateless
public class ChildHome {

	private static final Log log = LogFactory.getLog(ChildHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Child transientInstance) {
		log.debug("persisting Child instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public Integer persistAndGetId(Child transientInstance) {
		log.debug("persisting Dziecko instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
			entityManager.flush();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		return transientInstance.getChildId();
	}

	public void remove(Child persistentInstance) {
		log.debug("removing Child instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Child merge(Child detachedInstance) {
		log.debug("merging Child instance");
		try {
			Child result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Child findById(Integer id) {
		log.debug("getting Child instance with id: " + id);
		try {
			Child instance = entityManager.find(Child.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Child findByEmail(String email) {
		log.debug("getting Child instance with email: " + email);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Child> criteria = cb.createQuery(Child.class);
		Root<Child> member = criteria.from(Child.class);
		try {
			criteria.select(member).where(cb.equal(member.get("email"), email));
			Child instance =entityManager.createQuery(criteria).getSingleResult();
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
