package com.ejemplo.batch.persistence;

import com.ejemplo.batch.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Long> {
}
