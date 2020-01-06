package micronaut.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import micronaut.demo.controller.PersonController;
import micronaut.demo.model.Person;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@MicronautTest
class PersonControllerTest {

    @Inject
    EmbeddedServer embeddedServer;

    @Inject
    PersonController personController;

    @Test
    void testGetAllPersons() {
        Person person = new Person();
        person.setId(1);
        person.setName("Test Person");
        person.setSalary(10000);

        personController.addPerson(person);

        assertThat(personController.getPersons(), hasSize(1));
        assertThat(personController.getPersons(), Matchers.hasItem(person));
    }
}
