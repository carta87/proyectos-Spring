package com.ejemplo.batch.steps;

import com.ejemplo.batch.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ItemProcessorStep implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("----------------> Inicio del paso de procesamiento ---------------->");
        List<Person> personList = (List<Person>) chunkContext.getStepContext()
                .getStepExecution()
                        .getJobExecution()
                                .getExecutionContext()
                                        .get("personList");

        List<Person> personListfinal = personList.stream().map(person -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            person.setInsertionDate(formatter.format(LocalDate.now()));
            return person;
        }).toList();

        chunkContext.getStepContext()
                        .getStepExecution()
                                .getJobExecution()
                                        .getExecutionContext()
                                                .put("personList", personListfinal);

        log.info("----------------> Fin del paso de procesamiento ---------------->");
        return RepeatStatus.FINISHED;
    }
}
