package com.app.config;



import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.app.model.User;
import com.app.model.UserMapper;

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
    
    @Value("classPath:/userInput/userInputData.csv")
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
//                .processor(processor())
                .writer(jpawriter())
                .build();
    }
    
//    @Bean
//    public ItemProcessor<User, User> processor() {
//        return new DBLogProcessor();
//    }
     
    @Bean
    public FlatFileItemReader<User> reader() {
        FlatFileItemReader<User> userReader = new FlatFileItemReader<User>();
        DelimitedLineTokenizer delimeter = new DelimitedLineTokenizer();
        String[] tokens= {"userId","userName","gender","salary","age","pan","adhar"};
        delimeter.setNames(tokens);
        delimeter.setDelimiter(",");
        DefaultLineMapper<User> lineMapper = new DefaultLineMapper<User>();
        lineMapper.setLineTokenizer(delimeter);        
        userReader.setResource(userInputResource);
        UserMapper userMapper=new UserMapper();
        lineMapper.setFieldSetMapper(userMapper);
        userReader.setLineMapper(lineMapper);
        userReader.setLinesToSkip(0);
        return userReader;
    }
 
     
    @Bean
    public JdbcBatchItemWriter<User> writer() {
        JdbcBatchItemWriter<User> itemWriter = new JdbcBatchItemWriter<User>();
        itemWriter.setDataSource(datasource);
        itemWriter.setSql("INSERT INTO EMPLOYEE (ID, FIRSTNAME, LASTNAME) VALUES (:id, :firstName, :lastName)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
        return itemWriter;
    }
    @Bean
    public JpaItemWriter<User> jpawriter() {
    	JpaItemWriter<User> userItemWriter = new JpaItemWriter<User>();
    	userItemWriter.setEntityManagerFactory(entityManager);    	
        return userItemWriter;
    }
     
//    @Bean
//	public DataSource datasource() {
//		DriverManagerDataSource dataSource=new DriverManagerDataSource();
//		dataSource.setDriverClassName(DB_DRIVER);
//		dataSource.setUrl(DB_URL);
//		dataSource.setUsername(DB_USERNAME);
//		dataSource.setPassword(DB_PASSWORD);		
//		return dataSource;		
//	}    
   
    
}
