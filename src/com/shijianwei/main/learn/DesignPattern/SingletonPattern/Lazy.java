package com.shijianwei.main.learn.DesignPattern.SingletonPattern;

/**
 * @author SHI
 * @date 2022/2/28 15:55
 * DCL双重检查
 */
public class Lazy {
    private Lazy(){}
    private volatile static Lazy lazy ;

    public static Lazy getInstance(){
        if (lazy == null) {
            synchronized (Lazy.class){
                if (lazy == null) {
                    lazy = new Lazy();
                }
            }
        }
        return lazy ;
    }
}
