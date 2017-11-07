package com.sg.assignment;

public class MenClothing extends BaseApparel {

    @Override
    public int getDiscountPercentage() {
        return DiscountMapper.getDiscount(BaseApparelType.MEN_CLOTHING.getDisplayValue());
    }
}
