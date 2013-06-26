package net.guillaume.damocles.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Guard> guards;

    private String login;
    private String password;

    public User() {
	this.guards = new ArrayList<Guard>();
    }

    public User(String login, String password) {
	this();
	this.login = login;
	this.password = password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getPassword() {
	return password;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getLogin() {
	return login;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getId() {
	return id;
    }

    public List<Guard> getGuards() {
	return guards;
    }
}
