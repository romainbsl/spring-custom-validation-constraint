package be.groups.sandbox.customconstraintinjection;

import javax.validation.*;
import org.springframework.beans.factory.annotation.*;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

   @Autowired
   private UserRepository userRepository;

   public boolean isValid(String login, ConstraintValidatorContext context) {
      return userRepository.countByLogin(login) == 0;
   }
}
