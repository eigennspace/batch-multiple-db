package id.harist.batchingmultipledb.dao;

import id.harist.batchingmultipledb.dto.PeopleDto;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:47
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */
public interface PeopleDataSource {

    PeopleDto findByName(String name);
}
