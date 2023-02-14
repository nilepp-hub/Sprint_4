package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    //кнопка заказать в шапке
    private final By UP_ZAKAZ_BUTTON = By.className("Button_Button__ra12g");

    private WebDriver driver;
    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void upZakazClick() {
        driver.findElement(UP_ZAKAZ_BUTTON).click();
    }
}
