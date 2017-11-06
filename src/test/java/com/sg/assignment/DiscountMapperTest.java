package com.sg.assignment;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountMapperTest {
    @BeforeClass
    static public void setUp() throws Exception {
        DiscountMapper.load();
    }

    @Test
    public void testDiscountMapper(){
        assertEquals(DiscountMapper.getDiscount(BrandType.PROVOGUE.getDisplayValue()), 20);
    }

    @Test
    public void testDiscountMapperWithNonExtingKey(){
        assertEquals(DiscountMapper.getDiscount("nonexitingkey"), 0);
    }
}