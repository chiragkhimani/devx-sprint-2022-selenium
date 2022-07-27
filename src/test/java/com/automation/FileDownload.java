package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class FileDownload {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        String downloadFilepath = "C:\\Users\\khima\\3D Objects";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://the-internet.herokuapp.com/download");

        WebElement fileDownload = driver.findElement(By.xpath("//a[text()='file.txt']"));
        fileDownload.click();
    }
}
