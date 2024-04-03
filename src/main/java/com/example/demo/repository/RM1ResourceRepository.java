package com.example.demo.repository;

import com.example.demo.model.RM1Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class RM1ResourceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RM1Resource> getRM1ResourceData1(String va) {
        String sql = "SELECT * " +
                "FROM RM1_RESOURCE WHERE RESOURCE_VALUE = '" + va + "'";

        return jdbcTemplate.query(sql, new Rm1RowMapper());
    }

    public Object getRM1ResourceStatus(String va) {
        String sql = "SELECT RESOURCE_VALUE, RESOURCE_STATUS, RESOURCE_POOL_ID " +
                "FROM RM1_RESOURCE WHERE RESOURCE_VALUE = '" + va + "'";

        return jdbcTemplate.queryForMap(sql);
    }

    public List<RM1Resource> getAllRm1(String va) {
        String sql = "SELECT RESOURCE_TYPE_KEY, " +
                "RESOURCE_VALUE, " +
                "RESOURCE_POOL_ID, " +
                "RESOURCE_STATUS, " +
                "LAST_ACTIVITY_NAME, " +
                "LAST_ACTIVITY_DATE, " +
                "CATEGORY_INDEX, " +
                "RESOURCE_PARENT_VALUE " +
                "FROM RM1_RESOURCE WHERE RESOURCE_VALUE = '" + va + "'";

        return jdbcTemplate.query(sql, new Rm1RowMapper());
    }

    public List<RM1Resource> getAllRm1() {
        String va = "0926575527";
        String sql = "SELECT RESOURCE_TYPE_KEY, " +
                "RESOURCE_VALUE, " +
                "RESOURCE_POOL_ID, " +
                "RESOURCE_STATUS, " +
                "LAST_ACTIVITY_NAME, " +
                "LAST_ACTIVITY_DATE, " +
                "CATEGORY_INDEX, " +
                "RESOURCE_PARENT_VALUE " +
                "FROM RM1_RESOURCE WHERE RESOURCE_VALUE = '" + va + "'";

        return jdbcTemplate.query(sql, new Rm1RowMapper());
    }

    private static class Rm1RowMapper implements RowMapper<RM1Resource> {
        @Override
        public RM1Resource mapRow(ResultSet resultSet, int i) throws SQLException { // มาตามที่ set ไว้
            RM1Resource rm1 = new RM1Resource();
            rm1.setTypeKey(Integer.parseInt(resultSet.getString("RESOURCE_TYPE_KEY")));
            rm1.setResourceValue(resultSet.getString("RESOURCE_VALUE"));
            rm1.setResourcePoolId(Integer.parseInt(resultSet.getString("RESOURCE_POOL_ID")));
            rm1.setStatus(resultSet.getString("RESOURCE_STATUS"));
            rm1.setLastActivityName(resultSet.getString("LAST_ACTIVITY_NAME"));
            rm1.setLastActivityDate(resultSet.getString("LAST_ACTIVITY_DATE"));
//            rm1.setLastActivityDate(Timestamp.valueOf(resultSet.getString("LAST_ACTIVITY_DATE")));
            rm1.setCategoryIndex(Integer.parseInt(resultSet.getString("CATEGORY_INDEX")));
            rm1.setSim(resultSet.getString("RESOURCE_PARENT_VALUE"));

            return rm1;
        }
    }

}