package com.gmail.kd20121989;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.gmail.kd20121989.domain.MenuItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebTest {

    @ValueSource(strings = {
            "Selenide",
            "JUnit"
    })

    @DisplayName("Searching in Yandex by word \"Selenide\"")
    @ParameterizedTest(name = "Searching in Yandex by word {0}")
    void yaSearch(String testData) {
        //Preconditions:
        Selenide.open("https://ya.ru");

        //Steps:
        $("input#text").setValue(testData);
        $("button[type=submit]").click();

        //Expected:
        $$(".serp-item")
                .find(Condition.text(testData))
                .shouldBe(visible);
    }

    @CsvSource(value = {
            "Selenide | is an open source library for test",
            "JUnit | Support JUnit"
    },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Searching in Yandex by word {0}, Expected result is : {1}")
    void yaSearchComplexTest(String testData, String expectedResult) {
        //Preconditions:
        Selenide.open("https://ya.ru");

        //Steps:
        $("input#text").setValue(testData);
        $("button[type=submit]").click();

        //Expected:
        $$(".serp-item")
                .find(Condition.text(expectedResult))
                .shouldBe(visible);
    }

    static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("first string ", List.of(42, 13)),
                Arguments.of("second string ", List.of(1, 2))
        );
    }

    @MethodSource
    @ParameterizedTest
    void methodSourceExampleTest(String first, List<Integer> second) {
        System.out.println(first + second);
    }

    @EnumSource(MenuItem.class)
    @ParameterizedTest(name = "Searching in Yandex by word {0}")
    void yandexSearchMenuTest(String testData) {
        //Preconditions:
        Selenide.open("https://ya.ru");

        //Steps:
        $("input#text").setValue("Allure Test Ops");
        $("button[type=submit]").click();

        //Expected:
        $$(".navigation__item")
                .find(Condition.text(testData))
                .shouldBe(visible);

    }

    @AfterEach
    void close() {

    }
}
