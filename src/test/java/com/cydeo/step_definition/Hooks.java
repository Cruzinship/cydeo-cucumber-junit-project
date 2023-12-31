package com.cydeo.step_definition;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to create "pre" and "post" condition
for all the SCENARIOS and even STEPS.
 */
@Slf4j
public class Hooks {

    //import the @Before coming from io.cucumber.java
    @Before(order = 1)
    public void setupMethod() {
        log.debug("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    @Before(value = "@ui", order = 2)
    public void login_scenario_before() {
        log.info("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    /*
    @After will be executed automatically after EVERY scenario in the project.
     */
    @After()
    public void teardownMethod(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        log.info("---> @After: RUNNING AFTER EACH SCENARIO");

        BrowserUtils.sleep(2);
        Driver.closeDriver();

    }

    @BeforeStep
    public void setupStep() {
        log.error("-----> @BeforeSTEP : Running before each step!");
    }

    @AfterStep
    public void teardownStep() {
        log.warn("-----> @AfterSTEP : Running after each step!");
    }


}
