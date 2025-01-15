package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {
    @BeforeAll
    static void configurations() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";


    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@test.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9001234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("2022");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(Condition.text("1")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("Russia,123456,Moscow,ul.Lesnaya,d.5,kv.176");
        $("#state").click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Merrut")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(Condition.text("Nikita Ivanov"),
                (Condition.text("ivanov@test.ru")),
                (Condition.text("Male")),
                (Condition.text("1 August,2022")),
                (Condition.text("9001234567")),
                (Condition.text("English")),
                (Condition.text("Sports")),
                (Condition.text("1.jpg")),
                (Condition.text("Russia,123456,Moscow,ul.Lesnaya,d.5,kv.176")),
                (Condition.text("Uttar Pradesh Merrut")));
        $(".modal-footer").$(byText("Close")).click();
    }

}
