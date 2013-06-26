package net.guillaume.damocles.services;

import java.util.List;

import net.guillaume.damocles.entities.Guard;
import net.guillaume.damocles.entities.Message;
import net.guillaume.damocles.entities.Recipient;
import net.guillaume.damocles.entities.Trigger;

import org.springframework.stereotype.Service;

@Service
public class GuardServiceImpl implements GuardService {

    @Override
    public Guard create(Message m, Trigger t, List<Recipient> recipients) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void enable(Guard g) {
	throw new UnsupportedOperationException();
    }

    @Override
    public void disable(Guard g) {
	throw new UnsupportedOperationException();
    }

    @Override
    public void fire(Guard g) {
	throw new UnsupportedOperationException();
    }

    
    
}
