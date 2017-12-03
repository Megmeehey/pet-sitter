package com.ps.beans.ctr;

import com.ps.beans.ComplexBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Slf4j
public class CIBeansTest {
    @Test
    public void testConfig() {
        List<ComplexBean> complexBeanList = new ArrayList<>();
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ctr/sample-config-01.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ctr/sample-config-02.xml");

        log.info(" --- All beans in context --- ");
        for (String beanName : ctx.getBeanDefinitionNames()) {
            Object bean = ctx.getBean(beanName);
            Class<?>[] interfaces = bean.getClass().getInterfaces();
            for (Class intrfc : interfaces) {
                if (intrfc == ComplexBean.class) {
                    complexBeanList.add((ComplexBean) bean);
                }
            }
            log.info("Bean " + beanName + " of type ");
        }

        complexBeanList = complexBeanList.stream()
                .filter(this::isValidComplexBean)
                .collect(Collectors.toList());

        assertTrue(complexBeanList.size() == 0);
        //TODO 3. Retrieve beans of types ComplexBean and make sure their dependencies were correctly set.
    }

    private boolean isValidComplexBean(ComplexBean bean) {
        if (bean instanceof ComplexBeanImpl) {
            ComplexBeanImpl cbi = (ComplexBeanImpl) bean;
            return cbi.getSimpleBean() != null;
        } else {
            ComplexBean2Impl cbi = (ComplexBean2Impl) bean;
            return cbi.getSimpleBean1() != null && cbi.getSimpleBean2() != null;
        }
    }
}
