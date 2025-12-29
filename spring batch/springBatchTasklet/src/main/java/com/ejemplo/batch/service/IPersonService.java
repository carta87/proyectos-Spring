package com.ejemplo.batch.service;

import com.ejemplo.batch.entity.Person;

import java.util.List;

public interface IPersonService {

    void saveAll(List<Person> personList);
}
