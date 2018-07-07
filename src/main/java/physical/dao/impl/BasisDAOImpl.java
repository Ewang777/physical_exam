package physical.dao.impl;

import physical.dao.BasisDAO;
import physical.dao.DataSourceHelper;
import physical.model.grade13.change.BasisAboutChange;
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
public class BasisDAOImpl implements BasisDAO, RowMapper<BasisAboutChange> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(DataSourceHelper.getDataSource());
    }

    @Override
    public BasisAboutChange mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BasisAboutChange(rs.getInt("stu_num"),
                rs.getDouble("height"),
                rs.getDouble("weight"),
                rs.getDouble("sport_score"));
    }

    @Override
    public List<BasisAboutChange> findAllBasisFrom14To15() {
        String sql = "select * from grade13_2014_to_2015_change order by height desc";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

    @Override
    public List<BasisAboutChange> findAllBasisFrom15To16() {
        String sql = "select * from grade13_2015_to_2016_change order by height desc";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }

    @Override
    public List<BasisAboutChange> findAllBasisFrom16To17() {
        String sql = "select * from grade13_2016_to_2017_change order by height desc";
        return jdbcTemplate.query(sql, (MapSqlParameterSource) null, this);
    }
}
