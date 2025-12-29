package com.batch.ckunk.step;

import com.batch.ckunk.entity.Person;
import com.batch.ckunk.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class PersonItemWriter implements ItemWriter<Person> {

    @Autowired
    private IPersonService iPersonService;

    @Override
    public void write(List<? extends Person> items) throws Exception {

        items.forEach(person -> person.toString());
        iPersonService.saveAll((List<Person>) items); // Assuming saveAll method in IPersonService is implemented
    }
}
