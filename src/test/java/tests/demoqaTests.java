package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class demoqaTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void succesfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Lady");
        $("[id=lastName]").setValue("Gaga");
        $("[id=userEmail]").setValue("sinterma@gmail.com");
        $("[for='gender-radio-2']").click();
        $("[id=userNumber]").setValue("9315418786");

        //birthday
        $("[id=dateOfBirthInput]").click();
        $(" .react-datepicker__month-select").selectOption("January");
        $(" .react-datepicker__year-select").selectOption("1991");
        $("[aria-label='Choose Thursday, January 3rd, 1991']").click();

        //subjects
        $("[id=subjectsInput]").setValue("ph").pressEnter();

        //hobbies
        $("[for='hobbies-checkbox-3']").click();

        //Address
        $("[placeholder='Current Address']").setValue("New York");

        //State and City
        $("[id=react-select-3-input]").setValue("n").pressEnter();
        $("[id=react-select-4-input]").setValue("Del").pressEnter();

        $("[id=submit]").click();

        //check
        $(".table-responsive").shouldHave( text("Lady"),
                text("Gaga"),
                text("sinterma@gmail.com"),
                text("9315418786"),
                text("03 January,1991"),
                text("Physics"),
                text("New York"),
                text("NCR"),
                text("Delhi"));

    }

}