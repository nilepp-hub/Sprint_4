import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.page.FAQPage;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FaqTest {
    private WebDriver driver;
    private int questionIndex;
    private String expectedText;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."}
        });
    }
    public FaqTest(int questionIndex, String expectedText) {
        this.questionIndex = questionIndex;
        this.expectedText = expectedText;
    }

    @Test
    public void test() {
        driver = new ChromeDriver();
        // Открываем сервис
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Создаем экземпляр класса Page.FAQPage
        FAQPage objFaqPage = new FAQPage(driver);
        objFaqPage.quqClick();
        if (driver.findElement(By.id("accordion__heading-" + questionIndex)).isDisplayed()) {
            objFaqPage.openQuestion(questionIndex);
            String actualText = objFaqPage.getQuestionAnswer(questionIndex);
            assertEquals("Текст ответа на вопрос: " + (questionIndex + 1) + " ошибка", expectedText, actualText);
            assertTrue("Ответ на вопрос " + (questionIndex + 1) + " не отображается",
                    driver.findElement(By.id("accordion__panel-" + questionIndex)).isDisplayed());
        } else {
            fail("Вопрос: " + (questionIndex + 1) + " не отображается");
        }
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
