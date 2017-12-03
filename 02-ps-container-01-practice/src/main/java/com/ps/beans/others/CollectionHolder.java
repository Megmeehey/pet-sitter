package com.ps.beans.others;

import com.ps.beans.SimpleBean;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
@Setter
@ToString
public class CollectionHolder {
    private List<SimpleBean> simpleBeanList;
    private Set<SimpleBean> simpleBeanSet;
    private Map<String, SimpleBean> simpleBeanMap;

    // TODO: 03.12.17 Fix ToString: CollectionHolder{ ... }
}
