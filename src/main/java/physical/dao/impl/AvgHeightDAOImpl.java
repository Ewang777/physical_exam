package physical.dao.impl;

import physical.dao.AvgHeightDAO;
import physical.dao.DataSourceHelper;
import physical.model.grade13.from16to17.AvgHeight;
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
public class AvgHeightDAOImpl implements AvgHeightDAO, RowMapper<AvgHeight> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(DataSourceHelper.getDataSource());
    }

    @Override
    public AvgHeight mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AvgHeight(rs.getString("major"), rs.getDouble("height"));
    }

    @Override
    public List<AvgHeight> findAllHeight() {
        String sql="select * from avg_height_grade13_2016_to_2017";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null,this);
    }


}
