package com.tech.nhsbsa.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CheckerQuestionairePage {

    private WebDriver driver = null;

    @FindBy(id = "nhsuk-cookie-banner__link_accept_analytics")
    private WebElement cookieAcceptBtn;

    @FindBy(id = "next-button")
    private WebElement startNowCta;

    @FindBy(css = "h1#question-heading.heading-large")
    private WebElement countryQuestionLabel;

    @FindBy(id = "radio-england")
    private WebElement englandRadioBtn;

    @FindBy(id = "next-button")
    private WebElement nextCta;

    @FindBy(id = "question-heading")
    private WebElement questionLabel;

    @FindBy(id = "radio-not-registered")
    private WebElement noDentalRegisteredRadioBtn;

    @FindBy(id = "dob-day")
    private WebElement dayInputField;

    @FindBy(id = "dob-month")
    private WebElement monthInputField;

    @FindBy(id = "dob-year")
    private WebElement yearInputField;

    @FindBy(css = "span.summary")
    private WebElement helpDOB;

    @FindBy(id = "radio-yes")
    private WebElement yesPartnerRadioBtn;

    @FindBy(css = "input#radio-no")
    private WebElement noRadioBtn;


    //Page Factory Initialising the Driver Elements
    public CheckerQuestionairePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // re-usable method to Launch the NHS Web URL and accept the Cookies
    public void openUkUrl() {
        String nhsUkUrl = "https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start";
        driver.get("https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        cookieAcceptBtn.isDisplayed();
        //Verifying if the User is launching the UK based Online Service as UK Citizen
        Assert.assertEquals(driver.getCurrentUrl(),nhsUkUrl);
        System.out.println("User opened the UK URL");
        cookieAcceptBtn.click();
    }

    //re-usable method to start the Checker Service
    public void clickStartService () {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", startNowCta);
        startNowCta.click();
    }

    //method to verify the Country of Residence
    public String verifyCountryOfResidenceQn() {
        return countryQuestionLabel.getText();
    }

    //method to set the Country of Residence as England
    public void setCountryOfResidence() {
        englandRadioBtn.isDisplayed();
        englandRadioBtn.click();
        System.out.println("User lives in the UK ");
    }

    //re-usable method to click Next CTA in the Form
    public void clickNextCta() {
        nextCta.isDisplayed();
        nextCta.click();
    }

    //Re-usable method to choose No option for the Questionaire
    public void setNoOption() {
        noRadioBtn.isDisplayed();
        noRadioBtn.click();
    }

    //re-usable method to verify the Questionaire Label
    public String verifyQnLabel() {
        return questionLabel.getText();
    }

    //method to set the Dentail Practice Location
    public void setDentalRegRadioBtn() {
         noDentalRegisteredRadioBtn.click();
    }

    //method to Enter DOB
    public void setDob() {
        dayInputField.sendKeys("15");
        monthInputField.sendKeys("04");
        yearInputField.sendKeys("1988");
        helpDOB.isDisplayed();
    }

    //method to choose Partner Preference
    public void setPartnerPreference() {
        yesPartnerRadioBtn.isDisplayed();
        yesPartnerRadioBtn.click();
        System.out.println("User completed filling all the Questionaires ");
    }

}
