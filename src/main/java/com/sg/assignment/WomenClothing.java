package com.sg.assignment;

public class WomenClothing extends BaseApparel {

    @Override
    public int getDiscountPercentage() {
        return DiscountMapper.getDiscount(BaseApparelType.WOMEN_CLOTHING.getDisplayValue());
    }

}
