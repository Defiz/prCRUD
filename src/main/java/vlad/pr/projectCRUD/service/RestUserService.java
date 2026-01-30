package vlad.pr.projectCRUD.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlad.pr.projectCRUD.dto.UserListDto;
import vlad.pr.projectCRUD.dto.UserRestDto;
import vlad.pr.projectCRUD.mapper.UserListMapper;
import vlad.pr.projectCRUD.mapper.UserRestMapper;
import vlad.pr.projectCRUD.model.Role;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.repository.RoleRepository;
import vlad.pr.projectCRUD.repository.UserRepository;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class RestUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserListMapper userListMapper;
    private final UserRestMapper userRestMapper;

    public List<UserListDto> getAllUsers() {
        return userListMapper.toDtoList(userRepository.findAll());
    }

    public UserRestDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return userRestMapper.toDto(user);

    }

    @Transactional
    public UserRestDto createUser(UserRestDto userDto) {
        User user = userRestMapper.toEntity(userDto);
        Role role = roleRepository.findByRole("ROLE_USER");
        user.setRoles(Set.of(role));
        userRepository.save(user);
        return userRestMapper.toDto(user);
    }

    @Transactional
    public UserRestDto updateUser(Integer id, UserRestDto userDto) {
        User userFromBase = userRepository.findById(id).orElse(null);
        userFromBase.setName(userDto.getName());
        userFromBase.setAge(userDto.getAge());
        userFromBase.setEmail(userDto.getEmail());
        userFromBase.setPassword(userDto.getPassword());
        userFromBase.setRoles(userRestMapper.stringToRole(userDto.getRoles()));
        userRepository.save(userFromBase);
        return userRestMapper.toDto(userFromBase);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
