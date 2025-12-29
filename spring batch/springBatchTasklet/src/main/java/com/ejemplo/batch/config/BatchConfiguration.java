package com.ejemplo.batch.config;

import com.ejemplo.batch.steps.ItemDescompressStep;
import com.ejemplo.batch.steps.ItemProcessorStep;
import com.ejemplo.batch.steps.ItemReaderStep;
import com.ejemplo.batch.steps.ItemWriterStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    @JobScope
    public ItemReaderStep itemReaderStep() {
        return new ItemReaderStep();
    }

    @Bean
    @JobScope
    public ItemWriterStep itemWriterStep() {
        return new ItemWriterStep();
    }

    @Bean
    @JobScope
    public ItemProcessorStep itemProcessorStep() {
        return new ItemProcessorStep();
    }

    @Bean
    @JobScope
    public ItemDescompressStep itemDescompressStep() {
        return new ItemDescompressStep();
    }

    @Bean
    public Step descompressFileStep(){
        return  stepBuilderFactory.get("itemDescompressStep")
                .tasklet(itemDescompressStep())
                .build();
    }

    @Bean
    public Step readFileStep(){
        return  stepBuilderFactory.get("itemReaderStep")
                .tasklet(itemReaderStep())
                .build();
    }

    @Bean
    public Step processDataStep(){
        return stepBuilderFactory.get("itemProcessStep")
                .tasklet(itemProcessorStep())
                .build();
    }

    @Bean
    public Step writeFileStep(){
        return stepBuilderFactory.get("itemWriterStep")
                .tasklet(itemWriterStep())
                .build();
    }

    @Bean
    public Job readCSVJob() {
        return jobBuilderFactory.get("processFileCVSJob")
               .start(descompressFileStep())
               .next(readFileStep())
               .next(processDataStep())
               .next(writeFileStep())
               .build();
    }
}
