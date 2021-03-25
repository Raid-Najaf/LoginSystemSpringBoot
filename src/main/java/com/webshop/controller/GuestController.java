package com.webshop.controller;

import com.webshop.service.UserService;
import com.webshop.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestController {

    @Autowired
    private UserService servDao;

    @GetMapping("/")
    public String showLoginPage(Model model) {

       model.addAttribute("user", new User());
//        model.addAttribute("title", "Home Page");

        return "/guesthomepage";
    }
    
    
    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {

        model.addAttribute("title", "Registration Page");

        model.addAttribute("user", new User());

        return "registration";
    }

    @PostMapping("/process")
    public String showSuccessPage(@Valid @ModelAttribute("user") User user, BindingResult result) {

//      user.setRole("ROLE_ADMIN");
        user.setRole("ROLE_USER");

        user.setPassword(servDao.enCryptedPassword(user));

        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "registration";
        } else {

            servDao.save(user);

        }

        return "login";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {

        model.addAttribute("title", "Login Page");

        return "login";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {

        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/adminhomepage";
        }

        return "redirect:/user/userhomepage";
    }

}
