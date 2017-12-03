package com.ps.beans.set;

import com.ps.beans.ComplexBean;
import com.ps.beans.ctr.ComplexBean2Impl;
import com.ps.beans.ctr.ComplexBeanImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Slf4j
public class SIBeansTest {
    @Test
    public void testConfig() {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/set/sample-config-01.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/set/sample-config-02.xml");

        log.info(" --- All beans in context --- ");
        for (String beanName : ctx.getBeanDefinitionNames()) {
            Object bean = ctx.getBean(beanName);
            Class<?>[] interfaces = bean.getClass().getInterfaces();
            for (Class intrfc : interfaces) {
                if (intrfc == ComplexBean.class) {
                    if (bean instanceof com.ps.beans.ctr.ComplexBeanImpl) {
                        com.ps.beans.ctr.ComplexBeanImpl cbi = (ComplexBeanImpl) bean;
                        assertTrue(cbi.getSimpleBean() != null);
                    } else {
                        com.ps.beans.ctr.ComplexBean2Impl cbi = (ComplexBean2Impl) bean;
                        assertTrue(cbi.getSimpleBean1() != null && cbi.getSimpleBean2() != null);
                    }
                }
            }
            log.info("Bean " + beanName + " of type " + ctx.getBean(beanName).getClass().getSimpleName());
        }

        //TODO 4. Retrieve beans of types ComplexBean and make sure their dependencies were correctly set.
    }
}
