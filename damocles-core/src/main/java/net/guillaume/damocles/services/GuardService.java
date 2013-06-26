package net.guillaume.damocles.services;

import java.util.List;

import net.guillaume.damocles.entities.Guard;
import net.guillaume.damocles.entities.Message;
import net.guillaume.damocles.entities.Recipient;
import net.guillaume.damocles.entities.Trigger;

public interface GuardService {

    public Guard create(Message m, Trigger t, List<Recipient> recipients);

    public void enable(Guard g);

    public void disable(Guard g);

    public void fire(Guard g);

}
