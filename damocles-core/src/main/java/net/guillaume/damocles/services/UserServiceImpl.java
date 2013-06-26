package net.guillaume.damocles.services;

import java.util.List;
import net.guillaume.damocles.dao.GuardDao;
import net.guillaume.damocles.dao.UserDao;
import net.guillaume.damocles.entities.Guard;
import net.guillaume.damocles.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GuardDao guardDao;

    public UserServiceImpl() {
	logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    @Transactional
    public User register(String login, String password) {
	logger.info("Registering user (login) : " + login);

	if (userDao.find(login) != null) {
	    throw new IllegalStateException("user already exist");
	}

        return userDao.save(new User(login, password));
    }

    @Override
    public User find(String login) {
	logger.info("Searching for user (login) : " + login);
	return userDao.find(login);
    }
    
    @Override
    public User find(Long id) {
	logger.info("Searching for user (id) : " + id);
	return userDao.findById(id);
    }
    

    @Override
    public List<User> findAll() {
        logger.info("finding all users");                
	throw new UnsupportedOperationException();
    }

    @Override
    @Transactional
    public void save(User user) {
        logger.info("saving user : " + user.getLogin());        
	userDao.save(user);
    }

    @Override
    public void remove(User user) {
        logger.info("removing user : " + user.getLogin());
	throw new UnsupportedOperationException();
    }

    @Override
    @Transactional
    public void checkin(User user) {
        logger.info("checkin for user : " + user.getLogin());
	for (Guard g : user.getGuards()) {
	    g.getTrigger().checkin();
	    guardDao.save(g);
	}
    }
}
