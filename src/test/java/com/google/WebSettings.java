package com.google;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSettings {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/dmitry/DevTools/chromedriver"); // here you set path to the ChromeDriver on your drive
        driver = new ChromeDriver(); // it doesn't matter if you'll set it here or higher, but it should be set here before @After
    }

    @After
    public void close() {
        driver.quit(); // don't forget to quit. Otherwise you'll create a zombie
    }
}
