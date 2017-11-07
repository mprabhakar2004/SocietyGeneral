package com.sg.assignment;

public class ValidatorUtil {
    public static boolean isValidInput(String inputFieldName, String inputValue, Class targetClass) {
        try {
            if (targetClass.equals(Long.class)) {
                Long.parseLong(inputValue);
            } else if (targetClass.equals(Double.class)) {
                Double.parseDouble(inputValue);
            } else if (targetClass.equals(BrandType.class)) {
                if (BrandType.fromString(inputValue) == null) {
                    throw new IllegalArgumentException("Invalid brand type");
                }
            } else if (targetClass.equals(ApparelType.class)) {
                if (ApparelType.fromString(inputValue) == null) {
                    throw new IllegalArgumentException("Invalid Apparel type");
                }
            }
        } catch (Exception ex) {
            System.out.println(String.format("Invalid input value: %s for field: %s", inputValue, inputFieldName));
            return false;
        }

        return true;
    }
}
