package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class RadioButtonAndCheckBoxes {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        WebElement locatedRadioBtn = driver.findElement(By.id("LH_Located"));
        System.out.println(locatedRadioBtn.isSelected());

        locatedRadioBtn.click();
        System.out.println(locatedRadioBtn.isSelected());

        driver.quit();
    }
}
