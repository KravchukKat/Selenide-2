import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class GitHubDragDropTests {
    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void GitHubPage() {
        // Открыть страницу репозитория Selenide
        open("https://github.com/selenide/selenide");

        // выберите: Меню -> Solutions -> Enterprize
        $(".HeaderMenu-nav").$$("ul.d-lg-flex list-style-none li").get(1).hover()
                .$(byText("Enterprises").click();
        //Убедитесь, что загрузилась нужная страница
        $(byTagAndText("h1","The AI-powered /n developer platform")).shouldBe(visible);

    }
    @Test
    void DragDropActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset("#column-b").release().perform();
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
    @Test
    void DragDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop($("#column-b"));
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }

}
