package be.groups.sandbox.customconstraintinjection;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByLogin(String login);
  int countByLogin(String login);
}
