//<start id="onemanband_java" /> 
package com.springinaction.springidol;

import java.util.Collection;

public class OneManBand implements Performer {
    private Collection<Instrument> instruments;

    public OneManBand() {
    }

    public void perform() throws PerformanceException {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments; //<co id="co_injectInstrumentCollection"/>
    }
}
//<end id="onemanband_java" />
