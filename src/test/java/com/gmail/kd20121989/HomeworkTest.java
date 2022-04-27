package com.gmail.kd20121989;

import com.codeborne.selenide.*;
import com.gmail.kd20121989.Pages.BGGMainPage;
import com.gmail.kd20121989.Pages.BGGSearchResultsPage;
import com.gmail.kd20121989.domain.BGGBrowseMenuItems;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("Homework test for boardgamegeek.com")
public class HomeworkTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://boardgamegeek.com/";
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = {
            "Pathfinder",
            "Gloomhaven"
    })

    @ParameterizedTest(name = "Searching in BGG by word {0}")
    void bggSearchTest(String testData) {
        Configuration.holdBrowserOpen = false;
        BGGMainPage bggMainPage = new BGGMainPage();
        BGGSearchResultsPage bggSearchResultsPage = new BGGSearchResultsPage();
        //Preconditions:
        bggMainPage.openPage()
        //Steps:
        .searchFieldMainClick()
                .searchBoxMainFind(testData);
        //Expected:
//        sleep(5000);
        bggSearchResultsPage.checkFirstFoundItem(testData);
    }


    @CsvSource(value = {
            "Pathfinder core | Pathfinder Adventure Card Game: Core Set | 2019",
            "Gloomhaven | Gloomhaven | 2017"
    },
            delimiter = '|'
    )

    @ParameterizedTest(name = "Searching in BGG by word {0}, expected result is {1} {2})")
    void bggComplexSearchTest(String testData, String expectedResult, int expectedYear) {
        Configuration.holdBrowserOpen = false;
        BGGMainPage bggMainPage = new BGGMainPage();
        BGGSearchResultsPage bggSearchResultsPage = new BGGSearchResultsPage();
        //Preconditions:
        bggMainPage.openPage()
        //Steps:
                .searchFieldMainClick()
                .searchBoxMainFind(testData);

        //Expected:
        bggSearchResultsPage
                .checkFirstFoundItemNameAndYear(expectedResult, expectedYear);
        //Just wanted to show that int also can be passed from CsvSource
    }

    static Stream<Arguments> bggTooComplexSearchTest() {
        return Stream.of(
                Arguments.of(List.of
                        ("Pathfinder core",
                                "Pathfinder Adventure Card Game: Core Set"),
                        2019
                        ),
                        Arguments.of(List.of("Gloomhaven",
                                "Gloomhaven"),
                                2017
                        )
        );
    }

    @MethodSource
    @ParameterizedTest

    void bggTooComplexSearchTest(List<String> textToSearch, int yearOfRelease) {

        Configuration.holdBrowserOpen = false;
        BGGMainPage bggMainPage = new BGGMainPage();
        BGGSearchResultsPage bggSearchResultsPage = new BGGSearchResultsPage();

        //Preconditions:
        bggMainPage.openPage()
                //Steps:
                .searchFieldMainClick()
                .searchBoxMainFind(textToSearch.get(0));

        //Expected:
        bggSearchResultsPage
                .checkFirstFoundItemNameAndYear(textToSearch.get(1), yearOfRelease);
    }

    @EnumSource(BGGBrowseMenuItems.class)
    @ParameterizedTest(name = "Checking if Browse menu have correct items")
    void bggBrowseMenuItems(BGGBrowseMenuItems testData) {

        Configuration.holdBrowserOpen = false;
        BGGMainPage bggMainPage = new BGGMainPage();
        BGGSearchResultsPage bggSearchResultsPage = new BGGSearchResultsPage();

        //Preconditions:
        bggMainPage.openPage()
        //Steps:
                .openBrowseDropdownMenu()
        //Expected:
                .findBrowseDropdownMenuItem(testData.engName);

        //Should think of some way to compare links from BGGBrowseMenuLinks
//        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
//        Assertions.assertEquals((BGGBrowseMenuLinks))
//                , currentUrl);

    }


    @AfterEach
    void close() {

    }
}
