package com.example.demo.repository;

import com.example.demo.model.RM1Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RM1ResourceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RM1Resource> getAllRm1(String va) {
        String sql = "SELECT RESOURCE_TYPE_KEY," +
                "RESOURCE_VALUE, " +
                "RESOURCE_POOL_ID, " +
                "RESOURCE_STATUS, " +
                "LAST_ACTIVITY_NAME, " +
                "LAST_ACTIVITY_DATE, " +
                "CATEGORY_INDEX, " +
                "RESOURCE_PARENT_VALUE " +
                "FROM RM1_RESOURCE WHERE RESOURCE_VALUE = '" + va + "'";

        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public List<RM1Resource> getAllRm1() {
        String va = "0926575527";
        String sql = "SELECT RESOURCE_TYPE_KEY," +
                "RESOURCE_VALUE, " +
                "RESOURCE_POOL_ID, " +
                "RESOURCE_STATUS, " +
                "LAST_ACTIVITY_NAME, " +
                "LAST_ACTIVITY_DATE, " +
                "CATEGORY_INDEX, " +
                "RESOURCE_PARENT_VALUE " +
                "FROM RM1_RESOURCE WHERE RESOURCE_VALUE = '" + va + "'";

        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper<RM1Resource> {
        @Override
        public RM1Resource mapRow(ResultSet resultSet, int i) throws SQLException { // มาตามที่ set ไว้
            RM1Resource user = new RM1Resource();
            user.setResourceValue(resultSet.getString("RESOURCE_VALUE"));
            user.setStatus(resultSet.getString("RESOURCE_STATUS"));
            user.setStatus(resultSet.getString("RESOURCE_POOL_ID"));
            user.setStatus(resultSet.getString("RESOURCE_TYPE_KEY"));
            user.setStatus(resultSet.getString("LAST_ACTIVITY_NAME"));
            user.setStatus(resultSet.getString("LAST_ACTIVITY_DATE"));
            user.setStatus(resultSet.getString("CATEGORY_INDEX"));
            user.setStatus(resultSet.getString("RESOURCE_PARENT_VALUE"));

            return user;
        }
    }
}