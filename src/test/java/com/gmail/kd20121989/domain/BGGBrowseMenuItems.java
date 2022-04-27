package com.gmail.kd20121989.domain;

public enum BGGBrowseMenuItems {
    ALL("All Boardgames"), CATEGORY("Categories"), ARTIST("Artists"), PUBL("Publishers"),
    HONOR("Honors"), GOCARD("Gone Cardboard"), REC("Recent Additions"), PREV("Previews"),
    FAM("Families"), MECH("Mechanics"), DESIGN("Designers"), ACC("Accessories"),
    RAND("Random Game"), PCAST("Podcasts"), WIKI("Wiki");
    public final String engName;

    BGGBrowseMenuItems(String engName) {
        this.engName = engName;
    }
}
