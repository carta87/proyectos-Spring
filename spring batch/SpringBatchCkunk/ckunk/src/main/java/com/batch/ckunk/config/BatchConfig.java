package com.batch.ckunk.config;

import com.batch.ckunk.entity.Person;
import com.batch.ckunk.step.PersinItemProcessor;
import com.batch.ckunk.step.PersonItemReader;
import com.batch.ckunk.step.PersonItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public PersonItemReader septItemReader(){
        return new PersonItemReader();
    }

    @Bean
    public PersonItemWriter septItemWriter(){
        return new PersonItemWriter();
    }

    @Bean //configuracion de los hilos
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(5);
        return executor;
    }

    @Bean
    public Step readFile(){
        return stepBuilderFactory.get("read-file")
               .<Person, Person>chunk(10)
               .reader(septItemReader())
               .processor(itemProcessor()) //opcional paso
               .writer(septItemWriter())
               .taskExecutor(taskExecutor())// opcional para hilos
               .build();
    }

    @Bean //opcional paso - step
    public PersinItemProcessor itemProcessor() {
        return new PersinItemProcessor();
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("read-fileChunk")
                .start(readFile())
                .build();
    }
}
