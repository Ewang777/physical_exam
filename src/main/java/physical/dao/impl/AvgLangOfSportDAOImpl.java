package physical.dao.impl;

import physical.dao.AvgLangOfBodyDAO;
import physical.dao.AvgLangOfSportDAO;
import physical.dao.DataSourceHelper;
import physical.model.grade13.from16to17.AvgLangOfSport;
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
public class AvgLangOfSportDAOImpl implements AvgLangOfSportDAO, RowMapper<AvgLangOfSport> {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(DataSourceHelper.getDataSource());
    }


    @Override
    public AvgLangOfSport mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AvgLangOfSport(rs.getString("sport_level"), rs.getDouble("lang"));
    }

    @Override
    public List<AvgLangOfSport> findAllLangOfSport() {
        String sql = "select * from avg_sport_lang_grade13_2016_to_2017";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }
}
