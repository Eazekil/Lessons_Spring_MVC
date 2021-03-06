package com.nokhrin.springmvc.config.dao;

import com.nokhrin.springmvc.config.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL="jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="itiscool";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Person> index(){
        List<Person> people=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            String SQL="SELECT * FROM Person";
            ResultSet resulrSet=statement.executeQuery(SQL);
            while(resulrSet.next()){
                Person person=new Person();
                person.setId(resulrSet.getInt("id"));
                person.setName(resulrSet.getString("name"));
                person.setAge(resulrSet.getInt("age"));
                person.setEmail(resulrSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person show(int id){
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }
    public void save(Person person){
        //person.setId(++PEOPLE_COUNT);
        //people.add(person);
        try {
            Statement statement=connection.createStatement();
            String SQL="INSERT INTO Person VALUES("+1+",'"+person.getName()+"',"+person.getAge()+",'"+person.getEmail()+"')";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(int id,Person updatedPerson){
        /*Person personToBeUpdated=show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());*/
    }
    public void delete(int id){
        //people.removeIf(p -> p.getId() ==id);
    }
}
