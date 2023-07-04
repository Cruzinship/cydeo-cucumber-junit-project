package com.cydeo.step_definition;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class GoogleFunction_StepDefs {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    Logger log = LogManager.getLogger(this.getClass());
    @Given("User is on the google base page")
    public void userIsOnTheGoogleBasePage() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://www.Google.com");
    }

    @When("User chooses to search for Tesla page")
    public void userChoosesToSearchForTeslaPage() {
        googleSearchPage.searchBox.sendKeys("Tesla", Keys.ENTER);
    }

    @And("User clicks onto Tesla.com page")
    public void userClicksOntoTeslaComPage() {
        WebElement linkWeNeed = Driver.getDriver().findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        linkWeNeed.click();
    }

    @Then("User will in the Tesla Website")
    public void userWillInTheTeslaWebsite() {
        String Title = Driver.getDriver().getTitle();
        System.out.println(Title);
        Assert.assertEquals(Title, "Electric Cars, Solar & Clean Energy | Tesla");
        Driver.closeDriver();
    }
}
