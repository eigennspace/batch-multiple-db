package id.harist.batchingmultipledb.service.job;

import id.harist.batchingmultipledb.model.MockDataRead;
import id.harist.batchingmultipledb.service.writer.WriteDataIntoLocalDB;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.io.File;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:32
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */

@Configuration
public class BatchJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private WriteDataIntoLocalDB writeDataIntoLocalDB;

    @Bean
    public Job savingPointPRFullToDB(){
        return jobBuilderFactory.get("savingPointPRFullToDB")
                .start(stepSavingPointPRFullToDB())
                .build();

    }

    private Step stepSavingPointPRFullToDB(){
        return stepBuilderFactory.get("stepSavingPointPRFullToDB")
                .<MockDataRead,MockDataRead>chunk(10)
                .reader(flatFileItemReader())
                .writer(writeDataIntoLocalDB)
                .build();
    }

    public FlatFileItemReader<MockDataRead> flatFileItemReader(){
        FlatFileItemReader<MockDataRead> flatFileItemReader =
                new FlatFileItemReader<>();

        flatFileItemReader.setResource(new FileSystemResource(
                new File("src/main/resources/file/MOCK_DATA.csv")
        ));

        flatFileItemReader.setLineMapper(
                new DefaultLineMapper<>(){
                    {
                        setLineTokenizer(new DelimitedLineTokenizer(){
                            {
                                setNames("name");
                            }
                        });
                        setFieldSetMapper(new BeanWrapperFieldSetMapper<>(){
                            {
                                setTargetType(MockDataRead.class);
                            }
                        });
                    }
                }
        );

        flatFileItemReader.setLinesToSkip(1);

        return flatFileItemReader;
    }

}
