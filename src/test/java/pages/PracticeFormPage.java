package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement genterWrapper = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement modalResult = $(".modal-content");
    private final SelenideElement submit = $("#submit");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    public PracticeFormPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadFile(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage clickSubmit() {
        submit.click();
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genterWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage modalWithResultNotExist() {
        modalResult.shouldNot(Condition.exist);
        return this;
    }

}

