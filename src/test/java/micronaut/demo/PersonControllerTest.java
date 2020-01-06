package micronaut.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import micronaut.demo.client.PersonClient;
import micronaut.demo.model.Person;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@MicronautTest
public class PersonControllerTest {

    @Inject
    EmbeddedServer embeddedServer;

    @Inject
    PersonClient personClient;

    @Test
    public void testGetAllPersons() {
        Person person = new Person();
        person.setId(1);
        person.setName("Test Person");
        person.setSalary(10000);

        personClient.addPerson(person);

        assertThat(personClient.getPersons(), hasSize(1));
        assertThat(personClient.getPersons(), Matchers.hasItem(person));
    }
}
