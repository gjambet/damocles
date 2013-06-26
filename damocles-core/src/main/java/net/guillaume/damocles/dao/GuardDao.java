package net.guillaume.damocles.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.guillaume.damocles.entities.Guard;
import net.guillaume.damocles.entities.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GuardDao {

    @PersistenceContext(name = "persistenceUnit")
    private EntityManager em;

    private Logger logger;

    public GuardDao() {
	logger = LoggerFactory.getLogger(getClass());
    }

    public Guard save(Guard guard) {
	Guard g = guard;
	if (guard.getId() == null) {
	    em.persist(guard);
	} else {
	    g = em.merge(guard);
	}
	em.flush();

	logger.info("guard persisted with id : " + g.getId());
	return g;

    }

}
