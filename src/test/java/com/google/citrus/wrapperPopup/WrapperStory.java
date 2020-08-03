package com.google.citrus.wrapperPopup;

import com.google.citrus.WebDriver;

public class WrapperStory {
    private WebDriver driver;

    public WrapperStory(WebDriver driver){
        this.driver = driver;
    }

    public WrapperStory wrapperClose(){
        Wrapper wrapper = new Wrapper(driver);
        if(wrapper.wrapperCheck()) {
            wrapper.close();
        }

        return this;
    }
}
