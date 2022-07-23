package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.com/");

        // Create web element where we have select tag
        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));

        // Wrap web element with Select class methods
        Select catDropdownSelect = new Select(categoryDropdown);

        catDropdownSelect.selectByVisibleText("Baby");
        Thread.sleep(3000);

        catDropdownSelect.selectByValue("11116");
        Thread.sleep(3000);

        catDropdownSelect.selectByIndex(5);
        Thread.sleep(3000);

        List<WebElement> options = catDropdownSelect.getOptions();

        for (WebElement ele : options) {
            System.out.println(ele.getText());
        }

    }
}
