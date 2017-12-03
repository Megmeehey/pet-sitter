package com.ps.beans.others;

import com.ps.beans.SimpleBean;
import com.ps.beans.SimpleBeanImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Slf4j
public class SimpleFactoryBean {
    public SimpleBean getSimpleBean() {
        log.info(">> Instantiating a SimpleBeanImpl.");
        return new SimpleBeanImpl();
    }
}
