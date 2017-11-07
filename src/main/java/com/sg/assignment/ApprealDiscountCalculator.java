package com.sg.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ApprealDiscountCalculator {
    static Map<String, Product> productMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // Load discount map using properties file
        DiscountMapper.load();
        // Create inventory based on the given input
        createInventory();

        // Read selected items
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testInput = Integer.parseInt(br.readLine());

        double[] result = new double[testInput];
        for (int i = 0; i < testInput; i++) {
            int j = 0;
            String[] stringArr = br.readLine().split(",");
            if (stringArr.length > 0) {
                for (; j < stringArr.length; j++) {
                    if (!ValidatorUtil.isValidInput("Id", stringArr[j], Long.class) || !validItemSelection(stringArr[j])) {
                        i--;
                        break;
                    }
                }
                if (j != stringArr.length) {
                    continue;
                }
            } else {
                i--;
            }
            result[i] = calculateTotalDiscountedPriceForItems(stringArr);
        }

        System.out.println("=================================Output===========================");
        for (int i = 0; i < testInput; i++) {
            System.out.println(result[i]);
        }
    }

    private static boolean validItemSelection(String input) {

        if (ValidatorUtil.isValidInput("Id", input, Long.class)) {
            if (!productMap.containsKey(input)) {
                System.out.println("Invalid product Id :" + input);
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to to calculate final amount
     *
     * @param productIds
     * @return
     */
    private static double calculateTotalDiscountedPriceForItems(String[] productIds) {

        double totalAmount = 0;
        for (String productId : productIds) {
            Product p = productMap.get(productId);
            BaseApparel a = ApparelFactory.getBaseApparel(p.getType());
            a = ApparelFactory.applyApparelType(a, p.getType());
            a = ApparelFactory.applyBrand(a, p.getBrand());
            totalAmount += a.calculateDiscountedPrice(p.getPrice());
        }
        return totalAmount;
    }

    /**
     * Helper method to create inventory
     *
     * @throws IOException
     */
    private static void createInventory() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inventoryCount = 0;
        while (inventoryCount == 0) {
            try {
                inventoryCount = Integer.parseInt(br.readLine());
            } catch (Exception ex) {
                System.out.println("Please enter valid inventory count");
            }
        }
        for (int i = 0; i < inventoryCount; i++) {
            String inputStr = br.readLine();
            if (inputStr.length() == 0) {
                i--;
            } else {
                String[] inputStrArr = inputStr.split(",");
                if (validInput(inputStrArr)) {
                    productMap.put(inputStrArr[0], new Product(Long.parseLong(inputStrArr[0]), inputStrArr[1].trim(),
                            inputStrArr[2].trim(), Double.parseDouble(inputStrArr[3])));
                } else {
                    i--;
                }
            }
        }
    }

    private static boolean validInput(String[] inputStrArr) {
        return inputStrArr.length == 4 && ValidatorUtil.isValidInput("Product Id", inputStrArr[0].trim(), Long.class) &&
                ValidatorUtil.isValidInput("Brand Type", inputStrArr[1].trim(), BrandType.class) &&
                ValidatorUtil.isValidInput("Apparel Type", inputStrArr[2].trim(), ApparelType.class) &&
                ValidatorUtil.isValidInput("Price", inputStrArr[3].trim(), Double.class);
    }
}
