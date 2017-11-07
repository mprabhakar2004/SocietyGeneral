package com.sg.assignment;

public class ShirtApparelDecorator extends BaseApparelDecorator {

    public ShirtApparelDecorator(BaseApparel apparel) {
        super(apparel);
    }

    public int getDiscountPercentage() {
        return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(ApparelType.SHIRT.getDisplayValue()));
    }

}
