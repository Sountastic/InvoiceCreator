package javafx.invoicesys.repository;

import javafx.invoicesys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByUserCompanyName(String userCompanyName);
}
