package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableResponseComponent {
    public TableResponseComponent checkResult(String value) {
        $(".table-responsive")
                .shouldHave(text(value));

        return this;
    }
}
