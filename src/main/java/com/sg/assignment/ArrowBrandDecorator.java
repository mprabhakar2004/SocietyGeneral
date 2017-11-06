package com.sg.assignment;

public class ArrowBrandDecorator extends BaseApparelDecorator {

	public ArrowBrandDecorator(BaseApparel apparel){
		super(apparel);
	}
	
	public int getDiscountPercentage(){
		return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(BrandType.ARROW.getDisplayValue()));
	}
	

}
