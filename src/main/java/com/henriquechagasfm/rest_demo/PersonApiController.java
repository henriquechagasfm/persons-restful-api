package com.henriquechagasfm.rest_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonApiController {

    @Autowired PersonMapper personMapper;


@GetMapping
    public ResponseEntity<List<Person>> getPersons(){
      return new ResponseEntity<>(personMapper.getPersons(),HttpStatus.OK);
    }
@GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        return new ResponseEntity<>(personMapper.getPersonById(id),HttpStatus.OK);
    }
@PostMapping
    public ResponseEntity<Person> insert(@RequestBody Person person){
        personMapper.insert(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
@PostMapping("/{id}")
    public ResponseEntity <Person> update(@RequestBody Person person, @PathVariable Integer id){
        person.setId(id);
        personMapper.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
@DeleteMapping("/{id}")
    public ResponseEntity <Person> delete(@PathVariable Integer id){
        personMapper.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}