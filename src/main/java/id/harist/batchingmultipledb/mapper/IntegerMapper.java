package id.harist.batchingmultipledb.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 20:35
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */
public class IntegerMapper implements RowMapper<Integer> {

    @Override
    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getInt("count_data");
    }
}
