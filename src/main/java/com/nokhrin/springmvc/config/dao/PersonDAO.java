package com.nokhrin.springmvc.config.dao;

import com.nokhrin.springmvc.config.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people=new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Simon",21,"simon@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Andrew",22,"andrew@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"James",23,"james@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"John",24,"john@mail.ru"));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id,Person updatedPerson){
        Person personToBeUpdated=show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }
    public void delete(int id){
        people.removeIf(p -> p.getId() ==id);
    }
}
