package com.batch.ckunk.step;

import com.batch.ckunk.entity.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

public class PersonItemReader extends FlatFileItemReader<Person> {

    public PersonItemReader() {
        setName("readPerson");
        setResource(new ClassPathResource("person.csv"));
        setLinesToSkip(1); //saltar las lineas de los titulos
        setEncoding(StandardCharsets.UTF_8.displayName());
        setLineMapper(getLineMapper());
    }

    public LineMapper<Person> getLineMapper() {
        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        String[] columm = new String[]{"name", "lastName", "age"};
        int[] indexFileds = new int[]{0,1,2};

        lineTokenizer.setNames(columm);
        lineTokenizer.setIncludedFields(indexFileds);
        lineTokenizer.setDelimiter(",");

        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSet -> {
            Person person = new Person();

            // Sanitización de `name` y `lastName` (elimina caracteres no alfabéticos)
            person.setName(fieldSet.readString("name").trim().replaceAll("[^a-zA-Z ]", ""));
            person.setLasName(fieldSet.readString("lastName").trim().replaceAll("[^a-zA-Z ]", ""));

            // Validación de `age`: aseguramos que sea un número válido
            String ageRaw = fieldSet.readString("age").trim();
            if (!ageRaw.matches("\\d+")) {  // Si `age` no es un número, lanzar excepción
                throw new IllegalArgumentException("Valor de edad inválido: " + ageRaw);
            }
            person.setAge(Integer.parseInt(ageRaw));

            return person;
        });


        return lineMapper;
    }
}
