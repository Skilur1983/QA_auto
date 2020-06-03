package com.google;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox {

    @Test
    public void fireFox() {
        System.setProperty("webdriver.gecko.driver", "/home/dmitry/DevTools/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");
        driver.quit();
    }
}
