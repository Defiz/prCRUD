package vlad.pr.projectCRUD.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vlad.pr.projectCRUD.security.UsersDetails;

@Controller
@RequestMapping("/profile")
public class UserController {

    @GetMapping
    public String profile(@AuthenticationPrincipal UsersDetails usersDetails, Model model) {
        model.addAttribute("user", usersDetails.getUser());
        return "profile-user";
    }
}
