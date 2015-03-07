//<start id="instrumentalist_java" /> 
package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("eddie")
public class Instrumentalist implements Performer {
    //<start id="autowire_property" />
    @Autowired
    private Instrument instrument;

    // ...
//<end id="instrumentalist_java" />
    public void perform() throws PerformanceException {
        instrument.play();
    }

    //<end id="autowire_property" />

    public Instrument getInstrument() {
        return instrument;
    }
//<start id="instrumentalist_java_2" /> 
}
//<end id="instrumentalist_java_2" />
