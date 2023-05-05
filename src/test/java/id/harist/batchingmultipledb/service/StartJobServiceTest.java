package id.harist.batchingmultipledb.service;

import id.harist.batchingmultipledb.controller.Jobs;
import id.harist.batchingmultipledb.dao.PeopleDao;
import id.harist.batchingmultipledb.dao.impl.PeopleDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 20:26
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */
@SpringBootTest
@AutoConfigureMockMvc
public class StartJobServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PeopleDao peopleDao;

    @Test
    void test_startJob(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/startJob"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // before do this, increment +100 for the expected result
        assertEquals(400,peopleDao.countData());
    }

}
