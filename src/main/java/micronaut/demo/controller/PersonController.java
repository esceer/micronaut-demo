package micronaut.demo.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.Collection;
import javax.inject.Inject;
import micronaut.demo.model.Person;
import micronaut.demo.service.PersonService;

@Controller("/person")
public class PersonController {

    @Inject
    private PersonService personService;

    @Get
    public Collection<Person> getPersons() {
        return personService.getAllPersons();
    }

    @Post("/add")
    public HttpStatus addPerson(@Body Person person) {
        personService.addPerson(person);
        return HttpStatus.CREATED;
    }
}
