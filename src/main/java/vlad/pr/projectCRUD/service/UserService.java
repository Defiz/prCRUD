package vlad.pr.projectCRUD.service;

import lombok.AllArgsConstructor;
import vlad.pr.projectCRUD.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlad.pr.projectCRUD.repository.RoleRepository;
import vlad.pr.projectCRUD.repository.UserRepository;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }

    public Role getRoleByName(String role) {
        return roleRepository.findByRole(role);
    }
}
