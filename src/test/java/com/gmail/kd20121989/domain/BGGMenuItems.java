package com.gmail.kd20121989.domain;

public enum BGGMenuItems {
    BR("Browse"), FOR("Forums"), GEEKL("GeekLists"), SHOP("Shopping"),
    COM("Community"), HELP("Help");
    public final String engName;

    BGGMenuItems (String engName) {
        this.engName = engName;
    }
}
