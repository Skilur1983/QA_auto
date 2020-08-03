package com.google.citrus.login;

import com.google.citrus.WebDriver;

public class LoginStory {
    private WebDriver driver;

    public LoginStory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginStory login(String login) {
        LoginForm form = new LoginForm(driver);
        form.openLoginForm()
                .enterLogin(login)
                .closeLoginForm();
        return this;
    }
}
