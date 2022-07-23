package com.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        WebElement alertBtn1 = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alertBtn1.click();

        Thread.sleep(5000);

        // Create object of alert
        Alert alert = driver.switchTo().alert();

        // Following functions available in alert object
        System.out.println(alert.getText());
        alert.accept();
        //alert.dismiss();
        //alert.sendKeys("text");

    }
}
