package id.harist.batchingmultipledb.controller;

import id.harist.batchingmultipledb.service.StartJobService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 20:01
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */

@RestController
public class Jobs {

    @Autowired
    StartJobService startJobService;

    @GetMapping("/startJob")
    private String startJob(){
        return startJobService.startJob();
    }
}
