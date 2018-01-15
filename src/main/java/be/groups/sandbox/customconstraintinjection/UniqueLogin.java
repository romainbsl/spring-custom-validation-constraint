package be.groups.sandbox.customconstraintinjection;

import java.lang.annotation.*;
import javax.validation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueLoginValidator.class)
public @interface UniqueLogin {
  String message() default "{loginIsNotUnique}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
