package id.harist.batchingmultipledb.dao.impl;

import id.harist.batchingmultipledb.dao.PeopleDao;
import id.harist.batchingmultipledb.dto.PeopleDto;
import id.harist.batchingmultipledb.mapper.IntegerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:42
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */

@Component
public class PeopleDaoImpl implements PeopleDao {

    @Autowired
    @Qualifier("mainJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveNewData(PeopleDto peopleDto) {
        int status = jdbcTemplate.update("INSERT INTO people(email,name) values (?,?)",
                peopleDto.getEmail(),peopleDto.getName());
        return status;
    }

    @Override
    public int countData() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) as count_data FROM people", getCountRowMapper());
    }

    private RowMapper<Integer> getCountRowMapper(){
        return new IntegerMapper();
    }
}
