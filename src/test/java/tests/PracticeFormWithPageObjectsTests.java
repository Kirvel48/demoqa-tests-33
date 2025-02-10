package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.CalendarComponent;
import pages.components.TableResponseComponent;


public class PracticeFormWithPageObjectsTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponseComponent tableResponseComponent = new TableResponseComponent();


    @Test
    void fillPracticeFormTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Nikita")
                .setLastName("Ivanov")
                .setUserEmail("ivanov@test.ru")
                .setGender("Male")
                .setUserNumber("9001234567")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadFile("1.jpg")
                .setCurrentAddress("Russia,123456,Moscow,ul.Lesnaya,d.5,kv.176")
                .setState("Uttar Pradesh")
                .setCity("Merrut");
        calendarComponent.setDate("1", "August", "2022");
        practiceFormPage.clickSubmit();

        tableResponseComponent.checkResult("Nikita Ivanov")
                .checkResult("ivanov@test.ru")
                .checkResult("Male")
                .checkResult("001234567")
                .checkResult("01 August,2022")
                .checkResult("English")
                .checkResult("Sports")
                .checkResult("1.jpg")
                .checkResult("Russia,123456,Moscow,ul.Lesnaya,d.5,kv.176")
                .checkResult("Uttar Pradesh Merrut");

    }

    @Test
    void fillPracticeMandatoryFormTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Nikita")
                .setLastName("Ivanov")
                .setGender("Male")
                .setUserNumber("9001234567")
                .clickSubmit();
        tableResponseComponent.checkResult("Nikita Ivanov")
                .checkResult("Male")
                .checkResult("9001234567");
    }

    @Test
    void fillPracticeFormNegativeTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Nikita")
                .clickSubmit()
                .modalWithResultNotExist();

    }

}


