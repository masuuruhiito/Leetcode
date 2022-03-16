package com.shijianwei.main.learn.DesignPattern.ProxyPattern.CGLib;

/**
 * @author SHI
 * @date 2022/2/28 18:11
 */
public class CGLibProxyTest {
    public static void main(String[] args) {
        Customer c = (Customer) new MeipoCGLib().getInstance(Customer.class) ;
        c.findLove();
        c.drink();
    }
}
