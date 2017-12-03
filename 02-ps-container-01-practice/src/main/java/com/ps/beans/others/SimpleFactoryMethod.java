package com.ps.beans.others;

import com.ps.beans.SimpleBean;
import com.ps.beans.SimpleBeanImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by iuliana.cosmina on 3/26/16.
 * Class used to create a bean using the factory method
 */
@Slf4j
public class SimpleFactoryMethod {
    /**
     * the factory method that will be called by the container
     * @return
     */
    public static SimpleBean getSimpleBean() {
        log.info(">> Instantiating a SimpleBeanImpl.");
        return new SimpleBeanImpl();
    }
}
