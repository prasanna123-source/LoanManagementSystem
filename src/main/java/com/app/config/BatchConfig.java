package com.app.config;



import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.app.entity.User;


@Configuration
@EnableBatchProcessing
@PropertySource(value = { "classpath:application.properties" })
public class BatchConfig {
     
	@Autowired
	DataSource datasource;
	
	@Autowired
	EntityManagerFactory entityManager;
	
	@Autowired
    private JobBuilderFactory jobBuilderFactory;
 
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    
    @Value("classpath:userInputData.csv")
    private org.springframework.core.io.Resource userInputResource;
    
    @Bean
    public Job readUserCSVFileJob() {
        return jobBuilderFactory
                .get("readUserCSVFileJob")
                .incrementer(new RunIdIncrementer())
                .start(step())
                .build();
    }
 
    @Bean
    public Step step() {
        return stepBuilderFactory
                .get("step")
                .<User, User>chunk(1)
                .reader(reader())
                .processor(processor())
                .writer(jpawriter())
                .build();
    }
    
    @Bean
    public ItemProcessor<User, User> processor() {
        return new DBLogProcessor();
    }
    
    
    @Bean
    public FlatFileItemReader<User> reader() {
        FlatFileItemReader<User> itemReader = new FlatFileItemReader<User>();
        itemReader.setLineMapper(lineMapper());
        itemReader.setLinesToSkip(1);
        itemReader.setResource(userInputResource);
        return itemReader;
    }

 
    @Bean
    public LineMapper<User> lineMapper() {
        DefaultLineMapper<User> lineMapper = new DefaultLineMapper<User>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[] { "userId", "userName", "gender", "age", "salary", "pan", "adhar" });
        lineTokenizer.setIncludedFields(new int[] { 0, 1, 2, 3, 4, 5, 6 });
        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<User>();
        fieldSetMapper.setTargetType(User.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
     
    @Bean
    public JdbcBatchItemWriter<User> writer() {
        JdbcBatchItemWriter<User> itemWriter = new JdbcBatchItemWriter<User>();
        itemWriter.setDataSource(datasource);
        itemWriter.setSql("INSERT INTO User (user_name, gender,age,salary,pan,adhar)"
        		+ " VALUES (:user_name, :gender ,:age, :salary, :pan, :adhar)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
        return itemWriter;
    }
    @Bean
    public JpaItemWriter<User> jpawriter() {
    	JpaItemWriter<User> userItemWriter = new JpaItemWriter<User>();
    	userItemWriter.setEntityManagerFactory(entityManager);    	
        return userItemWriter;
    }     
 
   
    
}
