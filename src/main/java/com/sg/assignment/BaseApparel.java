package com.sg.assignment;

public abstract class BaseApparel {

    protected double calculateDiscountedPrice(double price) {
        return price - ((price * getDiscountPercentage()) / 100);
    }

    public abstract int getDiscountPercentage();

}
