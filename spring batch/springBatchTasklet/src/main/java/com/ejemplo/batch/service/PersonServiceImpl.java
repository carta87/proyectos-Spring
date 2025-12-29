package com.ejemplo.batch.service;

import com.ejemplo.batch.entity.Person;
import com.ejemplo.batch.persistence.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService{

    private final IPersonRepository iPersonRepository;

    @Override
    @Transactional
    public void saveAll(List<Person> personList) {
        iPersonRepository.saveAll(personList);
    }
}
