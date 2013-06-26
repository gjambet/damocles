package net.guillaume.damocles.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import net.guillaume.commons.lang.TimeVariant;

@Entity
public class Trigger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    private TimeVariant tv;
    
    private Date lastCheckin;
    
    private int gracePeriod; // in s

    public void checkin() {
	lastCheckin = tv.getTime();
    }

    public Date getDeadline() {
	Calendar c = Calendar.getInstance();
	c.setTime(lastCheckin);
	c.add(Calendar.SECOND, gracePeriod);
	return c.getTime();
    }

    public boolean isTrigged() {
	return (tv.getTime().after(getDeadline()));
    }

    public Date getLastCheckin() {
	return lastCheckin;
    }
}
