package com.gmail.kd20121989.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.gmail.kd20121989.domain.BGGMenuItems;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BGGMainPage {
    String pageEndpoint = "";

    SelenideElement mainSearchBox = $("gg-header-search");
    SelenideElement mainSearchInput = $("gg-header-search input");
    SelenideElement browseDropdownMenuButton = $("nav.container-fluid")
            .$$("ul").first().$$("button.dropdown-toggle")
            .findBy(exactTextCaseSensitive(BGGMenuItems.BR.engName));
    ElementsCollection getBrowseDropdownMenuListItems = $("nav.container-fluid").$$("ul").first()
            .$$("a");

    public BGGMainPage openPage() {
        open(pageEndpoint);

        return this;
    }

    public BGGMainPage searchFieldMainClick() {
        mainSearchBox.click();

        return this;
    }

    public BGGMainPage searchBoxMainFind(String whatToSearch) {
        mainSearchInput.setValue(whatToSearch).pressEnter();

        return this;
    }
    public BGGMainPage openBrowseDropdownMenu() {
        browseDropdownMenuButton.click();

        return this;
    }

    public BGGMainPage findBrowseDropdownMenuItem(String exactTextCaseSensitive) {
        getBrowseDropdownMenuListItems.findBy(exactTextCaseSensitive(exactTextCaseSensitive))
                .shouldHave(exactTextCaseSensitive(exactTextCaseSensitive));

        return this;
    }

    public BGGMainPage clickBrowseDropdownMenuItem(String exactTextCaseSensitive) {
        getBrowseDropdownMenuListItems.findBy(exactTextCaseSensitive(exactTextCaseSensitive))
                .shouldHave(exactTextCaseSensitive(exactTextCaseSensitive)).click();

        return this;
    }
}
