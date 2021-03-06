package com.github.chengbin.auth.reflect;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangcb
 * @created 2018-02-02 16:38.
 */
public class ProxyFactory{

    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long t1 = System.currentTimeMillis();
                System.out.println("方法"+ method.getName()+"调用开始时间:" + t1);
                Object returnValue = method.invoke(target,args);  //调用目标对象方法
                System.out.println("方法"+method.getName()+"调用共耗时:" + (System.currentTimeMillis() - t1)/1000);
                return returnValue;
            }
        });
    }
}
