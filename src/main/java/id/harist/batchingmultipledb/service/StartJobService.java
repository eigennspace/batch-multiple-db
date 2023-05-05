package id.harist.batchingmultipledb.service;

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
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 20:16
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */
@Service
public class StartJobService {

    @Autowired
    JobLauncher jobLauncher;

    @Qualifier("savingPointPRFullToDB")
    @Autowired
    Job job;


    public String startJob(){
        Map<String, JobParameter> params = new HashMap<>();
        params.put("currentTime", new JobParameter(System.currentTimeMillis()));

        JobParameters jobParameters = new JobParameters(params);

        try {
            jobLauncher.run(job, jobParameters);
            return "Starting job ...";
        } catch (
                JobExecutionAlreadyRunningException e) {
            throw new RuntimeException(e);
        } catch (
                JobRestartException e) {
            throw new RuntimeException(e);
        } catch (
                JobInstanceAlreadyCompleteException e) {
            throw new RuntimeException(e);
        } catch (
                JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

}
