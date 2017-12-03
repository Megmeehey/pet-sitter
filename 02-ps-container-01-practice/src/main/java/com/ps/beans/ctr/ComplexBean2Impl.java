package com.ps.beans.ctr;

import com.ps.beans.ComplexBean;
import com.ps.beans.SimpleBean;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Slf4j
@Getter
public class ComplexBean2Impl implements ComplexBean {
    private SimpleBean simpleBean1;
    private SimpleBean simpleBean2;

    public ComplexBean2Impl(SimpleBean simpleBean1, SimpleBean simpleBean2) {
        log.info("[ComplexBean2Impl instantiation]");
        this.simpleBean1 = simpleBean1;
        this.simpleBean2 = simpleBean2;
    }
}
