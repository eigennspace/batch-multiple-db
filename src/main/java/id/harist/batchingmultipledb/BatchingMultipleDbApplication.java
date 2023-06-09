package id.harist.batchingmultipledb;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchingMultipleDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchingMultipleDbApplication.class, args);
    }

}
