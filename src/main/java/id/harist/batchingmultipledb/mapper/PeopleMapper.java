package id.harist.batchingmultipledb.mapper;

import id.harist.batchingmultipledb.dto.PeopleDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:48
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */
public class PeopleMapper implements RowMapper<PeopleDto> {

    @Override
    public PeopleDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PeopleDto(rs.getString("email"), rs.getString("name"));
    }
}
