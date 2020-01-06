package micronaut.demo.client;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import java.util.Collection;
import micronaut.demo.model.Person;

@Client("/person")
public interface PersonClient {

    @Get
    Collection<Person> getPersons();

    @Post("/add")
    HttpStatus addPerson(@Body Person person);
}
