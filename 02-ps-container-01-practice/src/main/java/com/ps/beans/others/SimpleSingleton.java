package com.ps.beans.others;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Slf4j
public class SimpleSingleton {
    @Getter
    private static SimpleSingleton instance = new SimpleSingleton();

    private SimpleSingleton() {
        log.info(">> Creating single instance.");
    }
}
