package com.google;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSettings {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.out.println("GCrome Google testing");
        System.setProperty("webdriver.chrome.driver", "/home/dmitry/DevTools/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void close() {
        System.out.println("GChrome Google tesing is complete");
        driver.quit();
    }
}
