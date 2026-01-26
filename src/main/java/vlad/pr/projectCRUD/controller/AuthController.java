package vlad.pr.projectCRUD.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.service.UserService;
import vlad.pr.projectCRUD.util.UserValidator;

@AllArgsConstructor
@Controller
public class AuthController {

    private final UserService userService;
    private final UserValidator userValidator;

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @Transactional
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
}
