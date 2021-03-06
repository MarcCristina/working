package org.fasttrackit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");

        driver = DriverFactory.getWebDriver(browser);

        driver.get(AppConfig.getSiteUrl());
    }

    @After
    public void teardown() {
        driver.quit();
    }

    protected void mouseOverAndClickLast(List<By> locators) {
        Actions actions = mouseOver(locators);

        actions.click().perform();
    }

    protected Actions mouseOver(List<By> locators) {
        Actions actions = new Actions(driver);

        for (By locator : locators) {
            actions.moveToElement(driver.findElement(locator))
                    .perform();
        }
        return actions;
    }

    protected void waitForPageToLoad(long timeout) {
        long waited = 0;
        long pauseMillis = 500;
        do {
            try {
                Thread.sleep(pauseMillis);
            } catch (InterruptedException e) {
                System.out.println("Wait process interrupted.");
            }
            waited += pauseMillis;
        }
        while (waited <= timeout && !((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    protected <T> T initElements(Class<T> pageObjectClass) {
//        waitForPageToLoad(10000);

        return PageFactory.initElements(driver, pageObjectClass);
    }

    protected WebElement getSuccesedmessageContainer(){
        return driver.findElement(By.className("success-msg"));

    }
    protected WebElement getpageTitleContainer(){
        return driver.findElement(By.cssSelector(".page-title h1"));
}}

