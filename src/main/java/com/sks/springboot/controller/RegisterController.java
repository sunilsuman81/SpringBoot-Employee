package com.sks.springboot.controller;

import com.sks.springboot.dao.UserRepository;
import com.sks.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Show registration page.
     */
    @GetMapping
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Handle registration form submission.
     */
    @PostMapping
    public String registerUser(User user, Model model) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        userRepository.save(user);
        model.addAttribute("success", "Registration successful! You can now log in.");
        model.addAttribute("user", new User());
        return "register";
    }
}
