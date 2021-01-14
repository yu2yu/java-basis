package com.yy.design.proxy;

import com.yy.design.proxy.cglib.Product;
import com.yy.design.proxy.cglib.ProxyCglib;
import com.yy.design.proxy.dynamic.ProxyMathDynamic;
import com.yy.design.proxy.example.IUserDao;
import com.yy.design.proxy.staticProxy.principle.Math;
import com.yy.design.proxy.staticProxy.principle.ProxyMath;
import com.yy.design.proxy.staticProxy.principle.Subject;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/14
 */
public class ProxyTest {

    @Test
    public void testProxy(){
        new ProxyMath(new Math()).show();
    }


    @Test
    public void testProxyDynamic(){
        Subject proxyInstance = (Subject) new ProxyMathDynamic(new Math()).getProxyInstance();
        proxyInstance.show();
    }

    @Test
    public void testProxyCglib(){
        Product proxyInstance = (Product) new ProxyCglib(new Product()).getProxyInstance();
        proxyInstance.show();
    }

    @Test
    public void testUserDao(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        // userDao是代理类
        IUserDao userDao = (IUserDao) beanFactory.getBean("userDao");
        System.out.println(userDao.query("1"));
    }
}
