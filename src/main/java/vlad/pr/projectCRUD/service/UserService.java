package vlad.pr.projectCRUD.service;

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

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }

    @Transactional
    public void createUser(User user) {
        user.setRole("ROLE_USER");
        userRepository.save(user);
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
        userFromBase.setPassword(user.getPassword());
        userFromBase.setRole(user.getRole());
        userRepository.save(userFromBase);
    }
}
