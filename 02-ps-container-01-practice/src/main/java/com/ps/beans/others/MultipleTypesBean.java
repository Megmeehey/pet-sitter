package com.ps.beans.others;

import com.ps.beans.SimpleBean;
import lombok.Setter;

import java.util.Date;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Setter
public class MultipleTypesBean implements SimpleBean {
    private int noOne;
    private Integer noTwo;

    private long longOne;
    private Long longTwo;

    private float floatOne;
    private Float floatTwo;

    private double doubleOne;
    private Double doubleTwo;

    private boolean boolOne;
    private Boolean boolTwo;

    private char charOne;
    private Character charTwo;

    private Date date;
}
