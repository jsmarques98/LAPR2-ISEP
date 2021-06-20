package app.domain.model;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class CompanyTest {
    @BeforeEach
    void instantiation() {
        Company company = new Company("testDesignation");
        //Como não está implementado inserimos manualmente
        ParameterTest parameterTest1 = new ParameterTest("HB000", "Haemo", "Haemoglobin (HB)");
        ParameterTest parameterTest2 = new ParameterTest("WBC00", "White", "White Cell Count (WBC)");
        ParameterTest parameterTest3 = new ParameterTest("PLT00", "Platelet", "Platelet Count (PLT)");
        ParameterTest parameterTest4 = new ParameterTest("RBC00", "Red Blood", "Red Blood Count (RBC)");
        ParameterTest parameterTest5 = new ParameterTest("MCV00", "Mean Cell", "Mean Cell Volume (MCV)");
        ParameterTest parameterTest6 = new ParameterTest("MCH00", "Mean Haemo", "Mean Cell Haemoglobin (MCH)");
        ParameterTest parameterTest7 = new ParameterTest("MCHC0", "Mean Haemo Con.", "Mean Cell Haemoglobin Concentration (MCHC)");
        ParameterTest parameterTest8 = new ParameterTest("ESR00", "Eryth Sed. Rate", "Erythrocyte Sedimentation Rate (ESR)");
        ParameterTest parameterTest9 = new ParameterTest("IgGAN", "IgGAN", "IgGAN");
        company.parameterList.add(parameterTest1);
        company.parameterList.add(parameterTest2);
        company.parameterList.add(parameterTest3);
        company.parameterList.add(parameterTest4);
        company.parameterList.add(parameterTest5);
        company.parameterList.add(parameterTest6);
        company.parameterList.add(parameterTest7);
        company.parameterList.add(parameterTest8);
        company.parameterList.add(parameterTest9);


        Client c1 = new Client("Pedro","5555555555","Porto","M", "555555555555", "555555555555","03/05/2021","55555555555","pedro@gmail.com");
        Client c2 = new Client("Joao","9999999999","Lisboa", "M", "9999999999999999","555555555555","03/05/2021","55555555555","manel@gmail.com");
        Client c3 = new Client("Rui","1000000000","Faro", "M", "0000000000000000","555555555555","03/05/2021","55555555555","manel@gmail.com");
        company.clientsList.add(c1);
        company.clientsList.add(c2);
        company.clientsList.add(c3);


        ArrayList listCat;
        ArrayList listPara;
        Category category1 = new Category("categoria1","codigo1");
        Category category2 = new Category("categoria2","codigo2");
        listCat = new ArrayList<>();
        listPara = new ArrayList<>();
        listCat.add(category1);
        listCat.add(category2);
        listPara.add(parameterTest1);
        listPara.add(parameterTest2);

        Test test1 =  new Test("0000000000","0000","sad","sdsad1",  listCat, listPara);
        Test test2 =  new Test("0000000001","0001","sad1","sdsad2",  listCat, listPara);
        Test test3 =  new Test("0000000002","0002","sad2","sdsad3",  listCat, listPara);
        Test test4 =  new Test("0000000003","0003","sad3","sdsad4",  listCat, listPara);

        ValueRecords v1 = new ValueRecords(test1.getTestID(),100, 200, 119,"IgGAN", new Date());
        ValueRecords v2 = new ValueRecords(test1.getTestID(),100, 200, 119,"IgGAN", new Date());
        ValueRecords v3 = new ValueRecords(test1.getTestID(),200, 300, 180,"IgGAN", new Date());
        ValueRecords v4 = new ValueRecords(test1.getTestID(),100, 200, 119,"IgGAN", new Date());
        ValueRecords v5 = new ValueRecords(test1.getTestID(),100, 200, 1,"IgGAN", new Date());
        ValueRecords v6 = new ValueRecords(test1.getTestID(),100, 200, 119,"IgGAN", new Date());
        ValueRecords v7 = new ValueRecords(test1.getTestID(),100, 200, 1,"IgGAN", new Date());
        company.valueRecordsList.add(v1);
        company.valueRecordsList.add(v2);
        company.valueRecordsList.add(v3);
        company.valueRecordsList.add(v4);
        company.valueRecordsList.add(v5);
        company.valueRecordsList.add(v6);
        company.valueRecordsList.add(v7);

        String arg1 = "00000000001";
        String arg2 = "00000000002";
        String arg3 = "00000000003";
//        String arg4 = "00000000004";
        String barcodeAdapter = "app.controller.utils.BarcodeAdapter";
        Sample sample1 = new Sample(arg1, barcodeAdapter);
        Sample sample2 = new Sample(arg2, barcodeAdapter);
        Sample sample3 = new Sample(arg3, barcodeAdapter);
        test1.getSamples().add(sample1);
        test1.getSamples().add(sample2);
        test1.getSamples().add(sample3);

        company.tests.add(test1);

        Category category3 = new Category("categoria3","codigo3");
        Category category4 = new Category("categoria4","codigo4");
        Category category5 = new Category("categoria5","codigo5");
        company.categories.add(category1);
        company.categories.add(category2);
        company.categories.add(category3);
        company.categories.add(category4);
        company.categories.add(category5);
        Set<Category> listCat1 = new TreeSet<Category>();
        listCat1.add(category1);
        listCat1.add(category2);
        listCat1.add(category3);
        Set<Category> listCat2 = new TreeSet<Category>();
        listCat2.add(category4);
        listCat2.add(category5);
        TestType t1 = new TestType("12345","desc1","colect1",listCat1);
        TestType t2 = new TestType("54321","desc2","colect2",listCat2);
        company.save(t1);
        company.save(t2);
    }

    @org.junit.jupiter.api.Test
    void start(){

    }
}
