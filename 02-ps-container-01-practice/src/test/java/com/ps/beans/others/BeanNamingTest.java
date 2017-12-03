package com.ps.beans.others;

import com.ps.beans.SimpleBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by iuliana.cosmina on 3/27/16.
 */
@Slf4j
public class BeanNamingTest {
    private ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("classpath:spring/others/sample-config-03.xml");
        assertNotNull(ctx);
        log.info(" --- All beans in context --- ");
        for (String beanName : ctx.getBeanDefinitionNames()) {
            /*Object o = ctx.getBean(beanName);
            if(o instanceof SimpleBean) {
                SimpleBean simpleBean = (SimpleBean) o;
                assertNotNull(simpleBean);
            }*/
            log.info("Bean " + beanName + " of type " + ctx.getBean(beanName).getClass().getSimpleName());
        }
    }

    @Test
    public void testBeanMap() {
        Map<String, SimpleBean> simpleBeans = ctx.getBeansOfType(SimpleBean.class);
        assertNotNull(simpleBeans);
        for (Map.Entry<String,SimpleBean> entry: simpleBeans.entrySet()) {
            log.info(entry.getKey(), entry.getValue());
        }
    }

    /**
     * This test assumes there are more than one SimpleBean instances defined in the context
     */
    @Test (expected = NoUniqueBeanDefinitionException.class)
    public void testMultiple(){
        SimpleBean simpleBean = ctx.getBean(SimpleBean.class);
        assertNotNull(simpleBean);
    }

    @Test
    public void testIdNaming(){
        //SimpleBean sb01 = (SimpleBean)ctx.getBean("sb01");
        SimpleBean sb01 = ctx.getBean("sb04", SimpleBean.class);
        for (String name : ctx.getAliases("sb04") ){
            log.info ("Alias for sb04 -> " + name);
        }
        assertNotNull(sb01);
    }
}
