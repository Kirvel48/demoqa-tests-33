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
    void fillPracticeForm() {
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

        tableResponseComponent.checkResult("""
                Student Name Nikita Ivanov
                Student Email ivanov@test.ru
                Gender Male
                Mobile 9001234567
                Date of Birth 01 August,2022
                Subjects English
                Hobbies Sports
                Picture 1.jpg
                Address Russia,123456,Moscow,ul.Lesnaya,d.5,kv.176
                State and City Uttar Pradesh Merrut
                """);

    }

    @Test
    void fillPracticeMandatoryForm() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Nikita")
                .setLastName("Ivanov")
                .setGender("Male")
                .setUserNumber("9001234567")
                .clickSubmit();
        tableResponseComponent.checkResult(" Nikita Ivanov")
                .checkResult("Male")
                .checkResult("9001234567");
    }

    @Test
    void fillPracticeFormNegative() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Nikita")
                .clickSubmit()
                .modalWithResultNotExist();

    }

}


