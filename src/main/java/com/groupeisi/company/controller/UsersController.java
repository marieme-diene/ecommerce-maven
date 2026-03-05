package com.groupeisi.company.controller;

import com.groupeisi.company.dto.UsersDto;
import com.groupeisi.company.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "users/list";
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UsersDto());
        return "users/form";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        UsersDto user = usersService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "users/form";
    }

    @PostMapping
    public String saveUser(@ModelAttribute UsersDto user) {
        if (user.getId() == null) {
            usersService.save(user);
        } else {
            usersService.update(user.getId(), user);
        }
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        usersService.deleteById(id);
        return "redirect:/users";
    }
}
