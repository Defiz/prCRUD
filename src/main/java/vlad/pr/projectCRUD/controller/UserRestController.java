package vlad.pr.projectCRUD.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vlad.pr.projectCRUD.dto.UserProfileDto;
import vlad.pr.projectCRUD.security.UsersDetails;
import vlad.pr.projectCRUD.service.RestUserService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final RestUserService restUserService;

    @GetMapping
    public UserProfileDto getUser(@AuthenticationPrincipal UsersDetails usersDetails) {
        return restUserService.getUserByName(usersDetails.getUsername());
    }
}
