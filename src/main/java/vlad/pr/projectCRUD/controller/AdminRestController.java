package vlad.pr.projectCRUD.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlad.pr.projectCRUD.dto.UserListDto;
import vlad.pr.projectCRUD.dto.UserRestDto;
import vlad.pr.projectCRUD.service.RestUserService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/users")
public class AdminRestController {

    private final RestUserService restUserService;

    @GetMapping
    public List<UserListDto> getAllUsers() {
        return restUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserRestDto getUser(@PathVariable Integer id) {
        return restUserService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserRestDto> saveUser(@RequestBody UserRestDto userDto) {
        UserRestDto userCreate = restUserService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreate);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserRestDto> editUser(@PathVariable Integer id, @RequestBody UserRestDto userDto) {
        UserRestDto userUpdate = restUserService.updateUser(id, userDto);
        return ResponseEntity.ok(userUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        restUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
