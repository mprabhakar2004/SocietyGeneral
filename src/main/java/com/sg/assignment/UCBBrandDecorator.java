package com.sg.assignment;

public class UCBBrandDecorator extends BaseApparelDecorator {

    public UCBBrandDecorator(BaseApparel apparel) {
        super(apparel);
    }

    public int getDiscountPercentage() {
        return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(BrandType.UCB.getDisplayValue()));
    }
}
