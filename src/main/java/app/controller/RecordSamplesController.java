package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.dto.TestDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordSamplesController {

    Company company;

    public RecordSamplesController(){
        this.company = App.getInstance().getCompany();
    }

    public List<TestDTO> getAvailableTests(){
        ArrayList<TestDTO> availableTestsDTO = new ArrayList<>();

        for(Test current : company.getAvailableTests())
            availableTestsDTO.add(new TestDTO(current));

        return availableTestsDTO;
    }

    public TestDTO generateSamples(int index, int numSamples){
        Test test = company.getAvailableTests().get(index);

        if(test.getTinNumber() == null && test.getTinNumber().length()!=10)
            throw new IllegalArgumentException("Tin number is null or length is invalid");

        for(int i = 0; i < numSamples; i++)
            test.getSamples().add(new Sample());
        test.setTest_Chemical_DateHour(new Date());
        return new TestDTO(test);
    }

}
