package com.practicalTask.practicalTask_3_1_1.controller;

import com.practicalTask.practicalTask_3_1_1.model.User;
import com.practicalTask.practicalTask_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/users")
public class AdminApiController {
    private final UserService userService;

    @Autowired
    public AdminApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<User> list(ModelMap model) {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        try {
            userService.delete(id);
        } catch (Throwable e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> create(User user) {
        userService.create(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> update(User user, @PathVariable Long id) {
        userService.update(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}