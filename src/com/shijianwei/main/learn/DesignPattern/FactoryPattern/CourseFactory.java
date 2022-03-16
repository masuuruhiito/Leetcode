package com.shijianwei.main.learn.DesignPattern.FactoryPattern;

/**
 * @author SHI
 * @date 2022/2/28 16:04
 */
public class CourseFactory {
    public ICourse create(Class<? extends ICourse> clazz){
        try {
            if (null != clazz) {
                return clazz.newInstance();
            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null ;
    }


}
