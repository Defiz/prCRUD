package vlad.pr.projectCRUD.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlad.pr.projectCRUD.dto.UserValidatorDto;
import vlad.pr.projectCRUD.dto.mapper.UserValidatorMapper;
import vlad.pr.projectCRUD.model.Role;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.repository.RoleRepository;
import vlad.pr.projectCRUD.repository.UserRepository;

import java.util.Set;

@AllArgsConstructor
@Service
public class RegistrationService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserValidatorMapper userValidatorMapper;

    @Transactional
    public void register(UserValidatorDto userDto) {
        User user = userValidatorMapper.toEntity(userDto);
        Role userRole = roleRepository.findByRole("ROLE_USER");
        user.setRoles(Set.of(userRole));
        userRepository.save(user);
    }
}
