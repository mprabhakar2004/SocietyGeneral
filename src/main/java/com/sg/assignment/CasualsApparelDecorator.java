package com.sg.assignment;

public class CasualsApparelDecorator extends BaseApparelDecorator {

    public CasualsApparelDecorator(BaseApparel apparel) {
        super(apparel);
    }

    public int getDiscountPercentage() {
        return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(ApparelType.CASUALS.getDisplayValue()));
    }
}
