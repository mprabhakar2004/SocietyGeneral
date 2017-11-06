package com.sg.assignment;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApparelFactoryTest {
    @BeforeClass
    static public void setUp() throws Exception {
        DiscountMapper.load();
    }

    @Test
    public void testCreateBaseApparel(){
        assertEquals(ApparelFactory.getBaseApparel("shirts").getClass(), MenClothing.class);
        assertEquals(ApparelFactory.getBaseApparel("footwear").getClass(), WomenClothing.class);
    }

    @Test
    public void testApplyApparelType(){
        BaseApparel apparel = ApparelFactory.getBaseApparel("shirts");
        apparel = ApparelFactory.applyApparelType(apparel,"shirts");
        assertEquals(apparel.getClass(), ShirtApparelDecorator.class);
    }
    @Test
    public void testApplBrandType(){
        BaseApparel apparel = ApparelFactory.getBaseApparel("shirts");
        apparel = ApparelFactory.applyBrand(apparel,"Arrow");
        assertEquals(apparel.getClass(), ArrowBrandDecorator.class);
    }

    @Test
    public void testCalulateDiscountedPrice(){
        Product product=new Product(1,"Arrow","Shirts",800);
        BaseApparel apparel = ApparelFactory.getBaseApparel(product.getType());
        apparel = ApparelFactory.applyApparelType(apparel,product.getType());
        apparel = ApparelFactory.applyBrand(apparel,product.getBrand());
        assertEquals(apparel.calculateDiscountedPrice(product.getPrice()), 640,0.001);
    }

}