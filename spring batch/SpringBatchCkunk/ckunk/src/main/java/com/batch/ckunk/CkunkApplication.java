package com.batch.ckunk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class CkunkApplication {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
    private Job job;

	public static void main(String[] args) {
		SpringApplication.run(CkunkApplication.class, args);
	}

	@Bean
	CommandLineRunner init(){
		return args -> {
			JobParameters jobParameter = new JobParametersBuilder()
					.addString("name", "chunck")
							.addLong("id", System.currentTimeMillis())
									.addDate("created", new Date())
											.toJobParameters();
			jobLauncher.run(job, jobParameter);
        };
	}

}
