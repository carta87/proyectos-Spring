package com.batch.ckunk.service;

import com.batch.ckunk.entity.Person;
import com.batch.ckunk.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public void saveAll(List<Person> personLis) {
        iPersonRepository.saveAll(personLis);
    }
}
