package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverMouse {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement usernameInput = driver.findElement(By.id("txtUsername"));
        WebElement passInput = driver.findElement(By.id("txtPassword"));
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));

        usernameInput.sendKeys("Admin");
        passInput.sendKeys("admin123");
        loginBtn.click();


        WebElement adminLink = driver.findElement(By.id("menu_admin_viewAdminModule"));
        WebElement userManagementLink = driver.findElement(By.id("menu_admin_UserManagement"));
        WebElement usersLink = driver.findElement(By.id("menu_admin_viewSystemUsers"));

        Actions action = new Actions(driver);
        action.moveToElement(adminLink).moveToElement(userManagementLink).click(usersLink).build().perform();
    }
}
