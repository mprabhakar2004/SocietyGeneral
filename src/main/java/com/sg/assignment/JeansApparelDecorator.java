package com.sg.assignment;

public class JeansApparelDecorator extends BaseApparelDecorator {

    public JeansApparelDecorator(BaseApparel apparel) {
        super(apparel);
    }

    public int getDiscountPercentage() {
        return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(ApparelType.JEANS.getDisplayValue()));
    }
}
