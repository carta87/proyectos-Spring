package com.batch.ckunk.service;

import com.batch.ckunk.entity.Person;

import java.util.List;

public interface IPersonService {

    void saveAll(List<Person> personLis);
}
