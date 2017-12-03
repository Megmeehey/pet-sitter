package com.ps.beans.set;

import com.ps.beans.ComplexBean;
import com.ps.beans.SimpleBean;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Slf4j
public class ComplexBeanImpl implements ComplexBean {

    @Getter
    private SimpleBean simpleBean;

    @Getter
    private boolean complex;

    /**
     * Default no-argument constructor, not really necessary, just added here to print a log entry,
     * in order to see in the java console when objects of this type are instantiated
     */
    public ComplexBeanImpl() {
        log.info("[ComplexBeanImpl instantiation]");
    }

    public void setSimpleBean(SimpleBean simpleBean) {
        log.info("[Injecting dependency simpleBean]");
        this.simpleBean = simpleBean;
    }

    public void setComplex(boolean complex) {
        log.info("[Injecting dependency complex]");
        this.complex = complex;
    }
}
