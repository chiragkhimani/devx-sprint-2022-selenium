package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragAndDrop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iframe);

        List<WebElement> listOfImages = driver.findElements(By.xpath("//ul[@id='gallery']/li"));
        WebElement trashArea = driver.findElement(By.id("trash"));

        Actions action = new Actions(driver);

        for(WebElement img : listOfImages) {
            action.dragAndDrop(img, trashArea).pause(1000).build().perform();
        }

        driver.switchTo().defaultContent();
    }
}
