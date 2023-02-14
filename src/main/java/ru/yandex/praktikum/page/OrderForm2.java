package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderForm2 {
    private final By KOGDA = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");
    private final By SROK = By.className("Dropdown-placeholder");
    private final By DAY = By.xpath("//div[@class=\"Dropdown-option\"][text()=\"двое суток\"]");
    private final By COLOR = By.id("black");
    private final By KOMENT = By.xpath("//input[@placeholder=\"Комментарий для курьера\"]");
    private final By NAZAD = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i\"][text()=\"Назад\"]");
    private final By ZAKAZ = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"][text()=\"Заказать\"]");
    private final By DA = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"][text()=\"Да\"]");

    private WebDriver driver;
    public OrderForm2(WebDriver driver) {
        this.driver = driver;
    }
    public void vvodKogda() {
        driver.findElement(KOGDA).sendKeys("16.02.23");
        driver.findElement(KOGDA).sendKeys(Keys.ENTER);
    }
    public void vvodSrok() {
        driver.findElement(SROK).click();
        new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.findElement(DAY).click();
    }
    public void vvodColor() {
        driver.findElement(COLOR).click();
    }
    public void vvodKoment() {
        driver.findElement(KOMENT).sendKeys("КОНЯ! HORSE");
    }
    public void clickNazad() {
        driver.findElement(NAZAD).click();
    }
    public void clickZakaz() {
        driver.findElement(ZAKAZ).click();
    }
    public void clickDa() {
        driver.findElement(DA).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Text__2broi")));
        String orderNumber = driver.findElement(By.className("Order_Text__2broi")).getText().split(" ")[2];
        if (orderNumber.isEmpty()) {
            throw new AssertionError("Ошибка: номер заказа пуст");
        } else {
            System.out.println("Оформлен закз: " + orderNumber);
        }
    }
    //шаг заполнения формы для позитивного прохода через кнопку заказа в шапке.
    public void upZakazForm2Pozitiv() {
        vvodKogda();
        vvodSrok();
        vvodColor();
        vvodKoment();
        clickNazad();
    }
    public void upZakazForm2PozitivZakazDa() {
        clickZakaz();
        clickDa();
    }
}
