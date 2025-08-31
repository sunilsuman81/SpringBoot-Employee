package com.sks.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    /**
     * Show login page.
     */
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    /**
     * Handle login form submission with hardcoded credentials.
     * @param username Username from form
     * @param password Password from form
     * @param model Model for error message
     * @return Redirect to employee list if success, else show login page with error
     */
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/employees/list";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
