package com.sg.assignment;

import java.lang.reflect.InvocationTargetException;

public class ApparelFactory {

    public static BaseApparel getBaseApparel(String type) {
        return ApparelType.fromString(type).getApparel();
    }

    public static BaseApparel applyApparelType(BaseApparel apparel, String apparelType){
        try {
            return (BaseApparel) ApparelType.fromString(apparelType).getClassz().getDeclaredConstructor(BaseApparel.class).newInstance(apparel);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BaseApparel applyBrand(BaseApparel apparel, String brandType){
        try {
            return (BaseApparel) BrandType.fromString(brandType).getClassz().getDeclaredConstructor(BaseApparel.class).newInstance(apparel);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
