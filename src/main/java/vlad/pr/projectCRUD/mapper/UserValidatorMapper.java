package vlad.pr.projectCRUD.mapper;

import org.springframework.stereotype.Component;
import vlad.pr.projectCRUD.dto.UserValidatorDto;
import vlad.pr.projectCRUD.model.User;

@Component
public class UserValidatorMapper {

    public User toEntity(UserValidatorDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
