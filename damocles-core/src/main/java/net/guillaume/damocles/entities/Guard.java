package net.guillaume.damocles.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

// FIXME : we should be able to have a generic message and a custom message for each recipient, thus breaking current model.

@Entity
public class Guard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Trigger trigger;

    @ManyToMany
    private List<Recipient> recipients;

    @OneToOne(cascade = CascadeType.ALL)
    private Message message;

    public Guard() {
	recipients = new ArrayList<Recipient>();
    }

    public Trigger getTrigger() {
	return trigger;
    }

    public Long getId() {
	return id;
    }
}
