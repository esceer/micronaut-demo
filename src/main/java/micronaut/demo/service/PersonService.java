package micronaut.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import micronaut.demo.model.Person;

@Singleton
public class PersonService {

    private Map<Integer, Person> mockDatabase = new HashMap<>();

    public void addPerson(Person person) {
        mockDatabase.put(person.getId(), person);
    }

    public Person getPerson(int id) {
        return mockDatabase.get(id);
    }

    public Collection<Person> getAllPersons() {
        return mockDatabase.values();
    }

    public void updatePerson(Person person) {
        mockDatabase.replace(person.getId(), person);
    }

    public void deletePerson(int id) {
        mockDatabase.remove(id);
    }
}
