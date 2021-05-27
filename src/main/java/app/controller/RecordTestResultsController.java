package app.controller;

import app.domain.model.Sample;
import app.domain.model.Test;
import app.domain.model.ValueRecords;

import java.util.HashMap;

public class RecordTestResultsController {

    private Test test;

    public void setTest(Test test) {
        this.test = test;
    }

    public RecordTestResultsController() {
    }

    public void putRecord(Sample s, String str, int min, int max, double registeredValue) {
        if(!test.getMap().containsKey(s))
        test.getMap().put(s,new HashMap<String, ValueRecords>(){{put( str , new ValueRecords(min, max, registeredValue));}});
        else
            test.getMap().get(s).put(str, new ValueRecords(min, max, registeredValue));
    }
}
