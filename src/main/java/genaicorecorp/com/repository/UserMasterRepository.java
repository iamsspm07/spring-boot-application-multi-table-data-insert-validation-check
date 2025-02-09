package genaicorecorp.com.repository;

import genaicorecorp.com.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {
    boolean existsByUserMail(String userMail);
    boolean existsByUserNumber(String userNumber);
}
