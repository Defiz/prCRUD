package vlad.pr.projectCRUD.controller;

import lombok.AllArgsConstructor;
import vlad.pr.projectCRUD.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vlad.pr.projectCRUD.service.UserService;

@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users-list";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
    }

    @PatchMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
