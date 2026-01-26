package vlad.pr.projectCRUD.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.repository.UserRepository;

@AllArgsConstructor
@Service
public class RegistrationService {

    private final UserRepository userRepository;

    @Transactional
    public void register(User user) {
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }
}
