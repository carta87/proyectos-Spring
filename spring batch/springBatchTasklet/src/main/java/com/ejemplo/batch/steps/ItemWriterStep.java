package com.ejemplo.batch.steps;

import com.ejemplo.batch.entity.Person;
import com.ejemplo.batch.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ItemWriterStep implements Tasklet {

    @Autowired
    private IPersonService iPersonService;
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("----------------> Inicio del paso de escritura ---------------->");
        List<Person> personList = (List<Person>) chunkContext.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .get("personList");

        assert personList != null;
        personList.forEach(person -> {
            if (person != null) log.info(person.toString());
        });

        iPersonService.saveAll(personList);

        log.info("----------------> fin del paso de escritura ---------------->");
        return RepeatStatus.FINISHED;
    }
}
