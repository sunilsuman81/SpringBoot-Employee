package com.sks.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sks.springboot.dao.UserRepository;
import com.sks.springboot.entity.User;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Show login page.
     */
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    /**
     * Handle login form submission using DB credentials.
     * @param username Username from form
     * @param password Password from form
     * @param model Model for error message
     * @return Redirect to employee list if success, else show login page with error
     */
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/employees/list";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
