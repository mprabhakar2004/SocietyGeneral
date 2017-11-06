package com.sg.assignment;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
            String[] stringArr = br.readLine().split(",");
            result[i] = calculateTotalDiscountedPriceForItems(stringArr);
        }

        System.out.println("=================================Output===========================");
        for (int i = 0; i < testInput; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * Helper method to to calculate final amount
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
     * @throws IOException
     */
    private static void createInventory() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inventoryCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < inventoryCount; i++) {
            String inputStr = br.readLine();
            String[] inputStrArr = inputStr.split(",");
            productMap.put(inputStrArr[0], new Product(Long.parseLong(inputStrArr[0]), inputStrArr[1].trim(),
                    inputStrArr[2].trim(), Double.parseDouble(inputStrArr[3])));
        }
    }
}
