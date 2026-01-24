package vlad.pr.projectCRUD.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import lombok.AllArgsConstructor;
import vlad.pr.projectCRUD.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlad.pr.projectCRUD.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(User user) {
        User userFromBase = userRepository.findById(user.getId()).orElse(null);
        userFromBase.setName(user.getName());
        userFromBase.setAge(user.getAge());
        userFromBase.setEmail(user.getEmail());
        userRepository.save(userFromBase);
    }
}
