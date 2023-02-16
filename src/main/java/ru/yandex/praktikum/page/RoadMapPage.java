package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RoadMapPage {
    private final By DOWN_ZAKAZ_BUTTON = By.cssSelector("div.Home_FinishButton__1_cWm > button");

    private WebDriver driver;
    public RoadMapPage(WebDriver driver) {
        this.driver = driver;
    }
    public void downZakazClick() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(DOWN_ZAKAZ_BUTTON));
        driver.findElement(DOWN_ZAKAZ_BUTTON).click();
    }
}
