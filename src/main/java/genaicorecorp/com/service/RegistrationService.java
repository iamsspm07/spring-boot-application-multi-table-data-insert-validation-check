package genaicorecorp.com.service;

import genaicorecorp.com.dto.UserDTO;
import genaicorecorp.com.entity.*;
import genaicorecorp.com.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationService {

    private final UserMasterRepository userMasterRepo;
    private final RegistrationRepository registrationRepo;
    private final RegistrationLogRepository registrationLogRepo;
    private final UserRoleRepository userRoleRepo;
    private final UserProfessionRepository userProfessionRepo;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserMasterRepository userMasterRepo,
                               RegistrationRepository registrationRepo,
                               RegistrationLogRepository registrationLogRepo,
                               UserRoleRepository userRoleRepo,
                               UserProfessionRepository userProfessionRepo,
                               PasswordEncoder passwordEncoder) {
        this.userMasterRepo = userMasterRepo;
        this.registrationRepo = registrationRepo;
        this.registrationLogRepo = registrationLogRepo;
        this.userRoleRepo = userRoleRepo;
        this.userProfessionRepo = userProfessionRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDTO userDTO) {
        if (userMasterRepo.existsByUserMail(userDTO.getUserMail())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        if (userMasterRepo.existsByUserNumber(userDTO.getUserNumber())) {
            throw new IllegalArgumentException("Phone number already exists!");
        }

        UserRole role = userRoleRepo.findByRoleName(userDTO.getUserRole())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Role: " + userDTO.getUserRole()));

        UserProfession profession = userProfessionRepo.findByProfessionName(userDTO.getUserProfession())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Profession: " + userDTO.getUserProfession()));

        String encryptedPassword = passwordEncoder.encode(userDTO.getUserPassword());

        Registration registration = new Registration();
        registration.setUserName(userDTO.getUserName());
        registration.setUserMail(userDTO.getUserMail());
        registration.setUserPassword(encryptedPassword);
        registration.setUserNumber(userDTO.getUserNumber());
        registration.setUserRole(role);
        registration.setUserProfession(profession);
        registration.setCountry(userDTO.getCountry());
        registration.setCity(userDTO.getCity());
        registration.setRegistrationDate(LocalDateTime.now());
        registrationRepo.save(registration);

        UserMaster userMaster = new UserMaster();
        userMaster.setUserName(userDTO.getUserName());
        userMaster.setUserMail(userDTO.getUserMail());
        userMaster.setUserPassword(encryptedPassword);
        userMaster.setUserNumber(userDTO.getUserNumber());
        userMaster.setUserRole(role);
        userMaster.setUserProfession(profession);
        userMaster.setCountry(userDTO.getCountry());
        userMaster.setCity(userDTO.getCity());
        userMaster.setRegistrationDate(LocalDateTime.now());
        userMasterRepo.save(userMaster);

        RegistrationLog log = new RegistrationLog();
        log.setUserName(userDTO.getUserName());
        log.setUserMail(userDTO.getUserMail());
        log.setUserRole(role);
        log.setLogDate(LocalDateTime.now());
        registrationLogRepo.save(log);
    }
}
