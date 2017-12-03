package com.ps.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * Created by iuliana.cosmina on 2/22/16.
 */

@EqualsAndHashCode
@AllArgsConstructor
public class Pair<X, Y> {
    protected X x;
    protected Y y;

    public X x() {
        return x;
    }

    public Y y() {
        return y;
    }

    public void x(X x) {
        this.x = x;
    }

    public void y(Y y) {
        this.y = y;
    }

    public static <X, Y> Pair<X, Y> of(X x, Y y) {
        return new Pair<>(x, y);
    }
}