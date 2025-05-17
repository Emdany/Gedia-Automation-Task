package StepDefinition;

import Pages.pageHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions {
    pageHelper PageHelper = new pageHelper();
    @Given("I am on the Google home page")
    public void iAmOnTheGoogleHomePage() {
        PageHelper.assertGoogleHomePage();
    }

    @When("I Change Language to English")
    public void iChangeLanguageToEnglish() {
    PageHelper.changeLanguage();
    }


    @When("I search for Mercedes A class")
    public void iSearchForMercedesAClass() {
        PageHelper.searchFor();
    }

    @Then("I should see the specified result i want")
    public void iShouldSeeTheSpecifiedResultIWant() {
        PageHelper.searchForMercedesSpecs();
    }
}
