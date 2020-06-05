package com.google;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class GChrome extends WebSettings{

    @Test
    public void gChrome1() {
        driver.get("https://www.google.com/"); // simply paste any URL you would like to test
        String title = driver.getTitle();
        System.out.println(title); // remove it or leave it to get your page title
        Assert.assertTrue(title.equals("Google"));

        WebElement GmailLink = driver.findElementByClassName("gb_g");
        GmailLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")));
        WebElement GmailLogin = driver.findElementByXPath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a");
        GmailLogin.click();
    }

    @Test
    public void createAccount() {
        driver.get("https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equals("Gmail")); // to make sure you are on required page

        WebDriverWait wait = new WebDriverWait(driver, 100); // give some time for elements to appear on a page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Створити обліковий запис']")));
        WebElement accountCreationLink = driver.findElementByXPath("//span[text()='Створити обліковий запис']");
        accountCreationLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("jO7h3c")));
        WebElement accountTypeSelection = driver.findElementByClassName("jO7h3c");
        accountTypeSelection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));

        System.out.println(driver.getTitle());

        driver.findElementById("firstName").sendKeys("Name"); // sendKeys sets a name
        driver.findElementById("lastName").sendKeys("Latest"); // sendKeys sets a surname

        Random random = new Random();
        int number = random.nextInt(1000) + 1;
        String user = "Latest" + number;
        driver.findElementById("username").sendKeys(user); // sendKeys sets a username using random function
        System.out.println("New user: " + user);

        String pass = "456321user";
        driver.findElementByName("Passwd").sendKeys(pass); // sendKeys sets a password
        driver.findElementByName("ConfirmPasswd").sendKeys(pass); // sendKeys confirms previously set password

        driver.findElementByXPath("//span[text()='Далі']").click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phoneNumberId")));
        driver.findElementById("phoneNumberId").sendKeys("000000000"); // paste your phonenumber to complete account creation
        driver.findElementByXPath("//span[text()='Далі']").click();
    }
}
