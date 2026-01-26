package vlad.pr.projectCRUD.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import vlad.pr.projectCRUD.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vlad.pr.projectCRUD.service.UserService;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin-list";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-user";
        }
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }

    @PatchMapping("/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-user";
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

}
