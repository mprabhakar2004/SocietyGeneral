package com.sg.assignment;

public class WranglerBrandDecorator extends BaseApparelDecorator {

    public WranglerBrandDecorator(BaseApparel apparel) {
        super(apparel);
    }

    public int getDiscountPercentage() {
        return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(BrandType.WRANGLER.getDisplayValue()));
    }
}
