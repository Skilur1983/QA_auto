package com.google;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class GChrome extends WebSettings{

    @Test
    public void gChrome1() {
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equals("Google"));

        System.out.println("Starting search");
        WebElement searchField = driver.findElementByName("q");
        System.out.println("Input found");

        WebElement GmailLink = driver.findElementByClassName("gb_g");
        GmailLink.click();
        System.out.println("Gmail");

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
        Assert.assertTrue(title.equals("Gmail"));

        WebDriverWait wait = new WebDriverWait(driver, 100);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ow286 > span > span")));
        WebElement accountCreationLink = driver.findElementByXPath("//*[@id=\"ow286\"]/span/span");
        accountCreationLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#initialView > div.xkfVF.nnGvjf > div.JPdR6b.ILYVD.qjTEB > div > div > span:nth-child(1) > div.uyYuVb.oJeWuf > div")));
        WebElement accountTypeSelection = driver.findElementByClassName("jO7h3c");
        accountTypeSelection.click();
        System.out.println("jO7h3c");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));

        System.out.println(driver.getTitle());

        driver.findElementById("firstName").sendKeys("Name");
        driver.findElementById("lastName").sendKeys("Latest");

        Random random = new Random();
        int number = random.nextInt(1000) + 1;
        String user = "Latest" + number;
        driver.findElementById("username").sendKeys(user);
        System.out.println("New user: " + user);

        String pass = "456321user";
        driver.findElementByName("Passwd").sendKeys(pass);
        driver.findElementByName("ConfirmPasswd").sendKeys(pass);
        System.out.println("Password: " + pass);

        driver.findElementByXPath("//span[text()='Далі']").click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phoneNumberId")));
        driver.findElementById("phoneNumberId").sendKeys("000000000");
        driver.findElementByXPath("//span[text()='Далі']").click();

    }
}
