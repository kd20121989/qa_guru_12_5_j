package com.gmail.kd20121989.domain;

public enum BGGBrowseMenuLinks {
    ALL("/browse/boardgame"), CATEGORY("/browse/boardgamecategory"),
    ARTIST("/browse/boardgameartist"), PUBL("/browse/boardgamepublisher"),
    HONOR("/browse/boardgamehonor"), GOCARD("/gonecardboard"),
    REC("/recentadditions"), PREV("/previews"),
    FAM("/browse/boardgamefamily"), MECH("/browse/boardgamemechanic"),
    DESIGN("/browse/boardgamedesigner"), ACC("/browse/boardgameaccessory"),
    RAND("/boardgame/*/*"), PCAST("/browse/boardgamepodcast"), WIKI("/wiki/page/Index");
    public final String link;

    BGGBrowseMenuLinks(String link) {
        this.link = link;
    }
}
