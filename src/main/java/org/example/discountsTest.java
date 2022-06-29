package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class discountsTest extends SignUpTest{

    @Test
    public void checkDiscountFromTwentyToFortyNine() {
        WebElement zipCodeField = driver.findElement(By.name("zip_code"));
        zipCodeField.sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nikita");
        driver.findElement(By.name("last_name")).sendKeys("Shults");
        driver.findElement(By.name("email")).sendKeys("genabukin@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345678");
        driver.findElement(By.name("password2")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String userLogin = driver.findElement(By.xpath("//td[contains(text(),'Email')]/following::b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(userLogin);
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("1111");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        WebElement firstBookOnPage = driver.findElement(By.xpath("(//tr[@align='center']//td//a)[2]"));
        firstBookOnPage.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//table[@align='center']//p//a"));
        addToCartButton.click();
        WebElement goToCartButton = driver.findElement(By.xpath("//td[@align='right']//a"));
        goToCartButton.click();
        WebElement quantityField = driver.findElement(By.xpath("//tr[2]//td[3]//input"));
        quantityField.clear();
        quantityField.sendKeys("49");
        WebElement updateButton = driver.findElement(By.xpath("//input[@value='Update']"));
        updateButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//tr[2]//td[5]//p//b")).getText(), "2");
    }

    @Test
    public void checkDiscountFromFiftyToFortyNinetyNine() {
        WebElement zipCodeField = driver.findElement(By.name("zip_code"));
        zipCodeField.sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Nikita");
        driver.findElement(By.name("last_name")).sendKeys("Shults");
        driver.findElement(By.name("email")).sendKeys("genabukin@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345678");
        driver.findElement(By.name("password2")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String userLogin = driver.findElement(By.xpath("//td[contains(text(),'Email')]/following::b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(userLogin);
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("1111");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        WebElement firstBookOnPage = driver.findElement(By.xpath("(//tr[@align='center']//td//a)[2]"));
        firstBookOnPage.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//table[@align='center']//p//a"));
        addToCartButton.click();
        WebElement goToCartButton = driver.findElement(By.xpath("//td[@align='right']//a"));
        goToCartButton.click();
        WebElement quantityField = driver.findElement(By.xpath("//tr[2]//td[3]//input"));
        quantityField.clear();
        quantityField.sendKeys("50");
        WebElement updateButton = driver.findElement(By.xpath("//input[@value='Update']"));
        updateButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//tr[2]//td[5]//p//b")).getText(), "3");
    }



}
