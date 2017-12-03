package com.ps.beans.others;

import com.ps.beans.SimpleBean;
import com.ps.beans.SimpleBeanImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */

@Slf4j
public class SpringFactoryBean implements FactoryBean<SimpleBean> {

    private SimpleBean simpleBean = new SimpleBeanImpl();

    /**
     * This constructor was created just to print a message in the log and make sure that this bean is being
     * created without being declared anywhere.
     */
    public SpringFactoryBean() {
        log.info(">> Look ma, no definition!");
    }

    @Override
    public SimpleBean getObject() throws Exception {
        return this.simpleBean;
    }

    @Override
    public Class<?> getObjectType() {
        return SimpleBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
