package com.google.citrus;

import com.google.citrus.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebSettings {

    public WebDriver driverD;

    @BeforeTest
    public void setUp() {
        driverD = new WebDriver(); // it doesn't matter if you'll set it here or higher, but it should be set here before @After
    }

    @AfterTest
    public void close() {
        driverD.quit(); // don't forget to quit. Otherwise you'll create a zombie
    }
}
