package com.henriquechagasfm.rest_demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    
    public List<Person> getPersons();

    public Person getPersonById(Integer id);

    public void save(Person person);

    public void delete(Integer id);
    
    public void insert(Person person);
       
}
