package com.sg.assignment;

public class ProvogueBrandDecorator extends BaseApparelDecorator {

	public ProvogueBrandDecorator(BaseApparel apparel){
		super(apparel);
	}
	
	public int getDiscountPercentage(){
		return Math.max(getApparel().getDiscountPercentage(), DiscountMapper.getDiscount(BrandType.PROVOGUE.getDisplayValue()));
	}
}
