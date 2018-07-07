package physical.dao.impl;

import physical.dao.DataSourceHelper;
import physical.dao.ScoreDAO;
import physical.model.all.ScoreLevel;
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
public class ScoreDAOImpl implements ScoreDAO, RowMapper<ScoreLevel> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(DataSourceHelper.getDataSource());
    }

    @Override
    public ScoreLevel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ScoreLevel(rs.getString("major"), rs.getInt("count"));
    }

    @Override
    public List<ScoreLevel> findAllScoreA() {
        String sql = "select * from score_A";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

    @Override
    public List<ScoreLevel> findAllScoreB() {
        String sql = "select * from score_B";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

    @Override
    public List<ScoreLevel> findAllScoreC() {
        String sql = "select * from score_C";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

    @Override
    public List<ScoreLevel> findAllScoreD() {
        String sql = "select * from score_D";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }
}
