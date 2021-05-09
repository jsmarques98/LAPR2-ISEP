package app.controller;

public class RegisterTest {

    /**
     * The name of the test to be registered
     */
    private String testName;

    /**
     * The sample of the test to be registered
     */
    private String sample;

    /**
     * Buils an instance of the test that is being created
     * @param testName The name of the test to be registered
     * @param sample The sample of the test to be registered
     */
    public RegisterTest(String testName, String sample){
        this.testName = testName;
        this.sample = sample;
    }


}
