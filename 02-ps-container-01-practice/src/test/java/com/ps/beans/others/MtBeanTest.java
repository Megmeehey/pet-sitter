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
public class MtBeanTest {
    @Test
    public void testConfig() {
        //TODO 6. Modify this class to use the new set of configuration files, created by resolving TODO 5.
        //TODO 7. Try to use wildcards as well.
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/others/beans.xml");

        MultipleTypesBean mtBean = (MultipleTypesBean) ctx.getBean("mtBean");
        assertNotNull(mtBean);

    }
}
