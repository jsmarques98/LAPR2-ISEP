package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.dto.TestDTO;

import java.util.ArrayList;
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

    public void generateSamples(int index, int numSamples){
        Test test = company.getAvailableTests().get(index);
        for(int i = 0; i < numSamples; i++)
            test.getSamples().add(new Sample(test.getTinNumber()+(i+1)));
        test.setSampleLocalTime();
        test.setSampleLocalDate();
        company.getAvailableTests().set(index, test);
    }

}
