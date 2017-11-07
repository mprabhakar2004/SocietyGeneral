package com.sg.assignment;

public enum BrandType {
    ARROW("Arrow", ArrowBrandDecorator.class),
    VERO_MODA("Vero Moda", VedoModaBrandDecorator.class),
    PROVOGUE("Provogue", ProvogueBrandDecorator.class),
    WRANGLER("Wrangler", WranglerBrandDecorator.class),
    UCB("UCB", UCBBrandDecorator.class),
    ADIDAS("Adidas", AdidasBrandDecorator.class);

    private String displayValue;
    private Class classz;

    BrandType(String text, Class classz) {
        this.displayValue = text;
        this.classz = classz;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public Class getClassz() {
        return classz;
    }

    public static BrandType fromString(String text) {
        for (BrandType b : BrandType.values()) {
            if (b.displayValue.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }


}

