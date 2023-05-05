package id.harist.batchingmultipledb.dao.impl;

import id.harist.batchingmultipledb.dao.PeopleDataSource;
import id.harist.batchingmultipledb.dto.PeopleDto;
import id.harist.batchingmultipledb.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:48
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */
@Component
public class PeopleDataSourceImpl implements PeopleDataSource {

    @Autowired
    @Qualifier("amorJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public PeopleDto findByName(String name) {
        PeopleDto res;
        try {
            res = jdbcTemplate.queryForObject("SELECT * FROM people WHERE name = ?"
                    , getRowMapperPeopleDto(), name);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
        return res;
    }

    private RowMapper<PeopleDto> getRowMapperPeopleDto(){
        return new PeopleMapper();
    }
}
