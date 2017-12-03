package com.ps.beans.others;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */

@Slf4j
public class CollectionBeansTest {
    @Test
    public void testConfig() {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/others/beans.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/others/sample-config-02.xml");

        CollectionHolder ctBean = (CollectionHolder) ctx.getBean("collectionHolder");
        assertNotNull(ctBean);
        log.info(ctBean.toString());

    }
}
