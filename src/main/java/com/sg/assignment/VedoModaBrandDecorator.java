package com.sg.assignment;

public class VedoModaBrandDecorator extends BaseApparelDecorator {

	public VedoModaBrandDecorator(BaseApparel appare){
		super(appare);
	}
	
	public int getDiscountPercentage(){
		return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(BrandType.VERO_MODA.getDisplayValue()));
	}
	

}
