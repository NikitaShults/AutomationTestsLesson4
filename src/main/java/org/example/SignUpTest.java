package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void zipCodeShouldBeValid() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(" https://www.sharelane.com/cgi-bin/register.py ");
     WebElement zipCodeField = driver.findElement(By.name("zip_code"));
     zipCodeField.sendKeys("12345");
     driver.findElement(By.cssSelector("input[value='Continue']")).click();
     WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
     Assert.assertTrue(registerButton.isDisplayed());


    }

}