package id.harist.batchingmultipledb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:21
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */

@Configuration
public class DBConfig {

    @Primary
    @Bean(name = "mainDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mainDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "peopleDataSource")
    @ConfigurationProperties(prefix = "spring.datasourcepeople")
    public DataSource peopleDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Bean(name = "peopleJdbcTemplate")
    public JdbcTemplate peopleJdbcTemplate(@Qualifier("peopleDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Primary
    @Autowired
    @Bean(name = "mainJdbcTemplate")
    public JdbcTemplate mainJdbcTemplate(@Qualifier("mainDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
