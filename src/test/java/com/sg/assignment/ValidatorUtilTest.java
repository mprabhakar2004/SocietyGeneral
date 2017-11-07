package com.sg.assignment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorUtilTest {
    @Test
    public void testLong(){
        assertTrue(ValidatorUtil.isValidInput("Id","1", Long.class));
    }

    @Test
    public void testDouble(){
        assertTrue(ValidatorUtil.isValidInput("Price","2.20", Double.class));
    }

    @Test
    public void testInvalidInput(){
        assertFalse(ValidatorUtil.isValidInput("Price","invalidInput", Double.class));
    }
    @Test
    public void testBrandType(){
        assertTrue(ValidatorUtil.isValidInput("BrandType","Arrow", BrandType.class));
    }
    @Test
    public void testApparelType(){
        assertTrue(ValidatorUtil.isValidInput("ApparelType","Shirts", ApparelType.class));
    }
}
