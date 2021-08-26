package com.practicalTask.practicalTask_3_1_1.controller;

import com.practicalTask.practicalTask_3_1_1.model.User;
import com.practicalTask.practicalTask_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("userList", userService.getAll());

        return "admin/users/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.getById(id));

        return "admin/users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable Long id) {
        userService.update(user);

        return "redirect:/admin/userslist";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);

        return "redirect:/admin/userslist";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "admin/users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);

        return "redirect:/users/list";
    }
}
