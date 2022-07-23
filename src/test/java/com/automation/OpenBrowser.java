package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OpenBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.com/");

        // Type TV into search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("TV");

        WebElement searchBtn = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchBtn.click();

        Select select = new Select(searchBox);
        select.selectByIndex(1);

        List<WebElement> listOfWebElement = driver.findElements(By.xpath("//span[@class='s-item__price']"));

        for (WebElement ele : listOfWebElement) {
            System.out.println(ele.getText());
        }

        // Close the browser
        driver.quit();
    }
}
