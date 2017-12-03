package com.ps.beans.set;

import com.ps.beans.ComplexBean;
import com.ps.beans.SimpleBean;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */

@Slf4j
public class ComplexBean2Impl implements ComplexBean {
    @Getter
    private SimpleBean simpleBean;

    @Getter
    private boolean complex;

    public ComplexBean2Impl(SimpleBean simpleBean)
    {
        log.info("[ComplexBean2Impl instantiation]");
        this.simpleBean = simpleBean;
    }

    public void setComplex(boolean complex) {
        log.info("[Injecting dependency complex]");
        this.complex = complex;
    }
}
