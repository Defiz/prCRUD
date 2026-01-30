package vlad.pr.projectCRUD.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import vlad.pr.projectCRUD.dto.UserRestDto;
import vlad.pr.projectCRUD.model.Role;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.util.StringToRoleConvertor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserRestMapper {

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

    public User toEntity(UserRestDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(stringToRole(userDto.getRoles()));
        return user;
    }

    public UserRestDto toDto(User user) {
        UserRestDto userRestDto = new UserRestDto();
        userRestDto.setId(user.getId());
        userRestDto.setName(user.getName());
        userRestDto.setAge(user.getAge());
        userRestDto.setEmail(user.getEmail());
        userRestDto.setPassword(user.getPassword());
        userRestDto.setRoles(roleToString(user.getRoles()));
        return userRestDto;
    }
}
