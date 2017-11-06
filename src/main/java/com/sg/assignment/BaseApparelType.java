package com.sg.assignment;

public enum BaseApparelType {
    MEN_CLOTHING("Men's wear"),
    WOMEN_CLOTHING("Women's wear");

    private String displayValue;

    BaseApparelType(String text) {
        this.displayValue = text;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static BaseApparelType fromString(String text) {
        for (BaseApparelType b : BaseApparelType.values()) {
            if (b.displayValue.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
