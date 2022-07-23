package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

class HandlingIframe {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://the-internet.herokuapp.com/iframe");

        // Switching to iframe
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        // driver.switchTo().frame("mce_0_ifr");

        // Create web element where we have select tag
        WebElement categoryDropdown = driver.findElement(By.id("tinymce"));

        categoryDropdown.clear();
        categoryDropdown.sendKeys("Chirag Khimani");

        // Switching back to the webpage
        driver.switchTo().defaultContent();

    }
}
