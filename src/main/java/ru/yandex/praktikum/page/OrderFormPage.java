package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderFormPage {
    private final By NAME = By.xpath("//input[@placeholder=\"* Имя\"]");
    private final By FAM = By.xpath("//input[@placeholder=\"* Фамилия\"]");
    private final By ADRES = By.xpath("//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    private final By METRO = By.xpath("//input[@placeholder=\"* Станция метро\"]");
    private final By STATION = By.className("select-search__row");
    private final By PHONE = By.xpath("//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");
    private final By DALEE = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"][text()=\"Далее\"]");

    private WebDriver driver;

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOrderUpZakaz(String name, String fam, String adres, String phone) {
        driver.findElement(NAME).sendKeys(name);
        driver.findElement(FAM).sendKeys(fam);
        driver.findElement(ADRES).sendKeys(adres);
        driver.findElement(PHONE).sendKeys(phone);
    }

    public void fillOrderDownZakaz(String name, String fam, String adres, String phone) {
        driver.findElement(NAME).sendKeys(name);
        driver.findElement(FAM).sendKeys(fam);
        driver.findElement(ADRES).sendKeys(adres);
        driver.findElement(PHONE).sendKeys(phone);
    }

    public void vvodMetro(String station) {
        driver.findElement(METRO).clear();
        driver.findElement(METRO).sendKeys(station);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(STATION));
        driver.findElement(STATION).click();
    }

    public void clickDalee() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(DALEE));
        driver.findElement(DALEE).click();
    }

    // шаг заполнения формы для позитивного прохода, кнопка заказа в шапке.
    public void upZakazFormPozitiv(String name, String fam, String adres, String phone, String station) {
        fillOrderUpZakaz(name, fam, adres, phone);
        vvodMetro(station);
        clickDalee();
    }

    public void downZakazFormNegativ(String name, String fam, String adres, String phone, String station) {
        fillOrderDownZakaz(name, fam, adres, phone);
        vvodMetro(station);
        clickDalee();
    }
}