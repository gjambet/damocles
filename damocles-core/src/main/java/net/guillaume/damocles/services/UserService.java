package net.guillaume.damocles.services;

import java.util.List;

import net.guillaume.damocles.entities.User;
import org.springframework.stereotype.Repository;

public interface UserService {

    User register(String login, String password);

    User find(String login);

    User find(Long id);

    List<User> findAll();

    void save(User user);

    void remove(User user);

    void checkin(User user);

}
