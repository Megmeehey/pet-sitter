package com.ps.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
@AllArgsConstructor
public enum RequestStatus {
    NEW(1),
    SOLVED(2),
    ANULLED(3);

    @Getter
    private int code;
}
