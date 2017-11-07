package com.sg.assignment;

public class AdidasBrandDecorator extends BaseApparelDecorator {

    public AdidasBrandDecorator(BaseApparel apparel) {
        super(apparel);
    }

    public int getDiscountPercentage() {
        return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(BrandType.ADIDAS.getDisplayValue()));
    }
}
