package com.gmail.kd20121989.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BGGSearchResultsPage {
    String pageEndpoint = "/geeksearch.php";

    SelenideElement firstFoundItem = $("table.collection_table #results_objectname1 a");

    public BGGSearchResultsPage openPage() {
        open(pageEndpoint);

        return this;
    }

    public BGGSearchResultsPage checkFirstFoundItem(String item) {
        firstFoundItem.shouldHave(text(item));

        return this;
    }

    public BGGSearchResultsPage checkFirstFoundItemNameAndYear(String itemName, int itemYear) {
        firstFoundItem.shouldHave(text(itemName))
                .sibling(0)
                .shouldHave(text(Integer.toString(itemYear)));;

        return this;
    }


}
