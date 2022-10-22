package example.spring.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person,Person> {

  @Override
  public Person process(Person item) throws Exception {

    final String firstName = item.getFirstName().toUpperCase();
    final String lastName = item.getLastName().toUpperCase();

    final Person transformedPerson = new Person(firstName, lastName);;

    log.info("Converting ({}) into ({})",item,transformedPerson);

    return transformedPerson;

  }
}
