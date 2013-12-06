package net.guillaume.commons.lang;

import java.util.Calendar;
import java.util.Date;

public class TimeVariant {

    public Date getTime() {
        return Calendar.getInstance().getTime();
    }

}
