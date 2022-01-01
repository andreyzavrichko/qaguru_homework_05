package ru.zavrichko.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.zavrichko.pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTest {

    RegistrationPage registrationPage = new RegistrationPage();

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
        registrationPage.typeFirstName("Alex")
                .typeLastName("Smirnov")
                .typeEmail("alex.smirnov@gmail.com")
                .typeGender()
                .typePhone("5648798798")
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
                .checkResultsValue("Student Name", "Alex Smirnov")
                .checkResultsValue("Student Email", "alex.smirnov@gmail.com")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "5648798798")
                .checkResultsValue("Date of Birth", "15 May,2014")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Sports, Reading")
                .checkResultsValue("Picture", "photo.jpg")
                .checkResultsValue("Address", "Moscow, Manoilov Street, 64")
                .checkResultsValue("State and City", "NCR Gurgaon");
    }

}
