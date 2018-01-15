package be.groups.sandbox.customconstraintinjection;

import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner demo(UserRepository repository) {
    return (String... args) -> {
      // save a couple of customers
      repository.save(new User("Jack"));
      repository.save(new User("Chloe"));
      repository.save(new User("Kim"));
      repository.save(new User("David"));
      repository.save(new User("Michelle"));

      // fetch all customers
      log.info("Users found with findAll():");
      log.info("-------------------------------");
      for (User user : repository.findAll()) {
        log.info(user.toString());
      }
      log.info("");

      // fetch an individual user by ID
      User user = repository.findById(1L).orElse(null);
      log.info("User found with findOne(1L):");
      log.info("--------------------------------");
      log.info(user.toString());
      log.info("");

      // fetch customers by last name
      log.info("User found with findByLogin('Jack'):");
      log.info("--------------------------------------------");
      for (User bauer : repository.findByLogin("Jack")) {
        log.info(bauer.toString());
      }
      log.info("");

      log.info("Test Unique Login constraint");
      log.info("--------------------------------------------");
      try {
        repository.save(new User("Kim"));
      } catch (Exception e) {
        e.printStackTrace();
      }
    };
  }
}
