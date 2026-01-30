package vlad.pr.projectCRUD.mapper;

import org.springframework.stereotype.Component;
import vlad.pr.projectCRUD.dto.UserListDto;
import vlad.pr.projectCRUD.model.User;

import java.util.List;

@Component
public class UserListMapper {

    public User toEntity(UserListDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public UserListDto toDto(User user) {
        UserListDto userListDto = new UserListDto();
        userListDto.setId(user.getId());
        userListDto.setName(user.getName());
        userListDto.setAge(user.getAge());
        userListDto.setEmail(user.getEmail());
        return userListDto;
    }

    public List<UserListDto> toDtoList(List<User> users) {
        return users.stream()
                .map(this::toDto)
                .toList();
    }
}
