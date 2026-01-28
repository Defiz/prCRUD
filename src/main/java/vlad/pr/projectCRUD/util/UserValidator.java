package vlad.pr.projectCRUD.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vlad.pr.projectCRUD.dto.UserValidatorDto;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.service.UserService;

@AllArgsConstructor
@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserValidatorDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserValidatorDto userDto = (UserValidatorDto) target;
      if (userService.existsByName(userDto.getName())) {
          errors.rejectValue("name", "" , "Пользователь с таким именем уже существует");
      }
    }
}
