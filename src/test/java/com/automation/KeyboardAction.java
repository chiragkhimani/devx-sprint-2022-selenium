package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class KeyboardAction {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.com/");

        WebElement signInLink = driver.findElement(By.xpath("//span[@id='gh-ug']/a"));

        Actions action = new Actions(driver);

        action.keyDown(Keys.CONTROL).click(signInLink).keyUp(Keys.CONTROL).build().perform();

    }
}
