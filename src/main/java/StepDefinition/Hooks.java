package StepDefinition;

import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks extends DriverManager {

    @Before
    public void setUp() throws IOException {
        openBrowser();
    }

    @After
    public void afterScenario() {

        System.out.println("After scenario");
        CloseDriver();
    }
}
