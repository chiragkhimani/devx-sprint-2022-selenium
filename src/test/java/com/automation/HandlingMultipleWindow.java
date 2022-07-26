package com.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

class HandlingMultipleWindow {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.com/");

        // Search with TV
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("TV" + Keys.ENTER);

        // Click on first link
        WebElement link = driver.findElement(By.xpath("(//span[@class='s-item__watchheart-icon']/ancestor::li//h3)[1]"));
        link.click();

        // Return current window id
        String originalWindow = driver.getWindowHandle();

        // Retrieve list of window
        Set<String> listOfWindow = driver.getWindowHandles();

        // Switch to new Window
        for(String window : listOfWindow){
            if(!window.equals(originalWindow)){
                driver.switchTo().window(window);
            }
        }

        // Retrieve price from new window
        WebElement price = driver.findElement(By.id("prcIsum"));
        System.out.println(price.getText());

        // Close new window
        driver.close();

        // Switch to original window
        driver.switchTo().window(originalWindow);

    }
}
