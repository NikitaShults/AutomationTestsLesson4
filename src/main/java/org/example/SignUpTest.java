package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {

    WebDriver driver;
    @BeforeClass
    public void setPathToWebDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    }
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void zipCodeShouldBeValid() {
        WebElement zipCodeField = driver.findElement(By.name("zip_code"));
        zipCodeField.sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed());
    }
    @Test
    public void successfulRegistration() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Nikita");
        driver.findElement(By.name("last_name")).sendKeys("Shults");
        driver.findElement(By.name("email")).sendKeys("genabukin@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345678");
        driver.findElement(By.name("password2")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        Assert.assertTrue(driver.findElement(By.className("confirmation_message")).isDisplayed());
    }
    @Test
    public void incorrectEmail(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Nikita");
        driver.findElement(By.name("last_name")).sendKeys("Shults");
        driver.findElement(By.name("email")).sendKeys("genabukin");
        driver.findElement(By.name("password1")).sendKeys("12345678");
        driver.findElement(By.name("password2")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        Assert.assertEquals(driver.findElement(By.className("error_message")).getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }
    @Test
    public void incorrectZipCode(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.className("error_message")).getText(),"Oops, error on page. ZIP code should have 5 digits");

    }
    @Test
    public void registrationWithoutText(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        Assert.assertEquals(driver.findElement(By.className("error_message")).getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used");

    }
    @AfterMethod(alwaysRun = true)
    public void closeThis(){driver.quit();}

}
