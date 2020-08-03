package com.google.citrus.login;

import com.google.citrus.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm {
    private WebDriver driverD;
    private WebDriverWait wait;
    private final String FORMPATH = "//div/a[@class='link-to']";
    private final String LOGINPATH = "phone";
    private final String FORMTITLE = "//h2[text()='вхід']";
    private final String XBUTTON = "//button/i[@class='el-dialog__close el-icon el-icon-close']";

    public LoginForm(WebDriver driverD) {
        this.driverD = driverD;
    }

    public LoginForm openLoginForm() {
        driverD.waitUntil(50, FORMPATH);
        driverD.click(FORMPATH);

        return this;
    }

    public LoginForm enterLogin(String login) {
        driverD.waitUntil(50, FORMTITLE);
        driverD.sendKeysByName(LOGINPATH, login);

        return this;
    }

    public LoginForm closeLoginForm() {
        driverD.click(XBUTTON);

        return this;
    }
}
