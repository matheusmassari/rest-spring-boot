package com.massari.restspringboot.mapper;

import com.massari.restspringboot.data.vo.v1.PersonVO;
import com.massari.restspringboot.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );

    PersonVO personToPersonVO(Person person);

    Person personVOToPerson(PersonVO personVO);
}
