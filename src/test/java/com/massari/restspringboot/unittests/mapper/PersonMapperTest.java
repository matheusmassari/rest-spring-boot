package com.massari.restspringboot.unittests.mapper;

import com.massari.restspringboot.data.vo.v1.PersonVO;
import com.massari.restspringboot.mapper.PersonMapper;
import com.massari.restspringboot.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonMapperTest {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private Person person;
    private PersonVO personVO;

    @BeforeEach
    void setUp() {
        person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress("123 Main St");
        person.setGender("Male");

        personVO = new PersonVO();
        personVO.setId(1L);
        personVO.setFirstName("John");
        personVO.setLastName("Doe");
        personVO.setAddress("123 Main St");
        personVO.setGender("Male");
    }

    @Nested
    class PersonToPersonVOTest {
        @Test
        void shouldConvertPersonToPersonVO() {
            PersonVO result = personMapper.personToPersonVO(person);

            assertThat(result).isNotNull();
            assertThat(result.getId()).isEqualTo(person.getId());
            assertThat(result.getFirstName()).isEqualTo(person.getFirstName());
            assertThat(result.getLastName()).isEqualTo(person.getLastName());
            assertThat(result.getAddress()).isEqualTo(person.getAddress());
            assertThat(result.getGender()).isEqualTo(person.getGender());
        }
    }

    @Nested
    class PersonVOToPersonTest {
        @Test
        void shouldConvertPersonVOToPerson() {
            Person result = personMapper.personVOToPerson(personVO);

            assertThat(result).isNotNull();
            assertThat(result.getId()).isEqualTo(personVO.getId());
            assertThat(result.getFirstName()).isEqualTo(personVO.getFirstName());
            assertThat(result.getLastName()).isEqualTo(personVO.getLastName());
            assertThat(result.getAddress()).isEqualTo(personVO.getAddress());
            assertThat(result.getGender()).isEqualTo(personVO.getGender());
        }
    }
}
