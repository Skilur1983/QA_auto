package com.google.citrus;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver {
    private ChromeDriver driver;
    private WebDriverWait wait;

    public WebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "/home/dmitry/DevTools/chromedriver"); // here you set path to the ChromeDriver on your drive
        this.driver = new ChromeDriver(options);

        Dimension screenSize = new Dimension(1440, 980); // sets browser window size
        driver.manage().window().setSize(screenSize);
    }

    public void quit() {
        driver.quit();
    }

    public void get(String url) {
        driver.get(url);
    }

    public int find(String xpath){
        int size;
        size = driver.findElementsByXPath(xpath).size();

        return size;
    }

    public void click(String xpath) {
        driver.findElementByXPath(xpath).click();
    }

    public void sendKeysByXpath(String xpath, String keys) {
        driver.findElementByXPath(xpath).sendKeys(keys);
    }

    public void sendKeysByName(String name, String keys){
        driver.findElementByName(name).sendKeys(keys);
    }

    public void waitUntil(int howLong, String xPath){
        wait = new WebDriverWait(driver, howLong);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    public void waitUntilElementToTextEquivalent(String xpath, String equivalent) {
        WebElement element = driver.findElementByXPath(xpath);
        wait.until(ExpectedConditions.textToBePresentInElement(element, equivalent));
    }

    public void waitUntilAttributeContains (String webElement, String webAttribute, String expectedValue) {
        wait.until(ExpectedConditions.attributeContains(driver.findElementByXPath(webElement), webAttribute, expectedValue));
    }

    public String getText(String xpath){
        String text;
        WebElement element = driver.findElementByXPath(xpath);
        text = element.getText();

        return text;
    }
}
