package com.ps.sample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by iuliana.cosmina on 3/28/16.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SimpleBean {
    public static final SimpleBean DEFAULT_SIMPLE_BEAN = new SimpleBean("DEFAULT");
    private String name;
}
