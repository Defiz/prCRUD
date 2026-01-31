package vlad.pr.projectCRUD.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import vlad.pr.projectCRUD.dto.UserProfileDto;
import vlad.pr.projectCRUD.dto.UserRegistrationDto;
import vlad.pr.projectCRUD.model.Role;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.util.StringToRoleConvertor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserProfileMapper {

    private final StringToRoleConvertor stringToRoleConvertor;

    public Set<String> roleToString(Set<Role> roles) {
        return roles.stream()
                .map(Role::getRole)
                .collect(Collectors.toSet());
    }

    public Set<Role> stringToRole(Set<String> roles) {
        return roles.stream()
                .map(stringToRoleConvertor::convert)
                .collect(Collectors.toSet());
    }

    public User toEntity(UserProfileDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setRoles(stringToRole(dto.getRoles()));
        return user;
    }

    public UserProfileDto toDto(User user) {
        UserProfileDto userDto = new UserProfileDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(roleToString(user.getRoles()));
        return userDto;
    }
}
