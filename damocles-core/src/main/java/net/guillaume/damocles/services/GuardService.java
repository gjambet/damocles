package net.guillaume.damocles.services;

import java.util.List;

import net.guillaume.damocles.entities.Guard;
import net.guillaume.damocles.entities.Message;
import net.guillaume.damocles.entities.Recipient;
import net.guillaume.damocles.entities.Trigger;

import org.springframework.stereotype.Service;

@Service
public class GuardService {

    public Guard create(Message m, Trigger t, List<Recipient> recipients) {
        // TODO Auto-generated method stub
        return null;
    }

    public void enable(Guard g) {
        throw new UnsupportedOperationException();
    }

    public void disable(Guard g) {
        throw new UnsupportedOperationException();
    }

    public void fire(Guard g) {
        throw new UnsupportedOperationException();
    }


}
