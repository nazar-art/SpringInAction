//<start id="instrumentalist_java" />
package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;

public class Instrumentalist implements Performer {
    private String song;

    //<end id="autowire_constructor" />
    //<start id="autowire_property" />
    @Autowired
    private Instrument instrument;

    //<start id="autowire_constructor" />
    @Autowired
    public Instrumentalist(Instrument instrument) {
        this.instrument = instrument;
    }

    public void perform() throws PerformanceException {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    //<end id="autowire_property" />

    //<start id="autowire_nonsetter" />
    @Autowired
    public void heresYourInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    //<end id="autowire_nonsetter" />

    public Instrument getInstrument() {
        return instrument;
    }

    //<end id="autowire_setter" />

    //<start id="autowire_setter" />
    @Autowired
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
//<end id="instrumentalist_java" />
