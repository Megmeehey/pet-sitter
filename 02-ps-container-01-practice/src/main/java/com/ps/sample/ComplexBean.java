package com.ps.sample;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by iuliana.cosmina on 3/28/16.
 * Sample class used to make bean creation staged understanding easy.
 * This class contains all the methods used to initialize and detroy a bean altogether, so you can the
 * order they are called in.
 */
@Slf4j
public class ComplexBean {

    @Getter
    private SimpleBean simpleBean1;
    private SimpleBean simpleBean2;

    public ComplexBean(SimpleBean simpleBean1) {
        log.info(" --> Stage 1: Calling the constructor.");
        this.simpleBean1 = simpleBean1;
    }

    @Required
    public void setSimpleBean2(SimpleBean simpleBean2) {
        log.info(" --> Stage 2: Calling the setter.");
        this.simpleBean2 = simpleBean2;
    }

    /**
     * The initialization method.
     * Just for fun: it instantiates the simpleBean2 only if the current time is even.
     */
    private void initMethod() {
        log.info(" --> Stage 3: Calling the initMethod.");
        long ct = System.currentTimeMillis();
        if (ct % 2 == 0) {
            simpleBean2 = new SimpleBean();
        }
    }
    /**
     * Destroy method
     */
    private boolean destroyMethod() {
        log.info(" --> Calling the destroyMethod.");
        simpleBean1 = null;
        simpleBean2 = null;
        return true;
    }
}
