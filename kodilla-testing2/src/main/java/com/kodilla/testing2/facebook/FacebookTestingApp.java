package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_COOKIE_BTN = "//button[contains(@data-testid, \"cookie-policy-manage-dialog-accept-button\")]";
    public static final String XPATH_CREATE_BTN = "//a[contains(@data-testid, \"open-registration-form-button\")]";
    public static final String XPATH_INPUT_NAME = "//input[contains(@name, \"firstname\")]";
    public static final String XPATH_INPUT_LASTNAME = "//input[contains(@name, \"lastname\")]";
    public static final String XPATH_BIRTHDAY_SEL = "//select[contains(@id, \"day\")]";
    public static final String XPATH_BIRTH_MONTH_SEL = "//select[contains(@id, \"month\")]";
    public static final String XPATH_BIRTH_YEAR_SEL = "//select[contains(@id, \"year\")]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/.");

        WebElement cookieBtn = driver.findElement(By.xpath(XPATH_COOKIE_BTN));
        cookieBtn.click();
        WebElement createBtn = driver.findElement(By.xpath(XPATH_CREATE_BTN));
        createBtn.click();

        Thread.sleep(1000);

        WebElement inputFirstname = driver.findElement(By.xpath(XPATH_INPUT_NAME));
        inputFirstname.sendKeys("Tom");
        WebElement inputLastname = driver.findElement(By.xpath(XPATH_INPUT_LASTNAME));
        inputLastname.sendKeys("Smith");

        WebElement daySelect = driver.findElement(By.xpath(XPATH_BIRTHDAY_SEL));
        Select selectBoard1 = new Select(daySelect);
        selectBoard1.selectByIndex(1);
        WebElement monthSelect = driver.findElement(By.xpath(XPATH_BIRTH_MONTH_SEL));
        Select selectBoard2 = new Select(monthSelect);
        selectBoard2.selectByIndex(1);
        WebElement yearSelect = driver.findElement(By.xpath(XPATH_BIRTH_YEAR_SEL));
        Select selectBoard3 = new Select(yearSelect);
        selectBoard3.selectByIndex(42);
    }
}