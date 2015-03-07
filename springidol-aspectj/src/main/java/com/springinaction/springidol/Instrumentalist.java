package com.springinaction.springidol;

public class Instrumentalist implements Performer {
    private Instrument instrument;

    public void perform() throws PerformanceException {
        instrument.play();
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
