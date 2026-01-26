package vlad.pr.projectCRUD.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.service.UserService;

@AllArgsConstructor
@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      User user = (User) target;
      if (userService.existsByName(user.getName())) {
          errors.rejectValue("name", "" , "Пользователь с таким именем уже существует");
      }
    }
}
