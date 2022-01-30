package ru.zavrichko.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.zavrichko.pages.RegistrationPage;

public class RegistrationFormWithFakerTest {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void RegistrationTest() {
        // Open website
        registrationPage.openPage();

        // Find Element and Set value
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeGender()
                .typePhone("1234567890")
                .typeDateOfBirth()
                .calendarComponent.setDate();

        registrationPage.typeSubject("Eng")
                .typeCheckboxSports()
                .typeCheckboxReading()
                .typeCheckboxMusic()
                .uploadFile("photo.jpg")
                .typeAddress("Moscow, Manoilov Street, 64")
                .typeState("NCR")
                .typeCity("Gurgaon")
                .typeSubmitButton();

        // Assertion
        registrationPage.checkVisibleTable();

        registrationPage
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "1234567890")
                .checkResultsValue("Date of Birth", "15 May,2014")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Sports, Reading")
                .checkResultsValue("Picture", "photo.jpg")
                .checkResultsValue("Address", "Moscow, Manoilov Street, 64")
                .checkResultsValue("State and City", "NCR Gurgaon");
    }
}
