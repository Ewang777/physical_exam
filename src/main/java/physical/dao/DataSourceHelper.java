package physical.dao;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

/**
 * created by ewang on 2018/7/6.
 */
public class DataSourceHelper {
    public static DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/physical_exam");
        dataSource.setUsername("root");
        dataSource.setPassword("0530");
        return dataSource;
    }
}
