package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static final String SEARCHFIELD = "q";                       // [1]

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX); // [2]
        driver.get("https://www.google.com");                                 // [3]

        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click(); // [4]

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));      // [5]
        searchField.sendKeys("laptop");                                      // [6]
        searchField.submit();                                                 // [7]
    }

}
