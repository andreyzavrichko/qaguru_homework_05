package ru.zavrichko.pages;

import com.codeborne.selenide.SelenideElement;
import ru.zavrichko.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            checkboxGender = $(".custom-control-label"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            checkboxSports = $x("//label[contains(text(),'Sports')]"),
            checkboxReading = $x("//label[contains(text(),'Reading')]"),
            checkboxMusic = $x("//label[contains(text(),'Music')]"),
            uploadInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            visibleTable = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");


    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage typeGender() {
        checkboxGender.click();

        return this;
    }

    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage typeDateOfBirth() {
        dateOfBirthInput.click();

        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage typeCheckboxSports() {
        checkboxSports.click();

        return this;
    }

    public RegistrationPage typeCheckboxReading() {
        checkboxReading.click();

        return this;
    }

    public RegistrationPage typeCheckboxMusic() {
        checkboxMusic.click();

        return this;
    }

    public RegistrationPage uploadFile(String fileName) {
        uploadInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage typeState(String value) {
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage typeCity(String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage typeSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {

        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));


        return this;
    }

    public RegistrationPage checkVisibleTable() {
        visibleTable.shouldBe(visible);

        return this;
    }
}
