package com.ps.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by iuliana.cosmina on 2/7/16.
 * Description: Type of users using the site
 */
@AllArgsConstructor
public enum UserType {
    OWNER(1),
    SITTER(2),
    BOTH(3),
    ADMIN(4);

    @Getter
    private int code;
}
