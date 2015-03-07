package com.springinaction.springidol.qualifiers;

import com.springinaction.springidol.Instrument;
import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Instrumentalist implements Performer {
    //<start id="autowire_property" />
    @Autowired
    @StringedInstrument
    @Strummed
    private Instrument instrument;

    public void perform() throws PerformanceException {
        getInstrument().play();
    }

    public Instrument getInstrument() {
        return instrument;
    }
    //<end id="autowire_property" />

}