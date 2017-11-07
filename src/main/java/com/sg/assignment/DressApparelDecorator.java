package com.sg.assignment;

public class DressApparelDecorator extends BaseApparelDecorator {

    public DressApparelDecorator(BaseApparel apparel) {
        super(apparel);
    }

    public int getDiscountPercentage() {
        return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(ApparelType.DRESS.getDisplayValue()));
    }
}
