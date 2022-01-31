package ru.zavrichko.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    public void setDate(){
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2014");
        $x("//div[contains(text(),'15')]").click();

        System.out.println("");
    }
}
