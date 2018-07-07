package physical.dao.impl;

import physical.dao.AvgLangOfBodyDAO;
import physical.dao.DataSourceHelper;
import physical.model.grade13.from16to17.AvgLangOfBody;
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
public class AvgLangOfBodyDAOImpl implements AvgLangOfBodyDAO, RowMapper<AvgLangOfBody> {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(DataSourceHelper.getDataSource());
    }


    @Override
    public AvgLangOfBody mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AvgLangOfBody(rs.getString("body_level"), rs.getDouble("lang"));
    }

    @Override
    public List<AvgLangOfBody> findAllLangOfBody() {
        String sql = "select * from avg_body_lang_grade13_2016_to_2017";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }
}
