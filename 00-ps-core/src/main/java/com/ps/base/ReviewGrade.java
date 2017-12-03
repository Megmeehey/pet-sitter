package com.ps.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
@AllArgsConstructor
public enum ReviewGrade {
    WORST(0),
    BAD(1),
    ACCEPTABLE(2),
    GOOD(3),
    WONDERFUL(4);

    @Getter
    private int grade;
}
