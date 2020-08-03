package com.google.citrus.wrapperPopup;

import com.google.citrus.WebDriver;


public class Wrapper {
    private WebDriver driverD;
    private final String WRAPPERPATH = "//div[@class='popupWrapper']";
    private final String XBUTTON = "//button[@aria-label='Close']";

    public Wrapper(WebDriver driverD) {
        this.driverD = driverD;
    }

    public boolean wrapperCheck() {
        driverD.waitUntil(50, WRAPPERPATH);
        if (driverD.find(WRAPPERPATH) != 0){
            return true;
        }
        else {
            return false;
        }
    }

    public Wrapper close() {
        driverD.click(XBUTTON);

        return this;
    }
}
