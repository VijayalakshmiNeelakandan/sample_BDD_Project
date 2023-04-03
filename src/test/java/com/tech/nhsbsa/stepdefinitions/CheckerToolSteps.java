package com.tech.nhsbsa.stepdefinitions;

import com.tech.nhsbsa.driverutil.DriverFactory;
import com.tech.nhsbsa.pageobjects.CheckerQuestionairePage;
import com.tech.nhsbsa.pageobjects.CheckerResultPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckerToolSteps {

    private WebDriver driver;
    private CheckerQuestionairePage checkerToolPage;
    private CheckerResultPage checkerResultPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getBrowser();
        checkerToolPage = new CheckerQuestionairePage(driver);
        checkerResultPage = new CheckerResultPage(driver);
    }

    @Given("^I am a citizen of the UK$")
    public void setCitizenshipOfTheUser() {
        checkerToolPage.openUkUrl();
        checkerToolPage.clickStartService();
    }

    @When("^I put my circumstances into the Checker tool$")
    public void fillCheckerToolQuestionaires() {
        Assert.assertEquals(checkerToolPage.verifyCountryOfResidenceQn(), "Which country do you live in?");
        checkerToolPage.setCountryOfResidence();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(), "Is your GP practice in Scotland or Wales?");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(), "Which country is your dental practice in?");
        checkerToolPage.setDentalRegRadioBtn();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(), "What is your date of birth?");
        checkerToolPage.setDob();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(), "Do you live with a partner?");
        checkerToolPage.setPartnerPreference();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(),
                "Do you or your partner claim any benefits or tax credits?");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(),
                "Are you pregnant or have you given birth in the last 12 months?");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(),
                "Do you have an injury or illness caused by serving in the armed forces?");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(),
                "Do you have diabetes?");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(),
                "To check what help you can get with NHS charges, " +
                        "we need to know if you're affected by any of these conditions");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(),
                "Do you have glaucoma?");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
        Assert.assertEquals(checkerToolPage.verifyQnLabel(),
                "Do you or your partner live permanently in a care home?");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
        Assert.assertTrue(checkerToolPage.verifyQnLabel().startsWith("Do you and your partner have more"),
                "Do you and your partner have more than £16,000 in savings, investments or property?");
        checkerToolPage.setNoOption();
        checkerToolPage.clickNextCta();
    }

    @Then("^I should get a result of whether I will get help or not$")
    public void verifyCheckerServiceResultPage() {
        checkerResultPage.verifyRestultPage();
        Assert.assertEquals(checkerResultPage.verifyHelpOption1(), "Apply for further help");
        System.out.println("User is eligible for Option 1 Help - Apply for Further Help");
        Assert.assertEquals(checkerResultPage.verifyHelpOption2(), "Prepay for prescriptions");
        System.out.println("User is eligible for Option 1 Help - Prepay for prescriptions");
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
