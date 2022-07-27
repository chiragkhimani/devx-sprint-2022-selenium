package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startBtn = driver.findElement(By.xpath("//div[@id='start']/button"));
        startBtn.click();

        WebElement text = driver.findElement(By.xpath("//div[@id='finish']/h4"));

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(text));

        System.out.println(text.getText());
    }
}
