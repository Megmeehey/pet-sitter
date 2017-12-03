package com.ps.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */

@AllArgsConstructor
public enum PetType {
    CAT(1),
    DOG(2),
    BIRD(3),
    OTHER(4);

    @Getter
    private int code;
}
