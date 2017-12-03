package com.ps.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
@AllArgsConstructor
public enum ResponseStatus {
    PROPOSED(1),
    ACCEPTED(2),
    REJECTED(3);

    @Getter
    private int code;
}
