package com.ps;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by iuliana.cosmina on 4/15/17.
 */
@AllArgsConstructor
public class CleanUp {

    private JdbcTemplate jdbcTemplate;

    private void destroy() {
        jdbcTemplate.execute("DROP ALL OBJECTS DELETE FILES;");
    }

}