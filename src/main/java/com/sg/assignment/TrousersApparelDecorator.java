package com.sg.assignment;

public class TrousersApparelDecorator extends BaseApparelDecorator {

	public TrousersApparelDecorator(BaseApparel apparel){
		super(apparel);
	}
	
	public int getDiscountPercentage(){
		return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(ApparelType.TROUSERS.getDisplayValue()));
	}
}
