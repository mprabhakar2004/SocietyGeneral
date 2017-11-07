package com.sg.assignment;

public enum ApparelType {
    SHIRT("Shirts", ShirtApparelDecorator.class),
    TROUSERS("Trousers", TrousersApparelDecorator.class),
    CASUALS("Casuals", CasualsApparelDecorator.class),
    JEANS("Jeans", JeansApparelDecorator.class),
    DRESS("Dresses", DressApparelDecorator.class),
    FOOTWEAR("Footwear", FootwearApparelDecorator.class);

    public String getDisplayValue() {
        return displayValue;
    }

    private String displayValue;

    public Class getClassz() {
        return classz;
    }

    private Class classz;

    ApparelType(String text, Class classz) {
        this.displayValue = text;
        this.classz = classz;
    }

    public String getText() {
        return this.displayValue;
    }

    public static ApparelType fromString(String text) {
        for (ApparelType b : ApparelType.values()) {
            if (b.displayValue.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    BaseApparel getApparel() {
        BaseApparel baseApprel = null;
        switch (this) {
            case SHIRT:
            case TROUSERS:
            case CASUALS:
            case JEANS:
                baseApprel = new MenClothing();
                break;
            case DRESS:
            case FOOTWEAR:
                baseApprel = new WomenClothing();
                break;
        }
        return baseApprel;
    }
}
