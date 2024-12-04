package com.games.water_sort.model;

public enum Color {

    GREY("GY"),
    BLUE("BL"),
    VIOLET("V "),
    YELLOW("Y "),
    LIGHT_GREEN("LG"),
    RED("R "),
    GREEN("G "),
    DARK_GREEN("DG"),
    DARK_BLUE("DB"),
    ORANGE("O "),
    BROWN("BR"),
    PINK("P ");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}



