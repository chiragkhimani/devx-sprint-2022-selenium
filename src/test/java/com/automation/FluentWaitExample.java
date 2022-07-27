package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startBtn = driver.findElement(By.xpath("//div[@id='start']/button"));
        startBtn.click();


        // This Syntax is just to go over, no need to remember
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement text = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='finishhhhhh']/h4"));
            }
        });

        System.out.println(text.getText());
    }
}
