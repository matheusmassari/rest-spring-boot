package com.massari.restspringboot.services;

import com.massari.restspringboot.data.vo.v1.PersonVO;
import com.massari.restspringboot.exceptions.ResourceNotFoundException;
import com.massari.restspringboot.mapper.PersonMapper;
import com.massari.restspringboot.model.Person;
import com.massari.restspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        return repository.findAll().stream()
                .map(PersonMapper.INSTANCE::personToPersonVO)
                .collect(Collectors.toList());
    }

    public PersonVO findById(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return PersonMapper.INSTANCE.personToPersonVO(entity);
    }


    public PersonVO create(PersonVO person) {
        Person entity = PersonMapper.INSTANCE.personVOToPerson(person);
        Person savedEntity = repository.save(entity);
        return PersonMapper.INSTANCE.personToPersonVO(savedEntity);
    }

    public PersonVO update(PersonVO person) {

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        Person savedEntity = repository.save(entity);
        return PersonMapper.INSTANCE.personToPersonVO(savedEntity);

    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }

}
