package com.shijianwei.main.learn.DesignPattern.ProxyPattern.JDK;

import com.shijianwei.main.learn.DesignPattern.ProxyPattern.IPerson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author SHI
 * @date 2022/2/28 17:54
 */
public class MeipoJDK implements InvocationHandler {
    private IPerson person ;
    public Object getIntence(IPerson person){
        this.person = person;
        Class<?> clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(this.person,args);
        after();
        return o ;
    }

    private void before() {
        System.out.println("before");
    }


    public void after(){
        System.out.println("after");
    }


}
