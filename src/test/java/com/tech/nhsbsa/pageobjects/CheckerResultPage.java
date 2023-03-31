package com.tech.nhsbsa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CheckerResultPage {

    private WebDriver driver = null;
    @FindBy(css = "#result-heading > span.form-group-margin")
    private WebElement resultHeadingLabel;

    @FindBy(css = "div#lis-advert.result-option")
    private WebElement resultOption1;

    @FindBy(css = "div#lis-ppc.result-option")
    private WebElement resultOption2;

    @FindBy(css = "#lis-advert > h2")
    private WebElement resultOption1Label;

    @FindBy(css = "#ppc-advert > h2")
    private WebElement resultOption2Label;

    @FindBy(css = "a#lis-button.button.button-get-started")
    private WebElement findMoreCtaOption1;

    @FindBy(css = "a#ppc-button.button.button-get-started")
    private WebElement findMoreCtaOption2;


    //Page Factory Initialising the Driver Elements
    public CheckerResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //method to verify Results Page Label
    public void verifyRestultPage() {
    // To verify if the User has the Result page
        String reportPageUrl = "https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/result";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),reportPageUrl);
        Assert.assertEquals(resultHeadingLabel.getText(),
                "You could get help to pay for your NHS costs");
        System.out.println("****** User has got the Result Options Page with Help Details ********");
    }

    //method to verify the result Help Option 1
    public String verifyHelpOption1() {
        resultOption1.isDisplayed();
        findMoreCtaOption1.isDisplayed();
        System.out.println("User is eligible for Option1 Help");
        return resultOption1Label.getText();
    }

    //method to verify the result Help Option 2
    public String verifyHelpOption2() {
        resultOption2.isDisplayed();
        findMoreCtaOption2.isDisplayed();
        System.out.println("User is eligible for Option2 Help");
        return resultOption2Label.getText();
    }

}
