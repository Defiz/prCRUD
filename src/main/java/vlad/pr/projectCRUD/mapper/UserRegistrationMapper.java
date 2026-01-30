package vlad.pr.projectCRUD.mapper;

import org.springframework.stereotype.Component;
import vlad.pr.projectCRUD.dto.UserRegistrationDto;
import vlad.pr.projectCRUD.model.User;

@Component
public class UserRegistrationMapper {

    public User toEntity(UserRegistrationDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserRegistrationDto toDto(User user) {
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
