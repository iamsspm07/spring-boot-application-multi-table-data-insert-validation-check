package genaicorecorp.com.repository;

import genaicorecorp.com.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	boolean existsByUserMail(String userMail);
    boolean existsByUserNumber(String userNumber);
}
