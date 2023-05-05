package id.harist.batchingmultipledb.service.writer;

import id.harist.batchingmultipledb.model.MockDataRead;
import id.harist.batchingmultipledb.dao.PeopleDao;
import id.harist.batchingmultipledb.dao.PeopleDataSource;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:41
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */

@Component
public class WriteDataIntoLocalDB implements ItemWriter<MockDataRead> {

    private PeopleDao peopleDao;
    private PeopleDataSource dataSource;

    public WriteDataIntoLocalDB(PeopleDao peopleDao, PeopleDataSource dataSource) {
        this.peopleDao = peopleDao;
        this.dataSource = dataSource;
    }

    @Override
    public void write(List<? extends MockDataRead> list) throws Exception {
        for (MockDataRead dataRead : list) {
            var data = dataSource.findByName(dataRead.getName());
            peopleDao.saveNewData(data);
        }
    }
}
