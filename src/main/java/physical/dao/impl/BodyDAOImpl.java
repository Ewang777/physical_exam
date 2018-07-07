package physical.dao.impl;

import physical.dao.BodyDAO;
import physical.dao.DataSourceHelper;
import physical.model.all.BodyLevel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * created by ewang on 2018/7/6.
 */
@Repository
public class BodyDAOImpl implements BodyDAO, RowMapper<BodyLevel> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(DataSourceHelper.getDataSource());
    }

    @Override
    public BodyLevel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BodyLevel(rs.getString("major"), rs.getInt("count"));
    }

    @Override
    public List<BodyLevel> findAllBodyA() {
        String sql = "select * from body_A";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

    @Override
    public List<BodyLevel> findAllBodyB() {
        String sql = "select * from body_B";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

    @Override
    public List<BodyLevel> findAllBodyC() {
        String sql = "select * from body_C";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

    @Override
    public List<BodyLevel> findAllBodyD() {
        String sql = "select * from body_D";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

}
