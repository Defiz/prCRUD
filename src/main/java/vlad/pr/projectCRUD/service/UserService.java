package vlad.pr.projectCRUD.service;

import lombok.AllArgsConstructor;
import vlad.pr.projectCRUD.dto.UserValidatorDto;
import vlad.pr.projectCRUD.mapper.UserValidatorMapper;
import vlad.pr.projectCRUD.model.Role;
import vlad.pr.projectCRUD.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlad.pr.projectCRUD.repository.RoleRepository;
import vlad.pr.projectCRUD.repository.UserRepository;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserValidatorMapper userValidatorMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }

    public Role getRoleByName(String role) {
        return roleRepository.findByRole(role);
    }

    @Transactional
    public void createUser(UserValidatorDto userDto) {
        User user = userValidatorMapper.toEntity(userDto);
        Role role = roleRepository.findByRole("ROLE_USER");
        user.setRoles(Set.of(role));
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        User userFromBase = userRepository.findById(user.getId()).orElse(null);
        userFromBase.setName(user.getName());
        userFromBase.setAge(user.getAge());
        userFromBase.setEmail(user.getEmail());
        userFromBase.setPassword(user.getPassword());
        userFromBase.setRoles(user.getRoles());
        userRepository.save(userFromBase);
    }

    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
