package genaicorecorp.com.repository;

import genaicorecorp.com.entity.RegistrationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationLogRepository extends JpaRepository<RegistrationLog, Long> {
}
