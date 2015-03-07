package com.springinaction.springidol2;
//<start id="onemanband_java" /> 

import com.springinaction.springidol.Instrument;
import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.Performer;

import java.util.Map;

public class OneManBand implements Performer {
    private Map<String, Instrument> instruments;

    public OneManBand() {
    }

    public void perform() throws PerformanceException {
        for (String key : instruments.keySet()) {
            System.out.print(key + " : ");
            Instrument instrument = instruments.get(key);
            instrument.play();
        }
    }

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments; //<co id="co_injectInstrumentMap"/>
    }
}
//<end id="onemanband_java" />
