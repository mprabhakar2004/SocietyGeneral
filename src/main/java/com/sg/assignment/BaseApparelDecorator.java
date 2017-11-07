package com.sg.assignment;


public abstract class BaseApparelDecorator extends BaseApparel {

    private BaseApparel apparel;

    public BaseApparelDecorator() {
    }

    public BaseApparelDecorator(BaseApparel apparel) {
        this.apparel = apparel;
    }

    public int getDiscountPercentage() {
        return apparel.getDiscountPercentage();
    }

    public BaseApparel getApparel() {
        return apparel;
    }

    public void setApparel(BaseApparel apparel) {
        this.apparel = apparel;
    }

}
