import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.page.*;

public class ZakazTest {
    private WebDriver driver;

    @Test
    public void testUpZakaz() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        // Открываем сервис
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Создаем экземпляр класса HeaderPage
        HeaderPage objHeaderPage = new HeaderPage(driver);
        // находим и жмем кнопку "Заказать" в шапке
        objHeaderPage.upZakazClick();
        // Создаем экземпляр класса OrderFormPage
        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        // Заполняе форму валидными значениями идем на следующую
        objOrderFormPage.upZakazFormPozitiv("Борис", "Борисов", "Борисова 1а", "+79855255115", "цветной");
        // Создаем экземпляр класса OrderForm2
        OrderForm2 objOrderForm2 = new OrderForm2(driver);
        // Заполняем форму 2 валидными значениями и возвращаемся назад, значения на месте
        objOrderForm2.upZakazForm2Pozitiv("16.02.2023", "Огня мне! Огня!");
        // значения на месте и переход на форму 2 без проблем
        objOrderFormPage.clickDalee();
        // оформляем заказ проверяем получение номера заказа
        objOrderForm2.upZakazForm2PozitivZakazDa();
    }

    @Test
    public void testDownZakaz() {
        driver = new ChromeDriver();
        // Открываем сервис
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Создаем экземпляр класса Page.FAQPage
        FAQPage objFaqPage = new FAQPage(driver);
        // соглашаемся на куки
        objFaqPage.quqClick();
        // Создаем экземпляр класса RoadMapPage
        RoadMapPage objRoadMapPage = new RoadMapPage(driver);
        // находим и жмем кнопку "Заказать" в блоке дорожной карты
        objRoadMapPage.downZakazClick();
        // Создаем экземпляр класса OrderFormPage
        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        // Заполняе форму не валидными значениями, ошибки, к форме 2 не переходим
        objOrderFormPage.downZakazFormNegativ("Anna", "Annovna", "Annovnikov 1", "89", "черкизовская");
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
