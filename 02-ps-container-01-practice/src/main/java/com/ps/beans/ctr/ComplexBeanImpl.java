package com.ps.beans.ctr;

import com.ps.beans.ComplexBean;
import com.ps.beans.SimpleBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Slf4j
@AllArgsConstructor
@Getter
public class ComplexBeanImpl implements ComplexBean {

    private SimpleBean simpleBean;

    private boolean complex;

    public ComplexBeanImpl(SimpleBean simpleBean) {
        log.info("[ComplexBeanImpl instantiation]");
        this.simpleBean = simpleBean;
    }
}
