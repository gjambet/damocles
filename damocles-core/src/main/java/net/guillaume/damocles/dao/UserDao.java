package net.guillaume.damocles.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.guillaume.damocles.entities.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @PersistenceContext(name = "persistenceUnit")
    private EntityManager em;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public UserDao() {
    }

    @SuppressWarnings("unchecked")
    public User find(String login) {

        Query query = em.createQuery("from User as u where u.login = :login");
        query.setParameter("login", login);
        List<User> l = query.getResultList();

        logger.info("found " + l.size() + " user(s)");

        if (l.isEmpty()) {
            return null;
        }

        return (User) l.get(0);
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public User save(User user) {

        User u = user;
        if (user.getId() == null) {
            em.persist(user);
        } else {
            u = em.merge(user);
        }
        em.flush();

        logger.info("user : " + u.getLogin() + " persisted with id : " + u.getId());
        return u;
    }

}
