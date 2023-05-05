package id.harist.batchingmultipledb.dao;

import id.harist.batchingmultipledb.dto.PeopleDto;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:30
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */
public interface PeopleDao {
    int saveNewData(PeopleDto peopleDto);
}
