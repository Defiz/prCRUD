package vlad.pr.projectCRUD.util;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import vlad.pr.projectCRUD.model.Role;
import vlad.pr.projectCRUD.service.UserService;

@AllArgsConstructor
@Component
public class StringToRoleConvertor implements Converter<String, Role> {

    private final UserService userService;

    @Override
    public Role convert(String source) {
        return userService.getRoleByName(source);
    }
}
