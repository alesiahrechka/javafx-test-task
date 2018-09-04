package by.ales.service;

import by.ales.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonService {

    private ObservableList<Person> personList = FXCollections.observableArrayList();
    private List<String> firstNames;
    private List<String> lastNames;
    private List<String> roles;


    public PersonService() {
        this.firstNames = Arrays.asList("Amelia", "Olivia", "Isla", "Emily");
        this.lastNames = Arrays.asList("Abram", "Addington", "Adley", "Alby");
        this.roles = Arrays.asList("Manger", "Developer", "Janitor", "CEO");
    }

    public ObservableList<Person> getAllPersons() {
        return personList;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public Person generatePerson() {
        Random r = new Random();
        Person person = new Person();
        person.setFirstName(firstNames.get(r.nextInt(firstNames.size())));
        person.setLastName(lastNames.get(r.nextInt(lastNames.size())));
        person.setRole(roles.get(r.nextInt(roles.size())));
        person.setCounter(r.nextInt(10));

        return person;
    }


}
