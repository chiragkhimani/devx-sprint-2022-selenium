package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class JsExecutor {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement usernameInput = driver.findElement(By.id("txtUsername"));
        WebElement passInput = driver.findElement(By.id("txtPassword"));
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        usernameInput.sendKeys("Admin");
        js.executeScript("arguments[0].style.border = '2px solid red';",usernameInput);
        Thread.sleep(3000);

        passInput.sendKeys("admin123");
        js.executeScript("arguments[0].style.border = '2px solid red';",passInput);
        Thread.sleep(3000);

        js.executeScript("arguments[0].style.border = '2px solid red';",loginBtn);
//        loginBtn.click();
    }
}
