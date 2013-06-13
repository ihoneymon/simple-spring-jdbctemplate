package kr.pe.ihoney.jdbctemplate;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Spring JdbcTemplate를 이용한 데이터입력 예제
 * User: ihoneymon
 */
public class JdbcTemplateTempDatePusher {

    public static void main(String[] args) {
        DataSource dataSource = makeDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        /**
         * insert into table values(?, ?, ?, ?);
         */
        String query = "query statement";
        
        List<Object[]> queryParams = new ArrayList<Object[]>();
        queryParams.add(new String[] {});

        jdbcTemplate.batchUpdate(query, queryParams);
    }

    public static DataSource makeDataSource() {
    	String driverClassName = "driverClass";
    	String dataSourceUrl = "jdbc:oracle:thin:@localhost:0000:sid";
    	String userName = "user";
    	String password = "password";
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
        return dataSource;
    }
}
