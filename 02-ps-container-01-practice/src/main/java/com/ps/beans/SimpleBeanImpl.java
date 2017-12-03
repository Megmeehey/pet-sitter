package com.ps.beans;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Slf4j
public class SimpleBeanImpl implements SimpleBean {

    public SimpleBeanImpl() {
        log.info("[SimpleBeanImpl instantiation]");
    }

    @Override
    public String toString() {
        return "SimpleBeanImpl{ code: " + hashCode() + "}";
    }
}
