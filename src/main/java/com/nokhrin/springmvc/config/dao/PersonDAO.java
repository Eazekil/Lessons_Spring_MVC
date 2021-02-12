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
        people.add(new Person(++PEOPLE_COUNT,"Orion"));
        people.add(new Person(++PEOPLE_COUNT,"Saturn"));
        people.add(new Person(++PEOPLE_COUNT,"Pluto"));
        people.add(new Person(++PEOPLE_COUNT,"Jupiter"));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        Person showPerson=null;
        for(Person person:people){
            if(person.getId()==id)showPerson=person;
        }
        return showPerson;
    }
}
