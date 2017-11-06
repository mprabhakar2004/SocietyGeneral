package com.sg.assignment;

public class FootwearApparelDecorator extends BaseApparelDecorator {

	public FootwearApparelDecorator(BaseApparel apparel){
		super(apparel);
	}
	
	public int getDiscountPercentage(){
		return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(ApparelType.FOOTWEAR.getDisplayValue()));
	}
}
