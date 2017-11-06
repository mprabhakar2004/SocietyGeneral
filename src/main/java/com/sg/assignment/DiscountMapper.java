package com.sg.assignment;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DiscountMapper {

    static Properties properties;

    public static void load() throws IOException {
        ClassLoader classLoader = DiscountMapper.class.getClassLoader();
        FileReader reader=new FileReader(classLoader.getResource("discountmapper.properties").getFile());
        properties=new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int getDiscount(String key){
        int discount = 0;
        if (properties.containsKey(key))
            discount = Integer.parseInt(properties.getProperty(key));
        return discount;
    }
}